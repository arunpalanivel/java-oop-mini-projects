package src;

public class Main {
    public static void main(String[] args) {
        // 1. Create a new BankAccount instance
        BankAccount arunAccount = new BankAccount("123456", 500.50, "Arun Palanivel",
                "arunpalanivel@gmail.com", "9342854556");

        System.out.println("--- Account Creation & Initial Check ---");
        System.out.println("Account Holder: " + arunAccount.getCustomerName());
        System.out.println("Account Number: " + arunAccount.getAccountNumber());
        System.out.printf("Current Balance: %.2f\n\n", arunAccount.getAccountBalance());

        // 2. Test Deposit Functionality
        System.out.println("--- Testing Deposits ---");
        arunAccount.depositFunds(150.00); // Valid deposit
        arunAccount.depositFunds(-20.00); // Invalid deposit (negative)
        System.out.printf("Balance after deposit tests: %.2f\n\n", arunAccount.getAccountBalance());

        // 3. Test Withdrawal Functionality
        System.out.println("--- Testing Withdrawals ---");
        arunAccount.withdrawalFunds(100.00); // Valid withdrawal
        arunAccount.withdrawalFunds(700.00); // Invalid withdrawal (insufficient funds)
        arunAccount.withdrawalFunds(0.00); // Invalid withdrawal (zero/negative amount)
        System.out.printf("Final Balance: %.2f\n\n", arunAccount.getAccountBalance());

        // 4. Test Setters
        System.out.println("--- Testing Setters ---");
        arunAccount.setCustomerEmail("new_arun@outlook.com"); // Valid update
        arunAccount.setCustomerName(""); // Invalid update (empty string)
        System.out.println("Updated Email: " + arunAccount.getCustomerEmail());
    }
}