package tbdp.common;

import tbdp.expression.Expression;
import tbdp.expression.ExpressionContext;
import tbdp.expression.Functions;

import java.io.Serializable;

/**
 * Created by xbkaishui on 16/12/24.
 * 执行上下文
 */
public class ExecutionContext implements Serializable{

    private Expression expression;

    private static final ExecutionContext instance = new ExecutionContext();

    private ExecutionContext() {
        initExpression();
    }

    private void initExpression() {
        ExpressionContext context = new ExpressionContext();
        context.registFunc(Functions.class);
        expression = new Expression();
        expression.setContext(context);
    }

    public static ExecutionContext instance() {
        return instance;
    }

    public Expression getExpression() {
        return expression;
    }

}
