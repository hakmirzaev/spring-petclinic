/**
 * JML-annotated version of PetValidator for OpenJML verification.
 * Validates pet data before persistence.
 * 
 * Original class: org.springframework.samples.petclinic.owner.PetValidator
 */
public class PetValidator {

    /**
     * Validates that a pet has all required fields.
     * A pet requires: name, type (if new), and birth date.
     * 
     * @param pet the pet to validate (must not be null)
     * @return true if all required fields are present, false otherwise
     */
    //@ requires pet != null;
    //@ ensures pet.getName() == null ==> \result == false;
    //@ ensures pet.getBirthDate() == null ==> \result == false;
    //@ ensures (pet.isNew() && pet.getPetType() == null) ==> \result == false;
    //@ pure
    public boolean isValid(/*@ non_null @*/ Pet pet) {
        // Name is required
        if (pet.getName() == null || pet.getName().trim().isEmpty()) {
            return false;
        }

        // Type is required for new pets
        if (pet.isNew() && pet.getPetType() == null) {
            return false;
        }

        // Birth date is required
        if (pet.getBirthDate() == null) {
            return false;
        }

        return true;
    }

    /**
     * Checks if the given name is valid (non-null and non-empty).
     * @param name the name to check
     * @return true if valid
     */
    //@ ensures name == null ==> \result == false;
    //@ ensures (name != null && name.trim().isEmpty()) ==> \result == false;
    //@ ensures (name != null && !name.trim().isEmpty()) ==> \result == true;
    //@ pure
    public boolean isValidName(/*@ nullable @*/ String name) {
        return name != null && !name.trim().isEmpty();
    }

    /**
     * Validates that a visit has required information.
     * A visit requires a description.
     * 
     * @param visit the visit to validate (must not be null)
     * @return true if the visit has a description
     */
    //@ requires visit != null;
    //@ ensures visit.getDescription() == null ==> \result == false;
    //@ pure
    public boolean isValidVisit(/*@ non_null @*/ Visit visit) {
        return visit.getDescription() != null && !visit.getDescription().trim().isEmpty();
    }

}

