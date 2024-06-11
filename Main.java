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
            List<SalesRep> salesReps = CSVImporter.readSalesReps("./src/SalesReps.csv");
            List<Company> companies = CSVImporter.readCompanies("./src/Company.csv");
            System.out.println("Yes! We did it");
        }catch(Exception e){
            System.out.println(e.getMessage().getClass());
        }
    }


}

