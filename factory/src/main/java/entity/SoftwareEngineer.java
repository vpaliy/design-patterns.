package entity;

public abstract class SoftwareEngineer {
    private String firstName;
    private String lastName;
    private String ID;
    private int experience;

    public SoftwareEngineer(String firstName, String lastName, String ID, int experience){
        this.firstName=firstName;
        this.lastName=lastName;
        this.ID=ID;
        this.experience=experience;
    }

    public int getExperience() {
        return experience;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getID() {
        return ID;
    }

    public String getLastName() {
        return lastName;
    }

    public abstract boolean acceptInvitation(JobInvitation invitation);
}
