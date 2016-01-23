package code.demo.djt;

import org.springframework.stereotype.Component;

/**
 * Created by djt on 1/23/16.
 */
@Component
public class BookInterfaceImpl implements BookInterface {
    public void print() {
        System.out.println("bookInterface...");
    }
}
