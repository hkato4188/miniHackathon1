
class SalesRep {
    private String userId;
    private String firstName;
    private String lastName;

    public SalesRep(String userId, String firstName, String lastName) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUserId() {
        return userId;
    }

    public String getLastName() {
        return lastName;
    }
}