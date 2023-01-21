public class Account {
    public String name;
    public double balance;
    private Customer owner;
    private static int ID = 1000;

    public Account(String name, double initialBalance, Customer owner) {
        this.name = name;
        this.balance = initialBalance;
        this.owner = owner;
    }

    public void deposit(double depositAmount) {
        balance += depositAmount;
        incrementID();
        System.out.println("------------------------------------------------------------");
        System.out.println("Transaction Receipt: ");
        System.out.println("$" + depositAmount + " has been deposited into: " + getName());
        System.out.println("Transaction ID: " + ID);
        System.out.println("------------------------------------------------------------");


    }

    public void withdraw(double withdrawAmount, boolean isTransfer) {
        if (withdrawAmount <= balance) {
            if (withdrawAmount % 5 == 0 || isTransfer) {
                balance -= withdrawAmount;
                incrementID();
                System.out.println("------------------------------------------------------------");
                System.out.println("Transaction Receipt: ");
                System.out.println("$" + withdrawAmount + " has been withdrawn from: " + getName());
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
