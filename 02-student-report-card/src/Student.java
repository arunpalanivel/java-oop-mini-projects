package src;

/**
 * Represents a student and calculates their report card details
 * based on OOP principles (Encapsulation and Immutability).
 */
public class Student {
    // Fields are final for data that should not change after creation (Immutability)
    private final String studentName;
    private final String rollNumber;

    // Internal state array (private and mutable, requiring defensive handling)
    private final int[] marks;

    /**
     * Constructor for the Student object. Includes input validation.
     * * @param name The student's name.
     * @param rollNumber The student's unique roll number.
     * @param marks An array of marks obtained by the student.
     */
    public Student(String name, String rollNumber, int[] marks){
        // Validation: Check for null or empty strings/arrays
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Student Name cannot be empty.");
        }
        if (rollNumber == null || rollNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Roll Number cannot be empty.");
        }
        if (marks == null || marks.length == 0) {
            throw new IllegalArgumentException("Marks array cannot be null or empty.");
        }

        this.studentName = name;
        this.rollNumber = rollNumber;

        // Defensive Copying: This ensures that if the input array is modified
        // externally, the internal state of the Student object is protected.
        this.marks = marks.clone();
    }

    // --- Getters ---

    public String getStudentName() {
        return studentName;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    /**
     * Returns a copy of the marks array to protect internal state (Defensive Copying).
     * @return A clone of the marks array.
     */
    public int[] getMarks() {
        return this.marks.clone();
    }

    // --- Business Logic Methods ---

    /**
     * Calculates the sum of all marks.
     * @return The total marks.
     */
    public int getTotal(){
        int totalMark = 0;
        for (int mark : marks) {
            totalMark += mark;
        }
        return totalMark;
    }

    /**
     * Calculates the average mark.
     * @return The average mark as a double.
     */
    public double getAverage(){
        // Explicit cast to double ensures floating-point division
        return (double) getTotal() / marks.length;
    }

    /**
     * Calculates the corresponding grade based on the average.
     * @return The grade character ('A', 'B', 'C', 'D', or 'F').
     */
    public char getGrade(){
        double avg = getAverage();

        if(avg >= 90) return 'A';
        else if (avg >= 80) return 'B';
        else if (avg >= 70) return 'C';
        else if (avg >= 60) return 'D';

        return 'F';
    }

    /**
     * Prints the complete formatted report card to the console.
     */
    public void printReport() {
        System.out.println("\n------ STUDENT REPORT CARD ------");
        System.out.println("Name       : " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Total Marks: " + getTotal());
        // Use printf for clean formatting of the average (e.g., to 2 decimal places)
        System.out.printf("Average    : %.2f\n", getAverage());
        System.out.println("Grade      : " + getGrade());
        System.out.println("---------------------------------");
    }

    public static void main(String[] args) {
        // Test Case 1: Excellent Student (Grade A)
        Student student1 = new Student("Arun Palanivel", "2022BTCY001", new int[]{95, 92, 98, 88});
        student1.printReport();

        // Test Case 2: Borderline Student (Grade D)
        Student student2 = new Student("Vignesh R", "2022BTCY002", new int[]{65, 55, 62, 58});
        student2.printReport();

        // Example of accessing data:
        System.out.println("\nRoll Number for " + student2.getStudentName() + ": " + student2.getRollNumber());

        // Demonstration of Defensive Copying:
        int[] s1Marks = student1.getMarks();
        s1Marks[0] = 10; // Try to change the mark externally (this will fail because getMarks returned a copy)
        System.out.println("\nOriginal Mark (should still be 95): " + student1.getMarks()[0]);
    }
}