public  class TechnicalEmployee extends Employee {
    private int numCheckIns;

    public TechnicalEmployee (String name) {
        super(name, 75000);

    }



    public String employeeStatus(){
        //Should return a String representation of this TechnicalEmployee that includes their ID, name and how many successful check ins they have had. Example: "1 Kasey has 10 successful check ins"
        return super.employeeStatus() + " " + this.numCheckIns;

    }
}
