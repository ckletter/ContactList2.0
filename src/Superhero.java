public class Superhero extends Person {
    /** Instance Variables **/
    private String superheroName;
    /** Constructor **/
    public Superhero(String firstName, String lastName, String phoneNumber, String superheroName)
    {
        // Calls superclass constructor in Person to initialize instance variables
        super(firstName, lastName, phoneNumber);

        // Initializes superheroName instance variable
        this.superheroName = superheroName;
    }
    /**
     * Returns String superheroName from Superhero
     */
    public String getSuperheroName()
    {
        return this.superheroName;
    }
    /**
     * Overrides Person's toString method
     * Returns first name, last name, phone number, and superhero name
     */
    public String toString()
    {
        return super.toString() + " " + this.superheroName;
    }
}