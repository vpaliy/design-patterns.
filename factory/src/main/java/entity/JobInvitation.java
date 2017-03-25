package entity;


public class JobInvitation {
    private int professionalExp=1;
    private double salary=40; //per hour
    private boolean isContract=false;
    private boolean isFullTime=true;
    private String location;
    private String description;

    private JobInvitation(Builder builder){
        this.professionalExp=builder.professionalExp;
        this.salary=builder.salary;
        this.isContract=builder.isContract;
        this.location=builder.location;
        this.description=builder.description;
        this.isFullTime=builder.isFullTime;
    }

    public static class Builder {
        private int professionalExp=1;
        private double salary=40; //per hour
        private boolean isContract=false;
        private boolean isFullTime=true;
        private String location;
        private String description;

        public Builder(String location, String description){
            this.location=location;
            this.description=description;
        }

        public Builder seLocation(String location){
            this.location=location;
            return this;
        }

        public Builder setDescription(String description){
            this.description=description;
            return this;
        }

        public Builder setSalary(double salary){
            this.salary=salary;
            return this;
        }

        public Builder setExperience(int experience){
            this.professionalExp=experience;
            return this;
        }

        public Builder setFullTime(boolean isFullTime) {
            this.isContract=!isFullTime;
            this.isFullTime=isFullTime;
            return this;
        }

        //it's probably redundant
        public Builder setContract(boolean isContract) {
            return setFullTime(!isContract);
        }

        public JobInvitation build(){
            return new JobInvitation(this);
        }
    }

    public double getSalary() {
        return salary;
    }

    public int getProfessionalExp() {
        return professionalExp;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

}
