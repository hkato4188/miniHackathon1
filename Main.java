import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Step 1: Create scanner class and take in user input for sales reps last name
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Stra-tee-ger-eez miniHackathon submission!");
        System.out.println("Please enter a Sales Representative's last name to retrieve the associated data: ");
        String lastName = scanner.nextLine().toLowerCase().trim();

        //Step 2: Read data from SalesReps.csv to find userID associated with sales rep
        try{
            List<SalesRep> salesReps = CSVImporter.readSalesReps("./src/SalesReps.csv");
            List<Company> companies = CSVImporter.readCompanies("./src/Company.csv");
            Map<String, List<Company>> salesRepCompanies = new HashMap<>();
            salesRepCompanies = createRepToCompaniesMap(salesReps, companies);
            List<Company> associatedCompanies = salesRepCompanies.get(lastName);

            if (associatedCompanies != null) {
                String titleCaseLastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
                System.out.println("Buzz... Buzz...");
                System.out.println("Computing... Computing...");
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("Here are the companies associated with Sales Representative with the last name: " + titleCaseLastName);
                for (Company company : associatedCompanies) {
                    company.displayCompanyData();
                }
            } else {
                System.out.println("No companies found for Sales Rep with last name: " + lastName);
            }

            scanner.close();
        }catch(Exception e){
            System.out.println(e.getMessage().getClass());
        }
    }
    // Step 3:
    // Q: How do I want to interact with this program? helps with ideas on how to build function
    // A: Ultimately I want a function that I can call with a sales rep's lastName and returns the associated company data
    //    Paps are a great option here--although last names are not unique, it is fair to assume userIds are
    // Ex: salesRepCompanyInfoMap.get(repsLastName)
    //    This requires that we join the data of SalesReps.csv and Company.csv on the User Id/Sales Repid
    //    Result: we want a key->value mapping between the user Id and the associated Company object(s)--List in case plural
    //    1. Initialize a hashmap called salesRepCompaniesMap with a key of type String (sales rep  last name) and value of a List of Companies (all of the companies associated)
    //    2. Loop through every user in our SalesReps list
    //       a) For each iteration of every sales rep, loop through every company in the companies list
    //       b) If the current company's Sales Repid value is the same as the current sales reps User Id ADD IT TO THE MAP
    //       c) When adding to the map make sure the sales rep does not already exist in our map, if it does add to the existing list

    public static Map<String, List<Company>> createRepToCompaniesMap(List<SalesRep> salesReps, List<Company> companies) {
        Map<String, List<Company>> salesRepCompaniesMap = new HashMap<>();
        for (SalesRep salesRepresentative : salesReps) {
           // System.out.println("Hey we are currently iterating through our list of agents and are on: " + salesRepresentative.getLastName());
            for (Company company : companies) {
                // comparing the sales reps userId from SalesRep.csv with company's sales repid from Company.csv
                if (company.getSalesRepId().equals(salesRepresentative.getUserId())) {
                    // if we have a match...we add the last name as the key and a list of company/companies associated as the value
                    String key = salesRepresentative.getLastName().toLowerCase();
                    if (salesRepCompaniesMap.get(key) == null) {
                        salesRepCompaniesMap.put(key, new ArrayList<Company>());
                    }
                    salesRepCompaniesMap.get(key).add(company);
                }
            }
        }
        return salesRepCompaniesMap;
    }
}

