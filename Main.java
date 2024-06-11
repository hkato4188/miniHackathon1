import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

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
            List<SalesRep> salesReps = readSalesReps("./src/SalesReps.csv", lastName);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    // Method to read SalesRep data from a CSV file
    private static List<SalesRep> readSalesReps(String filePath, String lastName) throws IOException {
        List<SalesRep> salesReps = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            String line;
            br.readLine(); // Skip header that contains fields of csv file
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                System.out.println("comparing " + lastName + " to " + parts[2].trim());
                System.out.println("Do they match? " + lastName.compareTo(parts[2].trim()));
                if(lastName.compareTo(parts[2].trim()) == 0){
                    System.out.println("we have a match! " + parts[0].trim() +" " + parts[1].trim() +" " + parts[2].trim());
                    salesReps.add(new SalesRep(parts[0].trim(), parts[1].trim(), parts[2].trim()));
                }
            }
            System.out.println("Sorry we do not have data on that Sales Rep!");
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
}

