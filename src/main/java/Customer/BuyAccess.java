package Customer;

public class BuyAccess {

    public Access weekAccess(){
        Access access;
        return access = () -> "1 week";
    }

    public Access weekedAccess(){
        Access access;
        return access = () -> "weekend";
    }






}
