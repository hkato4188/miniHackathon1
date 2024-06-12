import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVImporter {

    // Method to read SalesRep data from a CSV file
    // Removed lastName parameter and comparison check per discussion

    public static List<SalesRep> readSalesReps(String filePath) throws IOException {
        List<SalesRep> salesReps = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            String line;
            br.readLine(); // Skip header that contains fields of csv file
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                salesReps.add(new SalesRep(parts[0].trim(), parts[1].trim(), parts[2].trim()));
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if (br!=null){
                try{
                    br.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        return salesReps;
    }

    // Method to read Company data from a CSV file
    // Automatic resource management using Try with resource
    // We instantiate the BufferedReader inside the parentheses
    public static List<Company> readCompanies(String filePath) throws IOException {
        List<Company> companies = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] values = splitCSVLine(line);
                //System.out.println(values[1] + " " + values[2] + " " + values[3] + " " + values[5] + " " + values[8] + " " + values[9]);
                //System.out.println("The type of value for employees is: " + " " + values[9].getClass().getName());
                        String orgId = values[1].trim();        // Organization Id
                        String salesRepId = values[2].trim();   // Sales Repid
                        String name = values[3].trim();         // Name
                        String country = values[5].trim();      // Country
                        String industry = values[8].trim();     // Industry
                        String employeeNum = values[9].trim();                       //Number of employees
                Company company = new Company(orgId, salesRepId, name, country, industry, employeeNum);
                companies.add(company);
            }
        }
        return companies;
    }


    private static String[] splitCSVLine(String line) {
        List<String> values = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean withinQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '"') {
                withinQuotes = !withinQuotes;
            } else if (c == ',' && !withinQuotes) {
                values.add(sb.toString());
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }

        values.add(sb.toString()); // Add the last part
        return values.toArray(new String[0]);
    }

}
