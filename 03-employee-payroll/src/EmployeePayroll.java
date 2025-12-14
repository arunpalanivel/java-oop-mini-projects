package src;

public class EmployeePayroll {
    private String name;
    private int id;
    private double salary;
    public static final double TAX_RATE = 0.10; // 10%
    public static final double PF_RATE = 0.05; // 5%


    EmployeePayroll(String name, int id, double salary){
        this.name = name;
        this.id = id;
        if(salary >=0){
            this.salary = salary;
        }else {
            throw new IllegalArgumentException("Salary Must be a positive value.");
        }

    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }
    public double calculateNetPay(){
        return (this.salary-((TAX_RATE + PF_RATE) * this.salary));
    }
    public void printDetails() {
        double netPay = calculateNetPay();
        System.out.println("\n--- Employee Payroll Stub ---");
        System.out.println("Employee Name: " + this.name);
        System.out.println("ID: " + this.id);
        System.out.println("Gross Salary: $" + this.salary);
        System.out.println("Deductions (15%): $" + (this.salary - netPay));
        System.out.println("Net Pay: $" + netPay);
        System.out.println("-----------------------------\n");
    }


}
