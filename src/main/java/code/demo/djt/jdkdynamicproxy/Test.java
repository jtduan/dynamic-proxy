package code.demo.djt.jdkdynamicproxy;

import code.demo.djt.BookInterface;
import code.demo.djt.BookInterfaceImpl;

public class Test {
    public static void main(String[] args) {
        BookFacadeProxy proxy = new BookFacadeProxy();
        BookInterface bookProxy = (BookInterface) proxy.bind(new BookInterfaceImpl());
        bookProxy.print();
    }
}
