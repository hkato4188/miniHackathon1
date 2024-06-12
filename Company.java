public class Company {
    private String orgId;
    private String salesRepId;
    private String name;
    private String country;
    private String industry;
    private String numberOfEmployees;

    // Constructor, getters, and setters
    public Company(String orgId, String salesRepId, String name, String country, String industry, String numberOfEmployees) {
        this.orgId = orgId;
        this.salesRepId = salesRepId;
        this.name = name;
        this.country = country;
        this.industry = industry;
        this.numberOfEmployees = numberOfEmployees;
    }

    public String getSalesRepId() { return salesRepId; }
    public String getOrgId() { return orgId; }
    public String getName() { return name; }
    public String getCountry() { return country; }
    public String getIndustry() { return industry; }
    public String getNumberOfEmployees() { return numberOfEmployees; }


    public void displayCompanyData() {
        System.out.println("Company name: " + this.getName());
        System.out.println("Country: " + this.getCountry());
        System.out.println("Industry : " + this.getIndustry());
        System.out.println("Number of employees: " + this.getNumberOfEmployees());
        System.out.println("Company organization ID: " + this.getOrgId());
    }
}