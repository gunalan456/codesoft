import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }
}

public class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void processOption(int option) {
        switch (option) {
            case 1:
                System.out.println("Your balance is: $" + bankAccount.getBalance());
                break;
            case 2:
                System.out.print("Enter deposit amount: $");
                double depositAmount = scanner.nextDouble();
                bankAccount.deposit(depositAmount);
                System.out.println("Deposit successful.");
                break;
            case 3:
                System.out.print("Enter withdrawal amount: $");
                double withdrawalAmount = scanner.nextDouble();
                if (bankAccount.withdraw(withdrawalAmount)) {
                    System.out.println("Withdrawal successful.");
                } else {
                    System.out.println("Insufficient funds.");
                }
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000.0); // Starting balance of $1000
        ATM atm = new ATM(bankAccount);

        while (true) {
            atm.displayMenu();
            System.out.print("Enter option: ");
            int option = atm.scanner.nextInt();
            atm.processOption(option);
        }
    }
}
