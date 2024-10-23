import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utility {
    // ONLY DOES READING AND WRITTING OF FILE


    public static boolean isValidPath(String filePath) {
        File file = new File(filePath);
        return file.exists() && file.isFile() && file.canRead();
    }

    public static List<String[]> readCSV(String filePath, int removeHeaderFlag) throws IOException {
        if (!isValidPath(filePath)) {
            System.out.println("INVALID PATH:" + filePath);
        }

        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            if (removeHeaderFlag == 1) line = br.readLine(); // remove headerline only
            while ((line = br.readLine()) != null) {
                String[] rows = line.split(",");
                data.add(rows);
            }
        }
        return data;
    }

    public static List<String[]> updateLineByLineCSV(String filePath) throws IOException {
        if (!isValidPath(filePath)) {
            System.out.println("INVALID PATH");
        }

        List<String[]> updateData = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] rows = line.split(",");
                for (int i = 0; i < rows.length; i++) {
                    if (rows[i].equalsIgnoreCase("null")) {
                        rows[i] = "";
                    }
                }
                updateData.add(rows);
            }
        }
        return updateData;
    }
}
