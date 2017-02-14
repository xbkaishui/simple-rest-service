package tbdp.expression;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.mvel2.ParserContext;
import org.mvel2.util.MethodStub;

public class ExpressionContext implements Serializable {

    private ParserContext context;

    public ExpressionContext() {
        context = new ParserContext();
    }

    public void registFunc(String func, Method method) {
        context.addImport(func, method);
    }

    public void registFunc(Class<?> clz) {
        Method[] methods = clz.getDeclaredMethods();
        for (Method method : methods) {
            int mod = method.getModifiers();
            if (Modifier.isStatic(mod) && Modifier.isPublic(mod)) {
                registFunc(method.getName(), method);
            }
        }
    }

    public void registFunc(String func, MethodStub method) {
        context.addImport(func, method);
    }

    /**
     * Getter method for property <tt>context</tt>.
     *
     * @return property value of context
     */
    public ParserContext getContext() {
        return context;
    }

}
