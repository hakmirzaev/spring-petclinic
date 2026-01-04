/**
 * JML-annotated version of Visit for OpenJML verification.
 * Represents a veterinary visit for a pet.
 * 
 * Original class: org.springframework.samples.petclinic.owner.Visit
 */
public class Visit extends BaseEntity {

    private /*@ spec_public nullable @*/ String date;
    private /*@ spec_public nullable @*/ String description;

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
     * @param date the date string
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
     * @param description the description
     */
    //@ assignable this.description;
    //@ ensures this.description == description;
    public void setDescription(/*@ nullable @*/ String description) {
        this.description = description;
    }

    /**
     * Checks if the visit has all required information.
     * A valid visit must have both a date and description.
     * @return true if the visit is complete
     */
    //@ ensures \result == (date != null && description != null);
    //@ pure
    public boolean isComplete() {
        return this.date != null && this.description != null;
    }

}

