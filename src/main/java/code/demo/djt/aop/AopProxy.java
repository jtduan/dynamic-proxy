package code.demo.djt.aop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by djt on 1/23/16.
 */
@Component
public class AopProxy implements MethodBeforeAdvice,AfterReturningAdvice {

    public void before(Method mtd, Object[] arg1, Object arg2)
            throws Throwable {
        System.out.println("proxy begin！");
    }

    public void afterReturning(Object arg0, Method arg1, Object[] arg2,
                               Object arg3) throws Throwable {
        System.out.println("proxy end！");
    }

}

