/**
 * JML-annotated version of Person for OpenJML verification.
 * Represents a person with first and last name.
 * 
 * Original class: org.springframework.samples.petclinic.model.Person
 */
public class Person extends BaseEntity {

    private /*@ spec_public nullable @*/ String firstName;
    private /*@ spec_public nullable @*/ String lastName;

    /**
     * Returns the person's first name.
     */
    //@ ensures \result == firstName;
    //@ pure
    public /*@ nullable @*/ String getFirstName() {
        return this.firstName;
    }

    /**
     * Sets the person's first name.
     * @param firstName the new first name
     */
    //@ assignable this.firstName;
    //@ ensures this.firstName == firstName;
    public void setFirstName(/*@ nullable @*/ String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the person's last name.
     */
    //@ ensures \result == lastName;
    //@ pure
    public /*@ nullable @*/ String getLastName() {
        return this.lastName;
    }

    /**
     * Sets the person's last name.
     * @param lastName the new last name
     */
    //@ assignable this.lastName;
    //@ ensures this.lastName == lastName;
    public void setLastName(/*@ nullable @*/ String lastName) {
        this.lastName = lastName;
    }

    /**
     * Checks if this person has a complete name (both first and last name set).
     * @return true if both names are non-null
     */
    //@ ensures \result == (firstName != null && lastName != null);
    //@ pure
    public boolean hasCompleteName() {
        return this.firstName != null && this.lastName != null;
    }

}

