import java.util.Date;

public class Transaction {
    //The amount of this transaction.
    private double amount;
    //The time and date of this transaction
    private Date timestamp;
    //A remo for this transaction.
    private String memo;
    //The account in which the transaction was performed.
    private Account inAccount;


    /**
     Get the amount of the transaction
     @return the amount
     */
    public double getAmount() {
        return this.amount;
    }
}
