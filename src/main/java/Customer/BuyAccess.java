package Customer;

public class BuyAccess {
    Access access;


    public void weekAccess(){
        this.access = () -> "1 week";
    }

    public void weekedAccess(){
        this.access = () -> "weekend";
    }






}
