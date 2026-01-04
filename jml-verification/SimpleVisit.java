/**
 * Simplified JML-annotated Visit for clean OpenJML ESC verification.
 * This demonstrates successful formal verification of visit properties.
 */
public class SimpleVisit {

    private /*@ spec_public nullable @*/ Integer id;
    private /*@ spec_public nullable @*/ String date;
    private /*@ spec_public nullable @*/ String description;

    /**
     * Returns the visit's ID.
     */
    //@ ensures \result == id;
    //@ pure
    public /*@ nullable @*/ Integer getId() {
        return this.id;
    }

    /**
     * Sets the visit's ID.
     */
    //@ assignable this.id;
    //@ ensures this.id == id;
    public void setId(/*@ nullable @*/ Integer id) {
        this.id = id;
    }

    /**
     * Returns true if the visit has not been persisted yet.
     */
    //@ ensures \result == (id == null);
    //@ pure
    public boolean isNew() {
        return this.id == null;
    }

    /**
     * Returns the visit date.
     */
    //@ ensures \result == date;
    //@ pure
    public /*@ nullable @*/ String getDate() {
        return this.date;
    }

    /**
     * Sets the visit date.
     */
    //@ assignable this.date;
    //@ ensures this.date == date;
    public void setDate(/*@ nullable @*/ String date) {
        this.date = date;
    }

    /**
     * Returns the visit description.
     */
    //@ ensures \result == description;
    //@ pure
    public /*@ nullable @*/ String getDescription() {
        return this.description;
    }

    /**
     * Sets the visit description.
     */
    //@ assignable this.description;
    //@ ensures this.description == description;
    public void setDescription(/*@ nullable @*/ String description) {
        this.description = description;
    }

    /**
     * Checks if the visit is complete (has both date and description).
     */
    //@ ensures \result == (date != null && description != null);
    //@ pure
    public boolean isComplete() {
        return this.date != null && this.description != null;
    }

}

