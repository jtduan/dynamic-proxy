package code.demo.djt.acpectj;

import code.demo.djt.BookInterface;
import code.demo.djt.BookInterfaceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by djt on 1/23/16.
 */
public class Test
{
    public static void main( String[] args )
    {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookInterface book = (BookInterface)appContext.getBean(BookInterface.class);
        book.print();
        ((ClassPathXmlApplicationContext)appContext).close();
    }
}
