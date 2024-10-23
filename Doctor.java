public class Doctor extends User {


    protected String staffName;

    public Doctor(String hospitalID)
    {
        super(hospitalID);
        
    }

    private String displayStaffName(Administrator admin)
    {
        return admin.getStaffName(hospitalID, this);
    }

    public static void main(String[] args) {
        Doctor d = new Doctor("D001");
        d.displayMenu();
    }

    
    protected void displayMenu() {
        Administrator admin = new Administrator(hospitalID);
        staffName = displayStaffName(admin);
        System.out.println("Welcome Doctor, "+ staffName);
        System.out.println("---- Doctor Menu ----");
        System.out.println("1. View Patient Medical Records");
        System.out.println("2. Update Patient Medical Records");
        System.out.println("3. View Personal Schedule");
        System.out.println("4. Set Availability for Appointments");
        System.out.println("5. Accept or Decline Appointment Requests");
        System.out.println("6. View Upcoming Appointments");
        System.out.println("7. Record Appointment Outcome");
        System.out.println("8. Logout");
    }
    
}
