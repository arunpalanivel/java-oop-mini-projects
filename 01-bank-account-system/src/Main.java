package src;

public class Main {
    public static void main(String[] args) {
        BankAccount arunAccount = new BankAccount("123456",100,"Arun",
                "arunpalanivel@gmail.com","9342854556");
        System.out.println(arunAccount.getAccountBalance());
    }
}
