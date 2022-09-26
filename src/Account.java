import java.util.ArrayList;

public class Account {

    private String name;

    private String uuid;
    //The User object that owns this account.
    private User holder;
    //The list of transactions for this account.
    private ArrayList <Transaction> transactions;//islem

    public Account(String name, User holder, Bank theBank) {
// set the account name and holder
        this.name = name;
        this.holder = holder;
// get new account UUID
        this.uuid = theBank.getNewAccountUUID();
// init transactions
        this.transactions = new ArrayList<Transaction>();
// add to holder and bank lists.
        holder.addAccount(this);
        theBank.addAccount(this);
    }
}
