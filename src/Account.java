public class Account {
    public String name;
    public double balance;
    private Customer owner;
    private static int ID = 1000; //sets an initial amount for the ID number

    //account constructor
    public Account(String name, double initialBalance, Customer owner) {
        this.name = name;
        this.balance = initialBalance;
        this.owner = owner;
    }

    //allows user to deposit money
    public void deposit(double depositAmount) {
        balance += depositAmount;
        incrementID();
        System.out.println("------------------------------------------------------------");
        System.out.println("Transaction Receipt: ");
        System.out.println("$" + String.format("%.2f", depositAmount) + " has been deposited into: " + getName());
        System.out.println("Transaction ID: " + ID);
        System.out.println("------------------------------------------------------------");


    }

    //allows user to withdraw money
    public void withdraw(double withdrawAmount, boolean isTransfer) {
        if (withdrawAmount <= balance) {
            if (withdrawAmount % 5 == 0 || isTransfer) {
                balance -= withdrawAmount;
                incrementID();
                System.out.println("------------------------------------------------------------");
                System.out.println("Transaction Receipt: ");
                System.out.println("$" + String.format("%.2f", withdrawAmount) + " has been withdrawn from: " + getName());
                System.out.println("Transaction ID: " + ID);
                System.out.println("------------------------------------------------------------");
            } else {
                System.out.println("We cannot provide you the proper bills for your transaction.");
                System.out.println("------------------------------------------------------------");
            }
        } else {
            System.out.println("You do not have enough money!");
            System.out.println("------------------------------------------------------------");
        }
    }

    //allows user to transfer from savings to checking or vice versa
    public void transfer(Account fromAccount, double transferAmount){
        if (fromAccount.balance >= transferAmount) {
            fromAccount.withdraw(transferAmount, true);
            balance += transferAmount;
            incrementID();
        } else {
            System.out.println("You do not have enough money!");
            System.out.println();
        }
    }

    //getter methods
    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public static void incrementID() {
        ID++;
    }




}
