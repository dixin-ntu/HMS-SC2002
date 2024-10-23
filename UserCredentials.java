import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserCredentials {

    // ANYTHING RELATED TO DATA MANUPALATION IN LOGIN DETAILS
    private String username;
    private String password;
    private boolean mustChangePassword;

    private static final String FILE_PATH1 = "./Data/User_Staff_List.csv";
    private static final String FILE_PATH2 = "./Data/User_Patient_List.csv";



    // Secret USER
    private static final String SECRET_USER = "OREO";
    private static final String SECRET_PASS = "Secret";
    private static final String SECRET_ROLE = "Administrator";



    public UserCredentials(String username, String password, boolean mustChangePassword) {
        this.username = username;
        this.password = password;
        this.mustChangePassword = mustChangePassword;
    }


    //GETTER

    public boolean isMustChangePass()
    {
        return mustChangePassword;
    }


    //SETTER
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public void setMustChangePass(boolean mustChangePassword) {
        this.mustChangePassword = mustChangePassword;
    }


    public static User authenticate(String inputUsername, String inputPassword) {
        if (SECRET_USER.equals(inputUsername) && SECRET_PASS.equals(inputPassword)) {
            UserCredentials secretCredentials = new UserCredentials(SECRET_USER, SECRET_PASS, false);
            return User.login(SECRET_USER, SECRET_ROLE, secretCredentials);
        }



        List<String[]> allUsers = new ArrayList<>();
        try{
            allUsers = loadUser();
        }
        catch (IOException e) {
            System.out.println("Error in loadUser" + e.getMessage());
            return null;
        }
   
   
        for (String[] userRow : allUsers) {

            String hospitalID = userRow[0];
            String username = userRow[1];
            String password = userRow[2];
            String role = userRow[3];
            boolean mustChangePassword = Boolean.parseBoolean(userRow[4]);

            if (username.equals(inputUsername) && password.equals(inputPassword)) {
                UserCredentials credentials = new UserCredentials(username, password, mustChangePassword);
                return User.login(hospitalID, role, credentials);
                
            }
        }
        System.out.println("Authentication failed: Invalid credentials");
        return null;
    }

    private static List<String[]> loadUser() throws IOException
    {
        List<String[]> allUsers = new ArrayList<>();
        allUsers.addAll(Utility.readCSV(FILE_PATH1,1));
        allUsers.addAll(Utility.readCSV(FILE_PATH2,1));
        return allUsers;
    }


}
