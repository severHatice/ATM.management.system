import java.util.ArrayList;
public class User {
    private String firstName;
    private String lastName;
    private String uuid;
    //The MDS hash of the user's pin number.
    private byte pinHash[];
    //* The list of accounts for this user.
    private ArrayList<Account> account;


}
