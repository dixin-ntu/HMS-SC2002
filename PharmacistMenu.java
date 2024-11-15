import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PharmacistMenu {

    private static final String CSV_FILE_PATH = "./Data/Medicine_List.csv";

    public void viewMedicationInventory() {
        System.out.println("Viewing medication inventory...\n");
        System.out.printf("%-15s %-15s %-15s %-20s %-20s %-20s%n",
                "Medicine Name", "Initial Stock", "Current Stock",
                "Low Stock Level Alert", "Request Replenishment", "Replenishment Approved");

        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // Skip the header row
                    continue;
                }

                String[] values = line.split(",");
                if (values.length == 6) {
                    System.out.printf("%-15s %-15s %-15s %-20s %-20s %-20s%n",
                            values[0], values[1], values[2], values[3], values[4], values[5]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    public void submitReplenishmentRequest(String medicineName, int replenishmentAmount) {
        List<String[]> csvData = new ArrayList<>();
        boolean medicineFound = false;

        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            boolean isFirstLine = true;

            // Read all lines from the file
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                
                // Check if it's the header row
                if (isFirstLine) {
                    isFirstLine = false;
                } else {
                    // Check if the current row matches the medicine name
                    if (values[0].equalsIgnoreCase(medicineName)) {
                        values[4] = String.valueOf(replenishmentAmount); // Update the fifth column
                        medicineFound = true;
                        System.out.println("Replenishment request updated for " + medicineName + " to " + replenishmentAmount);
                    }
                }

                // Add row to in-memory data structure
                csvData.add(values);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }

        if (!medicineFound) {
            System.out.println("Medicine " + medicineName + " not found in inventory.");
            return;
        }

        // Write updated data back to the file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_FILE_PATH))) {
            for (String[] row : csvData) {
                bw.write(String.join(",", row));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }
}
