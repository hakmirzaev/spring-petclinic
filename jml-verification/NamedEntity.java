/**
 * JML-annotated version of NamedEntity for OpenJML verification.
 * Extends BaseEntity with a name property.
 * 
 * Original class: org.springframework.samples.petclinic.model.NamedEntity
 */
public class NamedEntity extends BaseEntity {

    private /*@ spec_public nullable @*/ String name;

    /**
     * Returns the entity's name.
     */
    //@ ensures \result == name;
    //@ pure
    public /*@ nullable @*/ String getName() {
        return this.name;
    }

    /**
     * Sets the entity's name.
     * @param name the new name
     */
    //@ assignable this.name;
    //@ ensures this.name == name;
    public void setName(/*@ nullable @*/ String name) {
        this.name = name;
    }

    /**
     * Returns a string representation of this entity.
     */
    //@ also
    //@ ensures \result != null;
    //@ pure
    @Override
    public String toString() {
        return this.getName() != null ? this.getName() : "";
    }

}

