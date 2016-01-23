package code.demo.djt;

import code.demo.djt.cglib.CglibProxy;
import code.demo.djt.jdkdynamicproxy.BookFacadeProxy;
import org.junit.Test;

/**
 * Created by djt on 1/23/16.
 */
public class TestCase {

    @Test
    public void test_cglib() {
        System.out.println("begin cglib test");
        System.out.println("**************************");
        CglibProxy cglib = new CglibProxy();
        BookInterface bookCglib = (BookInterfaceImpl) cglib.getInstance(new BookInterfaceImpl());
        bookCglib.print();
    }

    @Test
    public void test_jdk_proxy() {
        System.out.println("begin jdk_proxy test");
        System.out.println("**************************");
        BookFacadeProxy proxy = new BookFacadeProxy();
        BookInterface bookProxy = (BookInterface) proxy.bind(new BookInterfaceImpl());
        bookProxy.print();
    }
}
