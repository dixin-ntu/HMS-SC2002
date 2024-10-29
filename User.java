import java.io.IOException;
import java.util.Scanner;

public abstract class User extends Hospital {

    //ASSIGNING ROLES BASED ON LOGIN DETAILS
    
    protected String hospitalID;
    protected String name;

    public User(String hospitalID) {
        super();
        this.hospitalID = hospitalID;
    }

    //ABSTRACT//
    protected abstract void displayMenu();

    //GETTER//
    public String getHospitalID() {
        return hospitalID;
    }

    //SETTER//
    

    //CONSTRUCTOR//
    public static User assignRole(String hospitalID, String role) {
        switch (role) {
            case "Patient":
                 return new Patient(hospitalID);
            case "Doctor":
                 return new Doctor(hospitalID);
            case "Pharmacist":
                 return new Pharmacist(hospitalID);
            case "Administrator":
                return new Administrator(hospitalID,false);
            default:
                throw new IllegalArgumentException("Unknown role: " + role);
        }
    }

    public static User login(String hospitalID, String role, UserCredentials credentials) {
        Scanner sc = new Scanner(System.in);

        if (credentials.isMustChangePass()) {
            System.out.println("You must change your password:");
            String newPassword;

            do {
                System.out.print("Enter new password: ");
                newPassword = sc.nextLine();

            } while (!validPass(newPassword, credentials));
            credentials.setMustChangePass(false);
            System.out.println("Password changed successfully.");
        }

        return assignRole(hospitalID, role);
    }


    public static boolean validPass(String newPassword, UserCredentials credentials) {
        if (newPassword.length() >= 8) {
            credentials.setPassword(newPassword);
            return true;
        } else {
            System.out.println("Password must be at least 8 characters long.");
            return false;
        }
    }

}
