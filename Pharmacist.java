public class Pharmacist extends User {

    protected String staffName;

    public Pharmacist(String hospitalID)
    {
        super(hospitalID);
        
    }

    private String displayStaffName(Administrator admin)
    {
        return admin.getStaffName(hospitalID, this);
    }


    
    protected void displayMenu() {
        Administrator admin = new Administrator(hospitalID);
        staffName = displayStaffName(admin);
        System.out.println("Welcome Pharmacist, "+ staffName);
        System.out.println("---- Pharmacist Menu ----");
        System.out.println("1. View Appointment Outcome Record");
        System.out.println("2. Update Prescription Status");
        System.out.println("3. View Medication Inventory");
        System.out.println("4. Submit Replenishment Request");
        System.out.println("5. Logout");
        System.out.print("Enter your choice: ");
    }
    
    
}
