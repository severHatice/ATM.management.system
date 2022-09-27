import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        //init scanner
        Scanner sc=new Scanner(System.in);
        //init bank
        Bank theBank=new Bank("Bank of Drausin");

        //add a user which also creates a savings account
        User aUser = theBank.addUser("John","Doe","1234");

        //add a checking account for our user
        Account newAccount=new Account("Checking",aUser,theBank);
        aUser.addAccount(newAccount);
        theBank.addAccount(newAccount);

        User curUser;
        while(true){
            //stay in the login prompt until successfu login
            curUser=ATM.mainMenuPrompt(theBank,sc);

            //stay in main menu until user quits
            ATM.printUserMenu(curUser,sc);
        }
    }

    private static void printUserMenu(User theUser, Scanner sc) {
    //print a summary of the users accounts
        theUser.printAccountsSummary();
        //init
        int choice;

        //user menu
        do {
            System.out.printf("Welcome %s, what would you like to do?",
                    theUser.getFirstName());
            System.out.println(" 1) Show account transaction history");
            System.out.println(" 2) Withdrawl");
            System.out.println(" 3) Deposit");
            System.out.println(" 4) Transfer");
            System.out.println(" 5) Quit");
            System.out.println();
            System.out.println("Enter choice: ");
            choice=sc.nextInt();

            if(choice<1 || choice >5){
                System.out.println("invalid choice. Please choose 1-5");
            }
        }while(choice<1 || choice>5){
         //process the choice
            switch (choice){
                case 1:
                    ATM.showTransHistory(theUser,sc);
                    break;
                case 2:
                    ATM.withdrawlFunds(theUser, sc);
                    break;
                case 3:
                    ATM.depositEunds(theUser, sc);
                    break;
                case 4:
                    ATM.transferFunds(theUser, sc);
                    break;
            }
// redisplay this menu unless the user wants to quit
            if(choice!= 5){
            ATM.printUserMenu(theUser, sc);
        }
        }
    }

    public static User mainMenuPrompt(Bank theBank , Scanner sc){
        //inits
        String userID;
        String pin;
        User authUser;
        //prompt user for user ID/pin combo until a correct one is reached
        do{
            System.out.printf("\n\nWelcome to %s\n\n", theBank.getName());
            System.out.print("Enter user ID; ");
            userID=sc.nextLine();
            System.out.print("Enter pin: ");
            pin=sc.nextLine();

            //try to get the user obj corresponding to the ID and pin combo
            authUser=theBank.userLoggin(userID,pin);
            if(authUser==null){
                System.out.println("incorrect user ID/pin combination. "+
                        "please try again.");
            }
        }while(authUser==null);
        return authUser;
    }
}
