package src;

public class Main1 {
    public static void main(String[] args) {
        EmployeePayroll employee1 = new EmployeePayroll("Arun",1,100000);
        System.out.println(employee1.getName());
        System.out.println(employee1.getId());
        System.out.println(employee1.getSalary());
        System.out.println(employee1.calculateNetPay());
        employee1.printDetails();
    }
}
