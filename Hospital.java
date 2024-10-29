import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Hospital {

    protected String hospitalID;

    private static final String STAFF_FILE_PATH = "./Data/Staff_List.csv";
    private static final String PATIENT_FILE_PATH = "./Data/Patient_List.csv";
    private static final String MEDICINE_FILE_PATH = "./Data/Medicine_List.csv";

    private List<String[]> staffList;
    private List<String[]> patientList;
    private List<String[]> medicineList;

    public Hospital()
    {
    
    }

    private static List<String[]> loadStaff()
    {
        List<String[]> allStaff = new ArrayList<>();

        try {
            allStaff = Utility.readCSV(STAFF_FILE_PATH,1);
        } 
        catch (IOException e) {
            System.out.println("Error in loadStaff" + e.getMessage());
        }

        return allStaff;
    }

    private static List<String[]> loadPatients() {
        List<String[]> allPatients = new ArrayList<>();
        try {
            allPatients = Utility.readCSV(PATIENT_FILE_PATH, 1);
        } catch (IOException e) {
            System.out.println("Error in loadPatients: " + e.getMessage());
        }

        return allPatients;
    }

    private List<String[]> loadPatientByID(String patientID) {
        List<String[]> Patient = new ArrayList<>();
        try {
            List<String[]> allPatients = Utility.readCSV(PATIENT_FILE_PATH, 1);
            for (String[] patientRow : allPatients) {
                if (patientRow[0].equals(patientID)) {
                    Patient.add(patientRow); 
                    break; 
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading patient" + patientID + ": " + e.getMessage());
        }
        return Patient;
    }

    private static List<String[]> loadMedicine() {
        List<String[]> allMedicine = new ArrayList<>();
        try {
            allMedicine = Utility.readCSV(MEDICINE_FILE_PATH, 1);
        } catch (IOException e) {
            System.out.println("Error in loadPatients: " + e.getMessage());
        }

        return allMedicine;
    }


    protected List<String[]> getStaff(User user)
    {
        if (user instanceof Administrator) return loadStaff();
        
        else throw new SecurityException("Access denied");
    }

    protected List<String[]> getPatient(User user)
    {
        if (user instanceof Doctor) return loadPatients();

        else throw new SecurityException("Access denied");

    }

    protected List<String[]> getPatientByID(String patientID, User user)
    {
        if (user instanceof Patient) return loadPatientByID(patientID);

        else throw new SecurityException("Access denied");

    }

    protected List<String[]> getMedicine(User user)
    {
        if (user instanceof Pharmacist) return loadMedicine();

        else if(user instanceof Administrator) return loadMedicine();

        else throw new SecurityException("Access denied");

    }







    



}
