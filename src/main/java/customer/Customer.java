package customer;

public class Customer{
    private String firstname;
    private String lasttname;
    private String cnp;
    private String phoneNumber;
    private String access;

    public Customer(String firstname, String lasttname, String cnp, String phoneNumber,String access) {
        this.firstname = firstname;
        this.lasttname = lasttname;
        this.cnp = cnp;
        this.phoneNumber = phoneNumber;
        this.access = access;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLasttname() {
        return lasttname;
    }

    public void setLasttname(String lasttname) {
        this.lasttname = lasttname;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    @Override
    public String toString() {
        return  "firstname='" + firstname + '\'' +
                ", lasttname='" + lasttname + '\'' +
                ", cnp='" + cnp + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", access='" + access + '\'';
    }
}
