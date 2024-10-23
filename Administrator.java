import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Administrator extends User {

    private static final String FILE_PATH = "./Data/Staff_List.csv";
 
    protected String staffName; 

    public Administrator(String hospitalID)
    {
        super(hospitalID);
        
    }

    private List<String[]> loadStaff()
    {
        List<String[]> allStaff = new ArrayList<>();

        try {
            allStaff = Utility.readCSV(FILE_PATH,1);
        } 
        catch (IOException e) {
            System.out.println("Error in loadStaff from Administrator" + e.getMessage());
        }

        for (String[] staffRow : allStaff) {

            String staffID = staffRow[0];
            String name = staffRow[1];
            String role = staffRow[2];
            String gender = staffRow[3];
            String age = staffRow[4];
        }

        return allStaff;
    }


    
    protected void displayMenu() {
        this.staffName = loadStaffName(hospitalID);
        System.out.println("Welcome Administrator, "+ staffName);
        System.out.println("---- Administrator Menu ----");
        System.out.println("1. View and Manage Hospital Staff");
        System.out.println("2. View Appointments Details");
        System.out.println("3. View and Manage Medication Inventory");
        System.out.println("4. Approve Replenishment Requests");
        System.out.println("5. Logout");
    }

    private void displayStaff(List<String[]> allStaff)
    {
        for (String[] staffRow:allStaff)
        {
            System.out.println("StaffID: " + staffRow[0] + ", Name: " + staffRow[1] + ", Role: " + staffRow[2] +
            ", Gender: " + staffRow[3] + ", Age: " + staffRow[4]);
        }
    }

    private String loadStaffName (String staffID)
    {
        List<String[]> allStaff = loadStaff();

        for (String[] staffRow:allStaff)
        {
            if(staffRow[0].equals(staffID))
            {
                return staffRow[1];
            }
        }

        return "Staff is not found";

    }


    protected String getStaffName(String staffID, User requester)
    {
        if(requester == null) return "Access Denied";

        return loadStaffName(staffID);
    }

}
