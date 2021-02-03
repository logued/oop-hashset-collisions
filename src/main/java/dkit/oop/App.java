package dkit.oop;

import java.util.HashSet;
import java.util.Set;

/**
 * Hashing - hash tables and hashCode()!
 *
 * Using a HashSet
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println("HashSet - hashCode and collisions");

        // "Hashing" involves taking a value and applying a function to it to
        // generate an integer value (called 'the hash', or 'hash code')

        // The integer value generated is used as the index location for
        // that value in the hash table.

        // The function that generates the integer value (the hash function),
        // is implemented in a method called "hashCode()"

        // API classes such as String, have the hashCode() method implemented in them.
        // You will need to define a hashCode() in your own classes.

        // String class defines a hashCode() method which is used to
        // to generate the hash value of a given string.

        String name = "Anne";
        int hashCode = name.hashCode();    // get the hashCode of the String
        System.out.println("Hashcode for \"" + name + "\" is: " + hashCode);

        name = "James";
        hashCode = name.hashCode();
        System.out.println("Hashcode for \"" + name + "\" is: " + hashCode);

        // A HashSet uses a hash table to store objects.
        // When an object is added to a HashSet, the hashCode() of the object
        // is called, and the integer value returned is used as the index
        // for placing the object in the hash table

        Set<String> namesSet = new HashSet<>(); // note element type is String

        namesSet.add("Anne");   // add "Anne" to the set
        namesSet.add("James");
        namesSet.add("Boris");
        namesSet.add("Anne");   // "Anne" already in the set, so nothing added
        // Remember, a Set cannot have duplicates

        // Retrieving data from a Set

        boolean present = namesSet.contains("Anne");
        if (present)
            System.out.println("The set contains Anne");

        if (namesSet.contains("Donal")) {
            System.out.println("Donald is present");
        } else {
            System.out.println("Donald is NOT present in Set");

            //Collisions
            // Some string values, when hashed, will give the same hashCode value.
            // - this is a collision
            // Not a problem, as Set will store both at 'same' location and
            // use the equals() method to distinguish between them.

            hashCode = "AaAaAaAa".hashCode();
            System.out.println("Hashcode for \"Anne\" is: " + hashCode);
            hashCode = "BBBBBBBB".hashCode();
            System.out.println("Hashcode for \"Anne\" is: " + hashCode);

            namesSet.add("AaAaAaAa");
            namesSet.add("BBBBBBBB");

            if (namesSet.contains("AaAaAaAa"))
                System.out.println("\"AaAaAaAa\" is in the set");

            if (namesSet.contains("BBBBBBBB"))
                System.out.println("\"BBBBBBBB\" is ALSO in the set");

            // Remove an elemnent from the Set
            namesSet.remove("James");


        }
    }
}
