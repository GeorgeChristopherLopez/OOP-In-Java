import java.util.*;
public class Program
{
	public static void main(String[] args) {
    	TechnicalLead CTO = new TechnicalLead("Satya Nadella");
        SoftwareEngineer seA = new SoftwareEngineer("Kasey");
        SoftwareEngineer seB = new SoftwareEngineer("Breana");
        SoftwareEngineer seC = new SoftwareEngineer("Eric");
        CTO.addReport(seA);
        CTO.addReport(seB);
        CTO.addReport(seC);
        seA.setCodeAccess(true);
        seA.checkInCode();
        seB.checkInCode();
        seC.checkInCode();
        System.out.println(CTO.getTeamStatus());
        
        TechnicalLead VPofENG = new TechnicalLead("Bill Gates");
        SoftwareEngineer seD = new SoftwareEngineer("Winter");
        SoftwareEngineer seE = new SoftwareEngineer("Libby");
        SoftwareEngineer seF = new SoftwareEngineer("Gizan");
        SoftwareEngineer seG = new SoftwareEngineer("Zaynah");
        VPofENG.addReport(seD);
        VPofENG.addReport(seE);
        VPofENG.addReport(seF);
        VPofENG.addReport(seG);
        System.out.println(VPofENG.getTeamStatus());
        
        BusinessLead CFO = new BusinessLead("Amy Hood");
        Accountant actA = new Accountant("Niky");
        Accountant actB = new Accountant("Andrew");
        CFO.addReport(actA, CTO);
        CFO.addReport(actB, VPofENG);
        System.out.println(CFO.getTeamStatus());
        
        // check codes
     
        // approve budgets
        
        
	}
}

 public  class Employee {
    private String name;
    private double baseSalary;
    private int employeeID;
    static int numEmployees;
    static double bonusBudget;
    private Employee manager;
    
    public Employee(String name, double baseSalary)	{
    // Should construct a new employee object and take in two parameters, one for the name of the user and one for their base salary
    
    this.name = name;
    this.baseSalary = baseSalary;
    numEmployees++;
    this.employeeID = numEmployees;
    }
    
    public double getBaseSalary() {
    // Should return the employee's current salary
    return this.baseSalary;
    }
    
    public String getName()	{
    // Should return the employee's current name  
    return this.name;
    }
    
    public int getEmployeeID() {
    // Should return the employee's ID. The ID should be issued on behalf of the employee at the time they are constructed. The first ever employee should have an ID of "1", the second "2" and so on  
    return this.employeeID;
    }
    
    public Employee getManager(){
    // Should return a reference to the Employee object that represents this employee's manager
    return this.manager;
    }
    public void setManager(Employee other){
        this.manager = other;
    }
    public boolean equals(Employee other){
    if(this.employeeID== other.employeeID)
    return true;
    else
    return false;
    }
    
    public String toString(){
    //Should return a String representation of the employee that is a combination of their id followed by their name. Example: "1 Kasey"  
    return this.name;
    }
    
    public String employeeStatus(){
    // Should return a String representation of that Employee's current status. This will be different for every subclass of Employee
    return this.getEmployeeID() + " " + this.name + ", salary: "+ this.getBaseSalary();
    }	
}



public  class TechnicalEmployee extends Employee {
     private int numCheckIns;
  
       
     public TechnicalEmployee (String name) {
         //Has a default base salary of 75000
     super(name, 75000);
     numCheckIns = 0;
        
     }
 
   
    public double getBaseSalary() {
    // Should return the employee's current salary
    return super.getBaseSalary();
    }
    
    public int getNumCheckIns(){
    // returns numcheckins
    return this.numCheckIns;
    }
    
    public boolean checkInCode(){
     this.numCheckIns++;
     return true;
    }
     public String employeeStatus(){
        //Should return a String representation of this TechnicalEmployee that includes their ID, name and how many successful check ins they have had. Example: "1 Kasey has 10 successful check ins"
        return super.employeeStatus() + " has " +this.getNumCheckIns()+" succesful checkins";
    
    }	
}



    public  class BusinessEmployee extends Employee {
    private double bonusBudget;
      
    public BusinessEmployee (String name) {
         super(name, 50000);
    }
    
    public double getBaseSalary() {
    // Should return the employee's current salary
    return super.getBaseSalary();
    }
    
    public double getBonusBudget(){
    //Should establish a running tally of the remaining bonusBudget for the team this employee supports. How that budget is determined will depend on which type of Business Employee it is
        return this.bonusBudget;
    }	
      public void setBonusBudget(double amt){
    //*************************************************************
    // sets budget
    this.bonusBudget = amt;
    }
    public void upBonusBudget(double amt){
    //*************************************************************
    // sets budget
    this.bonusBudget += amt;
    }	
    
    public String employeeStatus(){
     // Should return a String representation of this BusinessEmployee that includes their ID, name and the size of their currently managed budget. Example: "1 Kasey with a budget of 22500.0"
     return super.employeeStatus() + " with a budget of "+ this.getBonusBudget();
    }
}



    public class SoftwareEngineer extends TechnicalEmployee{
        private boolean accessToCode;
       
        public SoftwareEngineer(String name) {
        //Should start without access to code and with 0 code check ins
        super(name);
        setCodeAccess(false);
        }
        
        public boolean getCodeAccess()	{
                //Should return whether or not this SoftwareEngineer has access to make changes to the code base
           return this.accessToCode;     
        }
        
        public void setCodeAccess(boolean access)	{
         //Should allow an external piece of code to update the SoftwareEngieer's code privileges to either true or false   
            this.accessToCode = access;
        }
        
        public int getSuccessfulCheckIns()	{
         //Should return the current count of how many times this SoftwareEngineer has successfully checked in code   
         return super.getNumCheckIns();
        }
        public void setManager(TechnicalLead t){
            super.setManager(t);
        }
        public boolean checkInCode()	{
        //Should check if this SoftwareEngineer's manager approves of their check in. If the check in is approved their successful checkin count should be increased and the method should return "true". If the manager does not approve the check in the SoftwareEngineer's code access should be changed to false and the method should return "false"
      
       
       if (((TechnicalLead) this.getManager()).approveCheckIn(this)) {
           
            return super.checkInCode();
        } else {
            
            return false;
        }
        
    
        }
            
    public String employeeStatus(){
     // 
     return super.employeeStatus();
    }
    }



    public class TechnicalLead extends TechnicalEmployee {
        private int headCount;
        private ArrayList<Employee> directReports;
        
        public TechnicalLead (String name) {
            //Should create a new TechnicalLead that is a Manager. The TechnicalLead's base salary should be 1.3 times that of a TechnicalEmployee. TechnicalLeads should have a default head count of 4.
            super( name);
            this.getBaseSalary();
            
            this.headCount = 4;
            this.directReports = new ArrayList<Employee>(4);
          
        }
        
        public double getBaseSalary (){
            return super.getBaseSalary()*1.3;
        }
        
        public boolean hasHeadCount() {
            if(this.directReports.size() < headCount)
            return true;
            else
            //	Should return true if the number of direct reports this manager has is less than their headcount.
            return false;
        }
        
        public boolean addReport(SoftwareEngineer e) {
            //Should accept the reference to a SoftwareEngineer object, and if the TechnicalLead has head count left should add this employee to their list of direct reports. If the employee is successfully added to the TechnicalLead's direct reports true should be returned, false should be returned otherwise
          if(this.hasHeadCount()){
                this.directReports.add(e);
                e.setManager(this);
                return true;
            } else {
                return false;
            }
           
           
        }	
        
        public boolean approveCheckIn(SoftwareEngineer e){
            //	Should see if the employee passed in does report to this manager and if their code access is currently set to "true". If both those things are true, true is returned, otherwise false is returned
         if(e.getManager().equals(this) && e.getCodeAccess()){//Should see if the employee passed in does report to this manager and if their code access is currently set to "true".  If both those things are true, true is returned, otherwise false is returned
            super.checkInCode();
            return true;
        } else {
            return false;
        }
        }
        
        public boolean requestBonus(Employee e, double bonus){
            //	Should check if the bonus amount requested would be approved by the BusinessLead supporting this TechnicalLead. If it is, that employee should get that bonus and true should be returned. False should be returned otherwise
            System.out.println(this.getManager());
            return false;
        }
        public ArrayList<Employee> getDirectReports(){
            return this.directReports;
        }
        public String getTeamStatus()	{
         //Should return a String that gives insight into this Manager and all their direct reports. It should return a string that is a combination of the TechnicalLead's employee status followed by each of their direct employee's status on subsequent lines. If the TechnicalLead has no reports it should print their employee status followed by the text " and no direct reports yet ". Example: "10 Kasey has 5 successful check ins and no direct reports yet". If the TechnicalLead does have reports it might look something like "10 Kasey has 5 successful check ins and is managing: /n 5 Niky has 2 successful check ins"
             String team = "";
            if(directReports.size() >0){
               
                for (int i = 0; i < this.directReports.size(); i++) 
                team+="\n"+(directReports.get(i).employeeStatus());
             } else {
               team = "and no direct reports yet "; 
                 
             }
            
        
            return "Team Lead: "+this.employeeStatus() + "\nManaging: " +team;
        }  
            
    public String employeeStatus(){
     // Should return a String representation of this BusinessEmployee that includes their ID, name and the size of their currently managed budget. Example: "1 Kasey with a budget of 22500.0"
     return super.employeeStatus();
    }
        
        
    }


    public class Accountant extends BusinessEmployee {
        private TechnicalLead teamSupported;
        
        public Accountant(String name){
            //Should start with a bonus budget of 0 and no team they are officially supporting
            super(name);
            this.setBonusBudget(0);
        
        }	
        public TechnicalLead getTeamSupported(){
            //Should return a reference to the TechnicalLead that this Accountant is currently supporting. If they have not been assigned a TechnicalLead null should be returned
           if(this.teamSupported!=null)
            return this.teamSupported;
           else
            return null;
        }	
        public void supportTeam(TechnicalLead lead){
            //Should allow a reference to a TechnicalLead to be passed in and saved. Once this happens the Accountant's bonus budget should be updated to be the total of each SoftwareEngineer's base salary that reports to that TechnicalLead plus 10%. For example, if the TechnicalLead supports 2 SoftwareEngineers, each with a salary of 75000, the Accountant's budget should be 150000 + 15000 for a total of 165000
            this.teamSupported = lead;
            double total = 0;
            System.out.println(lead.getDirectReports());
            for(int i = 0; i < lead.getDirectReports().size(); i++){
            
            total += ((lead.getDirectReports().get(i).getBaseSalary()) * 1.1);
            }
            this.setBonusBudget(total);
       
        }	
        public boolean approveBonus(double bonus){
            //Should take in a suggested bonus amount and check if there is still enough room in the budget. If the bonus is greater than the remaining budget, false should be returned, otherwise true. If the accountant is not supporting any team false should be returned.
        return false;
            
        }	
        public String employeeStatus(){
            //Should return a String representation of this Accountant that includes their ID, name, the size of their currently managed budget and the name of the TechnicalLead they are currently supporting. Example: "1 Kasey with a budget of 22500.0 is supporting Satya Nadella"
           return super.employeeStatus() +" is supporting "+ this.getTeamSupported(); 
        }	
    }



    public class BusinessLead extends BusinessEmployee {
        private int headCount;
        private ArrayList<Employee> directReports;
     
       public BusinessLead(String name)	{
        //Should create a new BusinessLead that is a Manager. The BusinessLead's base salary should be twice that of an Accountant. They should start with a head count of 10.   
           super(name);
           this.getBaseSalary();
           
           this.headCount = 10;
            this.directReports = new ArrayList<Employee>(10);
       }
          public double getBaseSalary (){
            return super.getBaseSalary()*2;
        }
       public boolean hasHeadCount(){
       //	Should return true if the number of direct reports this manager has is less than their headcount.   
         if(this.directReports.size() < headCount)
            return true;
            else
            //	Should return true if the number of direct reports this manager has is less than their headcount.
            return false;
        }
       
        public boolean addReport(Accountant a, TechnicalLead supportTeam)	{
         //Should accept the reference to an Accountant object, and if the BusinessLead has head count left should add this employee to their list of direct reports. If the employee is successfully added to the BusinessLead's direct reports true should be returned, false should be returned otherwise. Each time a report is added the BusinessLead's bonus budget should be increased by 1.1 times that new employee's base salary. That employee's team they are supporting should be updated to reflect the reference to the TechnicalLead given. If the employee is successfully added true should be returned, false otherwise.   
         
            if(this.hasHeadCount()){
                this.directReports.add(a);
                a.setManager(this);
                a.supportTeam(supportTeam);
                super.upBonusBudget(1.1 * a.getBaseSalary());
                return true;
            } else {
                return false;
            }
           
        }
        public boolean requestBonus(Employee e, double bonus){
            //Should check if the bonus amount requested would fit in current BusinessLead's budget. If it is, that employee should get that bonus, the BusinessLeader's budget should be deducted and true should be returned. False should be returned otherwise
            return false;
        }	

        public boolean approveBonus(Employee e, double bonus){
            //This function should look through the Accountants the BusinessLead manages, and if any of them are supporting a the TechnicalLead that is the manager of the Employee passed in then the Accountant's budget should be consulted to see if the bonus could be afforded. If the team can afford the bonus it should be rewarded and true returned, false otherwise
            return false;
        }
                public String getTeamStatus()	{
         //Should return a String that gives insight into this Manager and all their direct reports. It should return a string that is a combination of the TechnicalLead's employee status followed by each of their direct employee's status on subsequent lines. If the TechnicalLead has no reports it should print their employee status followed by the text " and no direct reports yet ". Example: "10 Kasey has 5 successful check ins and no direct reports yet". If the TechnicalLead does have reports it might look something like "10 Kasey has 5 successful check ins and is managing: /n 5 Niky has 2 successful check ins"
             String team = "";
             for (int i = 0; i < this.directReports.size(); i++) {
            team+="\n"+(directReports.get(i).employeeStatus());
             }
        
            return "Team Lead: "+this.employeeStatus() + "\nManaging: " +team;
        }  
          
        public String employeeStatus(){
        // Should return a String representation of this Accountant that includes their ID, name, the size of their currently managed budget and the name of the TechnicalLead they are currently supporting. Example: "1 Kasey with a budget of 22500.0 is supporting Satya Nadella"
        return super.employeeStatus();
        }
    }