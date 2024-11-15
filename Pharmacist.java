import java.util.Scanner;

public class Pharmacist extends User {

    protected String staffName;
    private PharmacistMenu menu;

    public Pharmacist(String hospitalID)
    {
        super(hospitalID);
        this.menu = new PharmacistMenu(); // Association with PharmacistMenu
    }

    private String displayStaffName(Administrator admin)
    {
        return admin.getStaffName(hospitalID, this);
    }
    
    protected void displayMenu() {
        Administrator admin = new Administrator(hospitalID);
        staffName = displayStaffName(admin);
        System.out.println("Welcome Pharmacist, " + staffName);
        System.out.println("---- Pharmacist Menu ----");
        System.out.println("1. View Appointment Outcome Record");
        System.out.println("2. Update Prescription Status");
        System.out.println("3. View Medication Inventory");
        System.out.println("4. Submit Replenishment Request");
        System.out.println("5. Logout");

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAppointmentOutcomeRecord();
                    break;
                case 2:
                    updatePrescriptionStatus();
                    break;
                case 3:
                    viewMedicationInventory();
                    break;
                case 4:
                    submitReplenishmentRequest();
                    break;
                case 5:
                    System.out.println("Logging out...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    // Placeholder methods to demonstrate functionality
    private void viewAppointmentOutcomeRecord() {
        System.out.println("Viewing appointment outcome record...");
        // Add logic here to retrieve and display data
    }

    private void updatePrescriptionStatus() {
        System.out.println("Updating prescription status...");
        // Add logic here to update prescription status
    }

    private void viewMedicationInventory() {
        System.out.println("Viewing medication inventory...");
        menu.viewMedicationInventory(); // Delegates call to PharmacistMenu (Association)
    }

    private void submitReplenishmentRequest() {
        System.out.println("Submitting replenishment request...");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the medicine name: ");
        String medicineName = scanner.nextLine();
        System.out.print("Enter the replenishment amount: ");
        int amount = scanner.nextInt();
        menu.submitReplenishmentRequest(medicineName, amount); // Delegates call to PharmacistMenu (Association)
        System.out.println("Replenishment request submitted...");
        scanner.close();
    }
    
}
