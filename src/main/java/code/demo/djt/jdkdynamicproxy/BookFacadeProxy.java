package code.demo.djt.jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 * 只能代理实现接口的类
 */
public class BookFacadeProxy implements InvocationHandler {
    private Object target;

    /**
     * Bind object.
     *
     * @param target the target
     * @return the object
     */
    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    /**
     * Invoke object.
     *
     * @param proxy  the proxy
     * @param method the method
     * @param args   the args
     * @return the object
     * @throws Throwable the throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        Object result=null;
        System.out.println("Proxy begin...");
        result=method.invoke(target, args);
        System.out.println("Proxy end...");
        return result;
    }

}