import java.util.ArrayList;
import java.util.List;

/**
 * JML-annotated version of Pet for OpenJML verification.
 * Represents a pet with a name and a list of visits.
 * 
 * Original class: org.springframework.samples.petclinic.owner.Pet
 */
public class Pet extends NamedEntity {

    private /*@ spec_public nullable @*/ String birthDate;
    private /*@ spec_public nullable @*/ String petType;
    private /*@ spec_public non_null @*/ List<Visit> visits;

    //@ public invariant visits != null;

    /**
     * Constructs a new Pet with an empty visits list.
     */
    //@ ensures visits != null;
    //@ ensures visits.size() == 0;
    public Pet() {
        this.visits = new ArrayList<>();
    }

    /**
     * Returns the pet's birth date.
     */
    //@ ensures \result == birthDate;
    //@ pure
    public /*@ nullable @*/ String getBirthDate() {
        return this.birthDate;
    }

    /**
     * Sets the pet's birth date.
     * @param birthDate the birth date string
     */
    //@ assignable this.birthDate;
    //@ ensures this.birthDate == birthDate;
    public void setBirthDate(/*@ nullable @*/ String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Returns the pet's type.
     */
    //@ ensures \result == petType;
    //@ pure
    public /*@ nullable @*/ String getPetType() {
        return this.petType;
    }

    /**
     * Sets the pet's type.
     * @param petType the pet type
     */
    //@ assignable this.petType;
    //@ ensures this.petType == petType;
    public void setPetType(/*@ nullable @*/ String petType) {
        this.petType = petType;
    }

    /**
     * Returns the list of visits for this pet.
     */
    //@ ensures \result == visits;
    //@ ensures \result != null;
    //@ pure
    public /*@ non_null @*/ List<Visit> getVisits() {
        return this.visits;
    }

    /**
     * Adds a visit to this pet's visit history.
     * @param visit the visit to add (must not be null)
     */
    //@ requires visit != null;
    //@ requires visits != null;
    //@ assignable visits;
    //@ ensures visits.contains(visit);
    public void addVisit(/*@ non_null @*/ Visit visit) {
        this.visits.add(visit);
    }

    /**
     * Returns the number of visits this pet has had.
     * @return the visit count
     */
    //@ requires visits != null;
    //@ ensures \result >= 0;
    //@ ensures \result == visits.size();
    //@ pure
    public int getVisitCount() {
        return this.visits.size();
    }

    /**
     * Checks if this pet has had any visits.
     * @return true if the pet has at least one visit
     */
    //@ requires visits != null;
    //@ ensures \result == (visits.size() > 0);
    //@ pure
    public boolean hasVisits() {
        return !this.visits.isEmpty();
    }

}

