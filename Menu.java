import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        User user = new User();
        Menu menu = new Menu();

        menu.menuRole(user);

        
    }

    //neccessary declaration
    Scanner sc = new Scanner(System.in);
    int choice;



    //display menu based on user role
    public void menuRole(User user)
    {
        switch(user.getRole())
        {
            case "Doctor": displayDoctorMenu(); break;

            case "Pharmacist": displayPharmacistMenu(); break;

            case "Administrator": displayAdminMenu(); break;

            case "Patient": displayPatientMenu(); break;

            default: System.out.println("No such Menu for this role");

        }
    }

    public int validateChoice()
    {
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input! Enter your choice:");
            sc.next();
        }
        return sc.nextInt();

    }


    public void displayPatientMenu() {
        do{
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
            System.out.print("Enter your choice: ");

            choice = validateChoice();
            switch (choice)
            {
                case 1: break;
                case 2: break;
                case 3: break;
                case 4: break;
                case 5: break;
                case 6: break;
                case 7: break;
                case 8: break;
                case 9:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice!=9);
    }

    public void displayDoctorMenu() {
        do
        {
            System.out.println("---- Doctor Menu ----");
            System.out.println("1. View Patient Medical Records");
            System.out.println("2. Update Patient Medical Records");
            System.out.println("3. View Personal Schedule");
            System.out.println("4. Set Availability for Appointments");
            System.out.println("5. Accept or Decline Appointment Requests");
            System.out.println("6. View Upcoming Appointments");
            System.out.println("7. Record Appointment Outcome");
            System.out.println("8. Logout");
            System.out.print("Enter your choice: ");

            choice = validateChoice();
            switch (choice)
            {
                case 1: break;
                case 2: break;
                case 3: break;
                case 4: break;
                case 5: break;
                case 6: break;
                case 7: break;
                case 8:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice!=8);
    }

    public void displayPharmacistMenu() {
        do
        {
            System.out.println("---- Pharmacist Menu ----");
            System.out.println("1. View Appointment Outcome Record");
            System.out.println("2. Update Prescription Status");
            System.out.println("3. View Medication Inventory");
            System.out.println("4. Submit Replenishment Request");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");

            choice = validateChoice();
            switch (choice)
            {
                case 1: break;
                case 2: break;
                case 3: break;
                case 4: break;
                case 5:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }while (choice!=5);
    }

    public void displayAdminMenu() {

        do
        {
            System.out.println("---- Administrator Menu ----");
            System.out.println("1. View and Manage Hospital Staff");
            System.out.println("2. View Appointments Details");
            System.out.println("3. View and Manage Medication Inventory");
            System.out.println("4. Approve Replenishment Requests");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");

            choice = validateChoice();
            switch (choice)
            {
                case 1: break;
                case 2: break;
                case 3: break;
                case 4: break;
                case 5:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }while (choice!=5);


    }


    
}
