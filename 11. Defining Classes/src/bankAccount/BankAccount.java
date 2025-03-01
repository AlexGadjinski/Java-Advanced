package bankAccount;

public class BankAccount {
    private static int totalAccounts = 0;
    private static double interestRate = 0.02;

    private int id;
    private double balance;

    public BankAccount() {
        this.id = ++totalAccounts;
        this.balance = 0;
    }

    public int getId() {
        return id;
    }

    public static void setInterestRate(double interest) {
        interestRate = interest;
    }

    public double getInterest(int years) {
        return balance * years * interestRate;
    }

    public void deposit(double amount) {
        balance += amount;
    }
}
