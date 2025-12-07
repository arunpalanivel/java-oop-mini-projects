package src;

public class Student {
    private final String studentName;
    private final String rollNumber;
    private final int[] marks;

    // Constructors
    public Student(String name, String rollNumber, int[] marks){
        this.studentName = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public int[] getMarks() {
        return marks;
    }

    public  int getTotal(){
        int totalMark = 0;
        for (int mark : marks) {
            totalMark += mark;
        }
        return totalMark;
    }

    public double getAverage(){
        return (double) getTotal() / marks.length;
    }

    public char getGrade(){
//        avg ≥ 90 → 'A'
//        avg ≥ 80 → 'B'
//        avg ≥ 70 → 'C'
//        avg ≥ 60 → 'D'
//        else → 'F'

        double avg = getAverage();
        if(avg >= 90) return 'A';
        else if (avg >= 80) return 'B';
        else if (avg >= 70) return 'C';
        else if (avg >= 60) return 'D';
       return 'F';
    }

    public void printReport() {
        System.out.println("------ STUDENT REPORT CARD ------");
        System.out.println("Name       : " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Total Marks: " + getTotal());
        System.out.println("Average    : " + getAverage());
        System.out.println("Grade      : " + getGrade());
        System.out.println("---------------------------------");
    }

    public static void main(String[] args) {
        Student student1 = new Student("Arun","2022BTCY001", new int[]{20, 15, 23, 45});
        student1.printReport();
        System.out.println(student1.getRollNumber());


    }
}
