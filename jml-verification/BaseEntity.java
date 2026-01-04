/**
 * JML-annotated version of BaseEntity for OpenJML verification.
 * This demonstrates formal verification of the PetClinic domain model.
 * 
 * Original class: org.springframework.samples.petclinic.model.BaseEntity
 */
public class BaseEntity {

    private /*@ spec_public nullable @*/ Integer id;

    //@ public invariant id == null || id.intValue() >= 0;

    /**
     * Returns the entity's ID.
     */
    //@ ensures \result == id;
    //@ pure
    public /*@ nullable @*/ Integer getId() {
        return id;
    }

    /**
     * Sets the entity's ID.
     * @param id the new ID (can be null for new entities)
     */
    //@ requires id == null || id >= 0;
    //@ assignable this.id;
    //@ ensures this.id == id;
    public void setId(/*@ nullable @*/ Integer id) {
        this.id = id;
    }

    /**
     * Returns true if the entity has not been persisted yet (id is null).
     * @return true if new (unpersisted), false otherwise
     */
    //@ ensures \result == (id == null);
    //@ pure
    public boolean isNew() {
        return this.id == null;
    }

}

