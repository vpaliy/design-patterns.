package factory;

import entity.AndroidDeveloper;
import entity.IOSDeveloper;

public class IOSFactory extends AbstractFactory {
    @Override
    public IOSDeveloper create(String firstName, String lastName, String ID, int experience) {
        return new IOSDeveloper(firstName,lastName,ID,experience);
    }
}
