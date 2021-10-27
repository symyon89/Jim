package customer;

public class Customer{
    private String firstname;
    private String lasttname;
    private long cnp;
    private String mail;
    private long phoneNumber;
    private int balance; //credits


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

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLasttname(String lasttname) {
        this.lasttname = lasttname;
    }

    public void setCnp(long cnp) {
        this.cnp = cnp;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void addBalance(int balance){
        this.balance +=balance;
    }

    public int getBalance() {
        return balance;
    }
}
