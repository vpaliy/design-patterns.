package factory;

import entity.AndroidDeveloper;
import entity.SoftwareEngineer;

public class AndroidFactory extends AbstractFactory {
    @Override
    public AndroidDeveloper create(String firstName, String lastName, String ID, int experience) {
        return new AndroidDeveloper(firstName,lastName,ID,experience);
    }
}
