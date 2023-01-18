public class Account {
    public String name;
    public double balance;
    private Customer owner;

    public Account(String name, double initialBalance, Customer owner) {
        this.name = name;
        this.balance = initialBalance;
        this.owner = owner;
    }

    public void deposit(double depositAmount) {
        balance += depositAmount;
    }

    public void withdraw(double withdrawAmount) {
        if (withdrawAmount <= balance) {
            if (withdrawAmount % 5 == 0) {
                balance -= withdrawAmount;
            } else {
                System.out.println("We cannot provide you the proper bills for your transaction.");
            }
        } else {
            System.out.println("You do not have enough money!");
            System.out.println();
        }
    }

    public void transfer(Account fromAccount, double transferAmount){
        if (fromAccount.balance >= transferAmount) {
            fromAccount.withdraw(transferAmount);
            balance += transferAmount;
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

    public Customer getOwner() {
        return owner;
    }
}
