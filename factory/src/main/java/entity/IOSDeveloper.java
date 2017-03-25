package entity;

public class IOSDeveloper extends SoftwareEngineer {

    public IOSDeveloper(String firstName, String lastName, String ID, int experience){
        super(firstName,lastName,ID,experience);
    }

    @Override
    public boolean acceptInvitation(JobInvitation invitation) {
        return false;
    }
}
