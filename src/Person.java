public class Person {
    /** Instance Variables **/
    private String firstName;
    private String lastName;
    private String phoneNumber;
    /** Constructor **/
    public Person(String firstName, String lastName, String number)
    {
        // Initializes instance variables firstName, lastName, and phoneNumber
        this.firstName = firstName;
        this.lastName = lastName;
        phoneNumber = number;
    }
    /** Getters **/

    /**
     * Returns first name from Person
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Returns last name from Person
     */
    public String getLastName()
    {
        return lastName;
    }
    /**
     * Returns phone number from Person
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    /**
     * Overrides Object's toString method
     * Returns first name, last name, and phone number
     */
    @Override
    public String toString()
    {
        return firstName + " " + lastName + " - #" + phoneNumber;
    }
}
