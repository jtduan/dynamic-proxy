package code.demo.djt.cglib;

/**
 * Created by djt on 1/23/16.
 */
import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 使用cglib动态代理
 *
 * @author student
 *
 */
public class CglibProxy implements MethodInterceptor {
    private Object target;

    /**
     * 创建代理对象
     *
     * @param target the target
     * @return instance
     */
    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {
        System.out.println("Proxy begin...");
        proxy.invokeSuper(obj, args);
        System.out.println("Proxy end...");
        return null;


    }

}