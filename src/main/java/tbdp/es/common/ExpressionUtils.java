package tbdp.es.common;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.mvel2.ParserContext;
import org.mvel2.ast.ASTNode;
import org.mvel2.ast.BinaryOperation;
import org.mvel2.ast.LiteralNode;
import org.mvel2.compiler.CompiledExpression;
import org.mvel2.compiler.ExpressionCompiler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xbkaishui on 17/2/18.
 */
public class ExpressionUtils {

    private static final Logger logger = Logger.getLogger(ExpressionUtils.class);

    public static List<EsQueryField> parseRuleContext(String exp) {
        List<EsQueryField> result = new ArrayList<>();
        if (StringUtils.isNotEmpty(exp)) {
            ExpressionCompiler compiler = new ExpressionCompiler(exp);
            //            ParserContext context = compiler.getParserContextState();
            CompiledExpression compiledExpression = compiler.compile();
            ASTNode node = compiledExpression.getFirstNode();
            if (node instanceof BinaryOperation) {
                BinaryOperation opNode = (BinaryOperation) node;
                int opra = opNode.getOperation();
                ASTNode rightNode = opNode.getRight();
                ASTNode leftNode = opNode.getLeft();
                Operator operator = Operator.getByVal(opra);
                if (leftNode instanceof BinaryOperation) {
                    EsQueryField field = evalBinaryNode((BinaryOperation) leftNode, true);
                    result.add(field);
                    Object value = rightNode.getLiteralValue();
                    field = new EsQueryField(field.getName(), value, operator);
                    result.add(field);
                } else {
                    Object value;
                    String name;
                    if (leftNode instanceof LiteralNode) {
                        value = leftNode.getLiteralValue();
                        name = rightNode.getName();
                    } else {
                        name = leftNode.getName();
                        value = rightNode.getLiteralValue();
                    }
                    EsQueryField field = new EsQueryField(name, value, operator);
                    result.add(field);
                }
            }
        }
        return result;
    }

    private static EsQueryField evalBinaryNode(BinaryOperation binaryNode, boolean reverse) {
        Object value = binaryNode.getLeft().getLiteralValue();
        String name = binaryNode.getRight().getName();
        Operator operator = Operator.getByVal(binaryNode.getOperation());
        if (reverse) {
            operator = operator.reverse();
        }
        return new EsQueryField(name, value, operator);
    }

}
