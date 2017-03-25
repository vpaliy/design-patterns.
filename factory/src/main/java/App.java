import factory.AbstractFactory;
import factory.AndroidFactory;
import factory.IOSFactory;

public class App {
    public static void main(String[] args){
        final String firstName="Vasyl";
        final String lastName="Paliy";
        AbstractFactory[] factories=new AbstractFactory[]{new AndroidFactory(),new IOSFactory()};

    }
}
