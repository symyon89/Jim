package Customer;

public class Customer{
    private String firstname;
    private String lasttname;
    private long cnp;
    private String mail;
    private long phoneNumber;

    public Customer(String firstname, String lasttname, long cnp, String mail, long phoneNumber) {
        this.firstname = firstname;
        this.lasttname = lasttname;
        this.cnp = cnp;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLasttname() {
        return lasttname;
    }

    public long getCnp() {
        return cnp;
    }

    public String getMail() {
        return mail;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }
}
