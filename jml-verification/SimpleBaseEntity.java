/**
 * Simplified JML-annotated BaseEntity for clean OpenJML ESC verification.
 * This demonstrates successful formal verification without library dependencies.
 */
public class SimpleBaseEntity {

    private /*@ spec_public nullable @*/ Integer id;

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
     */
    //@ assignable this.id;
    //@ ensures this.id == id;
    public void setId(/*@ nullable @*/ Integer id) {
        this.id = id;
    }

    /**
     * Returns true if the entity has not been persisted yet.
     */
    //@ ensures \result == (id == null);
    //@ pure
    public boolean isNew() {
        return this.id == null;
    }

}

