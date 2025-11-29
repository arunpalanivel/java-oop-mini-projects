package src;

public class BankAccount {
    private String accountNumber;
    private double accountBalance;
    private String customerName;
    private String customerEmail;
    private String phoneNumber;

    public BankAccount(String accountNumber, double accountBalance, String customerName, String customerEmail, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.accountBalance = Math.max(accountBalance, 0);
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.phoneNumber = phoneNumber;
    }

    public void depositFunds(double depositAmount){
        if(depositAmount < 0){
            System.out.println("Deposit amount cannot be negative");
            return;
        }
        accountBalance += depositAmount;
        System.out.println("Deposited " + depositAmount + " and the new balance is " + this.accountBalance);
    }

    public void withdrawalFunds(double withdrawalAmount){
        if(withdrawalAmount <= 0){
            System.out.println("Withdrawal amount must be positive");
            return;
        }
        if(withdrawalAmount <= accountBalance) {
            accountBalance -= withdrawalAmount;
            System.out.println("Withdrew " + withdrawalAmount + ". Remaining balance: " + this.accountBalance);
        }
        else{
            System.out.println("Insufficient Balance, You only have " + accountBalance);
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
