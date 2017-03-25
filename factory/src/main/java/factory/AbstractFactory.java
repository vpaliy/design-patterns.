package factory;

import entity.SoftwareEngineer;

public abstract class AbstractFactory {
    public abstract SoftwareEngineer create(String firstName, String lastName, String ID, int experience);
}
