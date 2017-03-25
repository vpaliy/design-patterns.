package entity;

public class AndroidDeveloper extends SoftwareEngineer{

    public AndroidDeveloper(String firstName, String lastName, String ID, int experience){
        super(firstName,lastName,ID,experience);
    }

    @Override
    public boolean acceptInvitation(JobInvitation invitation) {
        return false;
    }
}
