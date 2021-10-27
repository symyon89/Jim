package customer;

public class BuyAccess {

    public static Access weekAccess(){
        Access access;
        return access = () -> "1 week";
    }

    public static Access weekedAccess(){
        Access access;
        return access = () -> "weekend";
    }






}
