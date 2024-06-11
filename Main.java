import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        //Step 1: Create scanner class and take in user input for sales reps last name
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Stra-tee-ger-eez miniHackathon submission!");
        System.out.println("Please enter a Sales Representative's last name to retrieve the associated data: ");
        String lastName = scanner.nextLine().trim();

        //Step 2: Read data from SalesReps.csv to find userID associated with sales rep
        try{
            List<SalesRep> salesReps = readSalesReps("./src/SalesReps.csv");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        // Method to read SalesRep data from a CSV file


    }
    private static List<SalesRep> readSalesReps(String filePath) throws IOException {
        List<SalesRep> salesReps = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    System.out.println(parts[0].trim() +" " + parts[1].trim() +" " + parts[2].trim());
                    //salesReps.add(new SalesRep(parts[0].trim(), parts[1].trim(), parts[2].trim()));
                }
            }
        }
        return salesReps;
    }
}

