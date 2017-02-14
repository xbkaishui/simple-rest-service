package tbdp.expression;

import org.mvel2.MVEL;
import org.mvel2.ParserContext;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 简单表达式逻辑
 */
public class Expression implements Serializable{

    private Map<String, Object> expMap = new ConcurrentHashMap<String, Object>();
    private ExpressionContext   context;

    /**
     * 执行表达式
     * @param expression 表达式
     * @return
     */
    public Object eval(String expression) {
        return eval(expression, null);
    }

    /**
     * 执行表达式
     * @param expression 表达式
     * @param vars 变量
     * @return
     */
    public Object eval(String expression, Map<String, Object> vars) {
        Object o = compile(expression, context);
        return eval(o, vars);
    }

    /**
     * 执行表达式
     * @param exp 表达式
     * @param vars 变量
     * @return
     */
    public Object eval(Object exp, Map<String, Object> vars) {
        return MVEL.executeExpression(exp, vars);
    }

    /**
     * 编译表达式，编译后保存，防止重复编译
     * @param expression 表达式
     * @param pctx 表达式上下文，主要是可用函数
     * @return
     */
    public Object compile(String expression, ExpressionContext pctx) {
        Object o = expMap.get(expression);
        if (o == null) {
            o = MVEL.compileExpression(expression, pctx.getContext());
            expMap.put(expression, o);
        }
        return o;
    }

    public Set<String> analysisInputs(String exp){
        ParserContext pCtx = ParserContext.create();
        MVEL.analysisCompile(exp, pCtx);
        Map<String, Class> inputsMap = pCtx.getInputs();
        return inputsMap.keySet();
    }

    /**
     * Getter method for property <tt>context</tt>.
     *
     * @return property value of context
     */
    public ExpressionContext getContext() {
        return context;
    }

    /**
     * Setter method for property <tt>context</tt>.
     *
     * @param context value to be assigned to property context
     */
    public void setContext(ExpressionContext context) {
        this.context = context;
    }

}
