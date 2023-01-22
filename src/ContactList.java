import java.util.ArrayList;
import java.util.Scanner;
/**
 * A class that stores subclasses of Person as a contact list.
 * The user is presented with a menu of options and may add, sort,
 * search, or list the contacts.
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam, Mr. Blick, and Cody Kletter
 * @version: 2022-2023
 */

public class ContactList
{
    /** Instance Variables **/
    private ArrayList<Person> objects;
    /** Constructor **/
    public ContactList()
    {
        // Creates new ArrayList objects
        objects = new ArrayList<Person>();
    }

    /**
     * Prints all menu options for the user
     * labeled with numbers
     */
    public void printMenuOptions() {
        System.out.println("Menu: ");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search by Phone Number");
        System.out.println("0. Exit");
    }

    /**
     * Asks user for input to create and add a new Person
     * to the contact list
     */
    public void addContact() {
        Scanner s = new Scanner(System.in);

        System.out.println("Select a type of contact to add:\n1. Student\n2. Superhero");

        // Stores user input in variable contact
        int contact = s.nextInt();
        s.nextLine();

        System.out.println("Please fill in the following information.\nFirst Name:");

        // Stores user input for contact's first name
        String firstName = s.nextLine();

        System.out.println("Last Name:");

        // Stores user input for contact's last name
        String lastName = s.nextLine();

        System.out.println("Phone Number:");

        // Stores user input for contact's phone number
        String number = s.nextLine();

        if (contact == 1)
        {
            System.out.println("Grade:");

            // Stores user input for contact's grade if contact is student
            int grade = s.nextInt();

            s.nextLine();

            // Creates new Student object using user input as parameters
            // and adds new Student to the end of the objects ArrayList
            Student student = new Student(firstName, lastName, number, grade);
            objects.add(student);
        }
        else
        {
            System.out.println("Superhero Name:");

            // Stores user input for contact's superhero name if contact is superhero
            String superheroName = s.nextLine();

            // Creates new Superhero object using user input as parameters
            // and adds new Superhero to the end of the objects ArrayList
            Superhero superhero = new Superhero(firstName, lastName, number, superheroName);
            objects.add(superhero);
        }
    }

    /**
     * Loops through and prints all contacts
     */
    public void printContacts() {
        // Loops through every Person in objects ArrayList and prints it
        for (int i = 0; i < objects.size(); i++)
        {
            System.out.println(objects.get(i));
        }
    }

    /**
     * Bubble sorts the contacts in the list by firstName,
     * lastName, or phoneNumber
     * @param sortBy: 0=firstName, 1=lastName, 2=phoneNumber
     */
    public void sort(int sortBy) {
        // Stores the total number of contacts in numContacts
        int numContacts = objects.size();

        /** Bubble sorts contacts **/

        // Loop for the number of passes in the bubble sort
        for (int i = 1; i < numContacts; i++)
        {
            // Loop for number of checks in each pass
            for (int j = 0; j < numContacts - i; j++)
            {
                String nameOne = "";
                String nameTwo = "";

                // Stores two Person objects next to each other in personOne and personTwo
                Person personOne = objects.get(i - 1);
                Person personTwo = objects.get(i);

                // If user sorts by first name, takes first names of each Person object stored
                // in personOne and personTwo and stores their first names to compare
                if (sortBy == 0) {
                    nameOne = personOne.getFirstName();
                    nameTwo = personTwo.getFirstName();
                }

                // If user sorts by last name, takes last names of each Person object stored
                // in personOne and personTwo and stores their last names to compare
                else if (sortBy == 1) {
                    nameOne = personOne.getLastName();
                    nameTwo = personTwo.getLastName();
                }

                // If user sorts by phone number, takes phone numbers of each Person object stored
                // in personOne and personTwo and stores their phone numbers to compare
                else
                {
                    nameOne = personOne.getPhoneNumber();
                    nameTwo = personTwo.getPhoneNumber();
                }

                // Compares two Strings stored previously in nameOne and nameTwo
                // (either phone numbers, first names, or last names depending on user request)
                // Swaps the two Person objects if nameOne and nameTwo are out of lexographic order
                if (nameOne.compareTo(nameTwo) > 0) {
                    Person temp = personOne;
                    objects.set(i - 1, personTwo);
                    objects.set(i, temp);
                }
            }
        }
    }

    /**
     * Searches for contact with passed in first name
     * Returns contact if any contact with that first name is found
     * Otherwise, returns null
     */
    public Person searchByFirstName(String firstName)
    {
        // Loops through each contact in list
        for (int i = 0; i < objects.size(); i++)
        {
            Person compare = objects.get(i);

            // Returns the contact if they have the same first name that is searched
            if (compare.getFirstName().equals(firstName))
            {
                return compare;
            }
        }
        return null;
    }
    /**
     * Searches for contact with passed in last name
     * Returns contact if any contact with that last name is found
     * Otherwise, returns null
     */
    public Person searchByLastName(String lastName)
    {
        // Loops through each contact in list
        for (int i = 0; i < objects.size(); i++)
        {
            Person compare = objects.get(i);

            // Returns the contact if they have the same last name that is searched
            if (compare.getLastName().equals(lastName))
            {
                return compare;
            }
        }
        return null;
    }
    /**
     * Searches for contact with passed in phone number
     * Returns contact if any contact with that phone number is found
     * Otherwise, returns null
     */
    public Person searchByPhoneNumber(String phoneNumber)
    {
        // Loops through each contact in list
        for (int i = 0; i < objects.size(); i++)
        {
            Person compare = objects.get(i);

            // Returns the contact if they have the same phone number that is searched
            if (compare.getPhoneNumber().equals(phoneNumber))
            {
                return compare;
            }
        }
        return null;
    }

    /**
     * Lists just the Student objects in the Contact List
     */
    public void listStudents() {
        // Loops through each contact in list
        for (int i = 0; i < objects.size(); i++)
        {
            Person person = objects.get(i);

            // If contact is a Student, prints it
            if (person instanceof Student)
            {
                System.out.println(person);
            }
        }
    }

    /**
     * Loops providing menu options to the user
     * until the user exits
     */
    public void run() {
        System.out.println("Welcome to your Contacts List");
        System.out.println("Please pick from the following menu options");

        printMenuOptions();

        Scanner s = new Scanner(System.in);
        int input = 1;

        // Continues to prompt user input until user inputs a 0
        while (input != 0)
        {
            input = s.nextInt();
            s.nextLine();
            switch (input)
            {
                // If user inputs a 1, adds contact to list using addContact()
                case 1:
                    addContact();
                    break;

                // If user inputs a 2, sorts contact by first names using sort()
                // Prints newly sorted contact list
                case 2:
                    sort(0);
                    printContacts();
                    break;

                // If user inputs a 3, sorts contact by last names using sort()
                // Prints newly sorted contact list
                case 3:
                    sort(1);
                    printContacts();
                    break;

                // If user inputs a 4, sorts contact by phone numbers using sort()
                // Prints newly sorted contact list
                case 4:
                    sort(2);
                    printContacts();
                    break;

                // If user inputs a 5, prints out all student contacts using listStudents()
                case 5:
                    listStudents();
                    break;

                // If user inputs a 6, searches through contacts for a first name
                // and prints it if found, otherwise states not in list
                case 6:
                    System.out.println("Enter a name:");

                    // Stores user input for first name searched
                    String firstName = s.nextLine();

                    // Searches through contacts for contact with same first name
                    Person personOfFirstName = searchByFirstName(firstName);

                    // If no contact with same first name found, states not in list
                    if (personOfFirstName == null)
                    {
                        System.out.println(firstName + " is not in the list.");
                    }
                    System.out.println(personOfFirstName);
                    break;

                // If user inputs a 7, searches through contacts for a last name
                // and prints it if found, otherwise states not in list
                case 7:
                    System.out.println("Enter a name:");

                    // Stores user input for last name searched
                    String lastName = s.nextLine();

                    // Searches through contacts for contact with same last name
                    Person personOfLastName = searchByLastName(lastName);

                    // If no contact with same last name found, states not in list
                    if (personOfLastName == null)
                    {
                        System.out.println(lastName + " is not in the list.");
                    }
                    System.out.println(personOfLastName);
                    break;

                // If user inputs an 8, searches through contacts for a phone number
                // and prints it if found, otherwise states not in list
                case 8:
                    System.out.println("Enter a phone number:");

                    // Stores user input for phone number searched
                    String phoneNumber = s.nextLine();

                    // Searches through contacts for contact with same phone number
                    Person personOfPhoneNumber = searchByPhoneNumber(phoneNumber);

                    // If no contact with same last name found, states not in list
                    if (personOfPhoneNumber == null)
                    {
                        System.out.println(phoneNumber + " is not in the list.");
                    }
                    System.out.println(personOfPhoneNumber);
                    break;

                // If user inputs any number not between 0-8, re-prompts user for input
                default:
                    break;
            }
        }
    }

    /** Main method **/
    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }
}