import java.util.ArrayList;
import java.util.Random;

public class Bank {

    private String name;
    private ArrayList <User> users;
    private ArrayList <Account> accounts;

    //create a new Banl obj with empty lists of users and accounts
    //@param name the name of bank
    public Bank(String name){
        this.name=name;
        this.users=new ArrayList<User>();
        this.accounts=new ArrayList<Account>();
    }

    public String getNewUserUUID(){
// inits
        String uuid;
        Random rng=new Random();
        int len = 6;
        boolean nonUnique;
// continug looping until we get a unique ID
        do {
// generate the number
            uuid ="";
            for(int c =0; c< len; c ++) {
                uuid += ((Integer)rng.nextInt(10)).toString();
            }
// check to make sure it's unique
            nonUnique=false;
            for (User u:this.users) {
                if(uuid.compareTo(u.getUUID()) == 0){
                    nonUnique= true;
                    break;
                }}
            }while (nonUnique);
            return uuid;

    }
    public String getNewAccountUUID(){
            // inits
            String uuid;
            Random rng=new Random();
            int len = 10;
            boolean nonUnique;
// continug looping until we get a unique ID
            do {
// generate the number
                uuid ="";
                for(int c =0; c< len; c ++) {
                    uuid += ((Integer)rng.nextInt(10)).toString();
                }
// check to make sure it's unique
                nonUnique=false;
                for (Account a:this.accounts) {
                    if(uuid.compareTo(a.getUUID()) == 0){
                        nonUnique= true;
                        break;
                    }}
                }while (nonUnique);
                return uuid;

            }

    public void addAccount(Account anAcct){

        this.accounts.add(anAcct);
    }
    public User addUser(String firstName, String lastName, String pin)
    {
// create a new User object and add it to our list
        User newuser = new User(firstName, lastName, pin, this);
        this.users.add(newuser);
// create a savings account for the user
        Account newAccount = new Account("Savings", newuser, this);
        newuser.addAccount(newAccount);
        this.addAccount(newAccount);
        return newuser;
    }
    //get the user obj associated with the particular userId and pin, if they are valid
    //@param userID the UUID of the user to log in
    //@param pin= pin of the user
    //return the user obj if the login is successful or nul if it is not
    public User userLoggin(String userID, String pin){
        //search throuh list of users
       for(User u:this.users){
           //check user ID is correct
           if(u.getUUID().compareTo(userID)==0 && u.validatePin(pin)){
               return u;
           }
       }
       //we havent found the user or have an incorrect pin
       return null;
    }
    public String getName(){
        return this.name;
    }




}
