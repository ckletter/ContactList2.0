public class Student extends Person {
    private int grade;
    public Student(String firstName, String lastName, String phoneNumber, int grade)
    {
        super(firstName, lastName, phoneNumber);

    }

    /**
     * Returns int grade from Student
     */
    public int getGrade()
    {
        return grade;
    }

    /**
     * Overrides Person's toString method
     * Returns first name, last name, phone number, and grade
     */
    @Override
    public String toString()
    {
        return super.getFirstName() + " " + super.getLastName() + " - #" + super.getPhoneNumber() + " Grade: " + grade;
    }
}
