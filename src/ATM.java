import java.util.Scanner;
public class ATM {
    private Account savings;
    private Account checking;

    public ATM() {
    }

    public void play() {
        Scanner scan = new Scanner(System.in);
        System.out.println("-------------------------------------------------------");
        System.out.println(" Welcome to the ATM. It's time to make a new account.");
        System.out.println("-------------------------------------------------------");
        System.out.print("What is your name? ");
        String customerName = scan.nextLine();
        System.out.print("Enter a pin: ");
        int pin = scan.nextInt();
        scan.nextLine();
        Customer customer1 = new Customer(customerName, pin);
        savings = new Account("Savings", 0, customer1);
        checking = new Account("Checking", 0, customer1);
        boolean keepGoing = true;
        while (keepGoing) {
            System.out.println("------------------------");
            System.out.println("Options: ");
            System.out.println("1. Withdraw money\n" +
                    "2. Deposit money\n" +
                    "3. Transfer money between accounts\n" +
                    "4. Get account balances\n" +
                    "5. Change PIN\n" +
                    "6. Exit\n" + "------------------------");

            System.out.print("Enter a choice: ");
            int option = scan.nextInt();
            scan.nextLine();

            if (option == 1) {
                System.out.print("Would you like to withdraw from your Savings or Checking? ");
                String option1 = scan.nextLine();
                if (option1.toUpperCase().equals("SAVINGS")) {
                    System.out.print("How much money would you like to withdraw? ");
                    int withdrawAmount = scan.nextInt();
                    scan.nextLine();
                    savings.withdraw(withdrawAmount, false);

                } else if (option1.toUpperCase().equals("CHECKING")) {
                    System.out.print("How much money would you like to withdraw? ");
                    int withdrawAmount = scan.nextInt();
                    scan.nextLine();
                    checking.withdraw(withdrawAmount, false);
                }
            } else if (option == 2) {
                System.out.print("Would you like to deposit to your Savings or Checking? ");
                String option2 = scan.nextLine();
                if (option2.toUpperCase().equals("SAVINGS")) {
                    System.out.print("How much money would you like to deposit? ");
                    double depositAmount = scan.nextDouble();
                    scan.nextLine();
                    savings.deposit(depositAmount);
                } else if (option2.toUpperCase().equals("CHECKING")) {
                    System.out.print("How much money would you like to deposit? ");
                    double depositAmount = scan.nextDouble();
                    scan.nextLine();
                    checking.deposit(depositAmount);
                }
            } else if (option == 3) {
                System.out.print("What account do you want to transfer from? ");
                String fromAccount = scan.nextLine();
                System.out.print("How much money? ");
                double transferAmount = scan.nextDouble();
                scan.nextLine();
                if (fromAccount.toUpperCase().equals("SAVINGS")) {
                    checking.transfer(savings, transferAmount);
                } else if (fromAccount.toUpperCase().equals("CHECKING")) {
                    savings.transfer(checking, transferAmount);
                }
            } else if (option == 4) {
                System.out.println("The balance for your checking account is: $ " + checking.getBalance());
                System.out.println("The balance for your savings account is: $ " + savings.getBalance());
                System.out.println("------------------------------------------------------------");
            } else if (option == 5) {
                System.out.print("What would like your new pin to be? ");
                int newPin = scan.nextInt();
                scan.nextLine();
                customer1.updatePin(newPin);
            } else if (option == 6) {
                keepGoing = false;
            }
            if (option != 6) {
                System.out.print("Would you like to do anything else? ");
                String answer = scan.nextLine();
                if(answer.toUpperCase().equals("YES")){
                    System.out.print("Please re-enter your pin: ");
                    int pin2 = scan.nextInt();
                    scan.nextLine();
                    int counter = 1;
                    while(!customer1.pinCheck(pin2) && counter <= 2){
                        System.out.print("Please re-enter your pin: ");
                        pin2 = scan.nextInt();
                        scan.nextLine();
                        counter++;
                        if (counter == 3) {
                            System.out.println("GO AWAY THIEF!");
                            System.out.println();
                            keepGoing = false;
                        }
                    }

                } else if(answer.toUpperCase().equals("NO")){
                    keepGoing = false;
                }

            }
        }
        System.out.println("Thank you for using the ATM " + customer1.getName() + "!");
    }
}


