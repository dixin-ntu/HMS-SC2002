import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Administrator extends User {
 
    protected String staffName;
    private List<String[]> allStaff;
    private boolean isSecretUser;

    public Administrator(String hospitalID, boolean isSecretUser)
    {
        super(hospitalID);
        this.isSecretUser = isSecretUser;
        
    }

    
    protected void displayMenu() {
        boolean isLoggedIn = true;
        while (isLoggedIn && isValidStaff())
        {
            System.out.println("---- Administrator Menu ----");
            System.out.println("1. View and Manage Hospital Staff");
            System.out.println("2. View Appointments Details");
            System.out.println("3. View and Manage Medication Inventory");
            System.out.println("4. Approve Replenishment Requests");
            System.out.println("5. Logout");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1: displayStaff(allStaff); break;

                case 5: System.out.println("You have logged out."); isLoggedIn = false; break;
                    
            
                default:
                    break;
            }
        }
    }

    private void displayStaff(List<String[]> allStaff)
    {
        for (String[] staffRow:allStaff)
        {
            System.out.println("StaffID: " + staffRow[0] + ", Name: " + staffRow[1] + ", Role: " + staffRow[2] +
            ", Gender: " + staffRow[3] + ", Age: " + staffRow[4]);
        }
    }

    private boolean isValidStaff ()
    {   
        allStaff = getStaff(this);
        if (isSecretUser)
        {
            System.out.println("\nWelcome Administrator, SECRET");
            return true;
        }
        for (String[] staffRow:allStaff)
        {
            if(staffRow[0].equals(hospitalID))
            {
                String displayName = staffRow[1];
                System.out.println("\nWelcome Administrator, " + displayName);
                return true;
            }
        }
        System.out.println("Access denied: Invalid staff credentials.");
        return false;

    }






}
