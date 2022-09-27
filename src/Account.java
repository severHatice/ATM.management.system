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
    public String getUUID(){
      return this.uuid;
    }
    /* Get summary line for the account X
*@return the string summary
*/
    public String getSummaryLine(){
// get the account's balance.
        double balance=this.getBalance();
// format the summary line, depending on the whether the balance is
// negative
        if(balance>=0){
            return String.format("%s : $%.02f : %s", this.uuid, balance,
                    this.name);
        }else{
            return String.format("%s : $(%.02f) : %s", this.uuid, balance,
                    this.name);
        }
    }
    public double getBalance(){
        double balance= 0;
        for (Transaction t : this.transactions){
            balance=t.getAmount();
        }
        return balance;
    }
}
