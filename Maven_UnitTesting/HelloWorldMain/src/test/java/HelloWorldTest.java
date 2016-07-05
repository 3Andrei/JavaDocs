import org.junit.Test;
import ro.teamnet.hello.HelloWorld;

/**
 * Created by Nicolescu on 05.07.2016.
 */
public class HelloWorldTest {

    @Test
    public void testSayHello(){
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.sayHello();
    }

    @Test
    public void testReturnHelloKey(){
        HelloWorld helloWorld = new HelloWorld();
        System.out.println("From Test: " + helloWorld.returnHelloKey());
        assert helloWorld.returnHelloKey().equals("HelloKey");
    }

}
