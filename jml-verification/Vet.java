import java.util.ArrayList;
import java.util.List;

/**
 * JML-annotated version of Vet for OpenJML verification.
 * Represents a veterinarian with specialties.
 * 
 * Original class: org.springframework.samples.petclinic.vet.Vet
 */
public class Vet extends Person {

    private /*@ spec_public non_null @*/ List<String> specialties;

    //@ public invariant specialties != null;

    /**
     * Constructs a new Vet with an empty specialties list.
     */
    //@ ensures specialties != null;
    //@ ensures specialties.size() == 0;
    public Vet() {
        this.specialties = new ArrayList<>();
    }

    /**
     * Returns the list of specialties for this vet.
     */
    //@ ensures \result == specialties;
    //@ ensures \result != null;
    //@ pure
    public /*@ non_null @*/ List<String> getSpecialties() {
        return this.specialties;
    }

    /**
     * Returns the number of specialties this vet has.
     * @return the specialty count
     */
    //@ requires specialties != null;
    //@ ensures \result >= 0;
    //@ ensures \result == specialties.size();
    //@ pure
    public int getNrOfSpecialties() {
        return this.specialties.size();
    }

    /**
     * Adds a specialty to this vet.
     * @param specialty the specialty to add (must not be null)
     */
    //@ requires specialty != null;
    //@ requires specialties != null;
    //@ assignable specialties;
    //@ ensures specialties.contains(specialty);
    public void addSpecialty(/*@ non_null @*/ String specialty) {
        this.specialties.add(specialty);
    }

    /**
     * Checks if this vet has any specialties.
     * @return true if the vet has at least one specialty
     */
    //@ requires specialties != null;
    //@ ensures \result == (specialties.size() > 0);
    //@ pure
    public boolean hasSpecialties() {
        return !this.specialties.isEmpty();
    }

}

