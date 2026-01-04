/**
 * Simplified JML-annotated Person for clean OpenJML ESC verification.
 * This demonstrates successful formal verification of person properties.
 */
public class SimplePerson {

    private /*@ spec_public nullable @*/ Integer id;
    private /*@ spec_public nullable @*/ String firstName;
    private /*@ spec_public nullable @*/ String lastName;

    /**
     * Returns the person's ID.
     */
    //@ ensures \result == id;
    //@ pure
    public /*@ nullable @*/ Integer getId() {
        return this.id;
    }

    /**
     * Sets the person's ID.
     */
    //@ assignable this.id;
    //@ ensures this.id == id;
    public void setId(/*@ nullable @*/ Integer id) {
        this.id = id;
    }

    /**
     * Returns true if the person has not been persisted yet.
     */
    //@ ensures \result == (id == null);
    //@ pure
    public boolean isNew() {
        return this.id == null;
    }

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
     */
    //@ assignable this.lastName;
    //@ ensures this.lastName == lastName;
    public void setLastName(/*@ nullable @*/ String lastName) {
        this.lastName = lastName;
    }

    /**
     * Checks if this person has a complete name.
     */
    //@ ensures \result == (firstName != null && lastName != null);
    //@ pure
    public boolean hasCompleteName() {
        return this.firstName != null && this.lastName != null;
    }

}

