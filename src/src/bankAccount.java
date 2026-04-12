public class bankAccount {
    int accountNumber;
    String username;
    double balance;

    public bankAccount(int accountNumber, String username, double balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }

    public String toString() {
        return "Account Number: " + accountNumber +
                ", Username: " + username +
                ", Balance: " + balance;
    }
}