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

//    @Override
//    public String toString() {
//        return "Organization ID: " + organizationId + "\n" +
//                "Company Name: " + name + "\n" +
//                "Country: " + country + "\n" +
//                "Industry: " + industry + "\n" +
//                "Number of Employees: " + numberOfEmployees + "\n";
//    }
}