package src;

public class BankAccount {
    // accountNumber is marked as final because it shouldn't change after creation (Immutability).
    private final String accountNumber;
    private double accountBalance;
    private String customerName;
    private String customerEmail;
    private String phoneNumber;

    /**
     * Constructor for BankAccount.
     * @param accountNumber The unique account number.
     * @param accountBalance The initial balance. Must be non-negative.
     * @param customerName The name of the account holder.
     * @param customerEmail The email address.
     * @param phoneNumber The phone number.
     */
    public BankAccount(String accountNumber, double accountBalance, String customerName, String customerEmail, String phoneNumber) {
        // Essential data validation in the constructor
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be empty.");
        }
        this.accountNumber = accountNumber;

        // Ensure balance is never negative upon creation
        this.accountBalance = Math.max(accountBalance, 0);

        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.phoneNumber = phoneNumber;
    }

    // --- Core Business Methods ---

    /**
     * Adds funds to the account balance.
     * @param depositAmount The amount to deposit. Must be positive.
     */
    public void depositFunds(double depositAmount){
        if(depositAmount <= 0){
            System.out.println("Error: Deposit amount must be positive.");
            return;
        }
        accountBalance += depositAmount;
        // Using String.format for cleaner output, often used for financial data
        System.out.printf("SUCCESS: Deposited %.2f. New balance is %.2f\n", depositAmount, this.accountBalance);
    }

    /**
     * Withdraws funds from the account balance if sufficient funds are available.
     * @param withdrawalAmount The amount to withdraw. Must be positive.
     */
    public void withdrawalFunds(double withdrawalAmount){
        if(withdrawalAmount <= 0){
            System.out.println("Error: Withdrawal amount must be positive.");
            return;
        }

        if(withdrawalAmount <= accountBalance) {
            accountBalance -= withdrawalAmount;
            System.out.printf("SUCCESS: Withdrew %.2f. Remaining balance: %.2f\n", withdrawalAmount, this.accountBalance);
        }
        else{
            System.out.printf("FAILURE: Insufficient Balance. Current balance: %.2f. Cannot withdraw %.2f\n", accountBalance, withdrawalAmount);
        }
    }

    // --- Getters ---

    // Only a getter for accountNumber since it is final (immutable)
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // --- Setters with Basic Validation ---

    public void setCustomerName(String customerName) {
        if (customerName != null && !customerName.trim().isEmpty()) {
            this.customerName = customerName;
        } else {
            System.out.println("Warning: Customer name update failed. Name cannot be empty.");
        }
    }

    public void setCustomerEmail(String customerEmail) {
        // Simple email validation check (contains '@')
        if (customerEmail != null && customerEmail.contains("@")) {
            this.customerEmail = customerEmail;
        } else {
            System.out.println("Warning: Invalid email format. Update failed.");
        }
    }

    public void setPhoneNumber(String phoneNumber) {
        // Simple validation check (non-empty)
        if (phoneNumber != null && !phoneNumber.trim().isEmpty()) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Warning: Phone number cannot be empty. Update failed.");
        }
    }

}