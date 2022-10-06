package awesomecucumber.domainobjects;

public class BillingDetails {
    private String billingFirstName;
    private String billingLastName;
    private String billingAddress1;
    private String billingCity;
    private String billingStateName;
    private String billingZip;
    private String billingEmail;

    public BillingDetails(String billingFirstName, String billingLastName, String billingAddress1,
                          String billingCity, String billingStateName, String billingZip,
                          String billingEmail) {
        this.billingFirstName = billingFirstName;
        this.billingLastName = billingLastName;
        this.billingAddress1 = billingAddress1;
        this.billingCity = billingCity;
        this.billingStateName = billingStateName;
        this.billingZip = billingZip;
        this.billingEmail = billingEmail;
    }

    public String getBillingLastName() {
        return billingLastName;
    }

    public void setBillingLastName(String billingLastName) {
        this.billingLastName = billingLastName;
    }

    public String getBillingAddress1() {
        return billingAddress1;
    }

    public void setBillingAddress1(String billingAddress1) {
        this.billingAddress1 = billingAddress1;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getBillingStateName() {
        return billingStateName;
    }

    public void setBillingStateName(String billingStateName) {
        this.billingStateName = billingStateName;
    }

    public String getBillingZip() {
        return billingZip;
    }

    public void setBillingZip(String billingZip) {
        this.billingZip = billingZip;
    }

    public String getBillingEmail() {
        return billingEmail;
    }

    public void setBillingEmail(String billingEmail) {
        this.billingEmail = billingEmail;
    }

    public String getBillingFirstName() {
        return billingFirstName;
    }

    public void setBillingFirstName(String billingFirstName) {
        this.billingFirstName = billingFirstName;
    }
}
