package code.demo.djt.cglib;

import code.demo.djt.BookInterface;
import code.demo.djt.BookInterfaceImpl;

public class Test {
    public static void main(String[] args) {
        CglibProxy cglib=new CglibProxy();
        BookInterface bookCglib=(BookInterfaceImpl)cglib.getInstance(new BookInterfaceImpl());
        bookCglib.print();
    }
}
