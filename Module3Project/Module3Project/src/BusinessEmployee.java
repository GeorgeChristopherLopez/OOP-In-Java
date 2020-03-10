public  class BusinessEmployee extends Employee {
    private double bonusBudget;

    public BusinessEmployee (String name) {
        super(name,50000);

    }

    public double getBonusBudget(){
        //Should establish a running tally of the remaining bonusBudget for the team this employee supports. How that budget is determined will depend on which type of Business Employee it is
        return this.bonusBudget;
    }
    public String employeeStatus(){
        // 	Should return a String representation of this BusinessEmployee that includes their ID, name and the size of their currently managed budget. Example: "1 Kasey with a budget of 22500.0"
        return super.employeeStatus() + " with a budget of "+ this.getBonusBudget();
    }
}
