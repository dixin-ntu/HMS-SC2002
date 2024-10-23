public class Patient extends User {
    

    protected String staffName;

    public Patient(String hospitalID)
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
        System.out.println("Welcome Patient, "+ staffName);
        System.out.println("---- Patient Menu ----");
        System.out.println("1. View Medical Record");
        System.out.println("2. Update Personal Information");
        System.out.println("3. View Available Appointment Slots");
        System.out.println("4. Schedule an Appointment");
        System.out.println("5. Reschedule an Appointment");
        System.out.println("6. Cancel an Appointment");
        System.out.println("7. View Scheduled Appointments");
        System.out.println("8. View Past Appointment Outcome Records");
        System.out.println("9. Logout");
    }

}
