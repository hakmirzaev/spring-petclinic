import java.util.ArrayList;
import java.util.List;

/**
 * JML-annotated version of Owner for OpenJML verification.
 * Represents a pet owner with contact information and a list of pets.
 * 
 * Original class: org.springframework.samples.petclinic.owner.Owner
 */
public class Owner extends Person {

    private /*@ spec_public nullable @*/ String address;
    private /*@ spec_public nullable @*/ String city;
    private /*@ spec_public nullable @*/ String telephone;
    private /*@ spec_public non_null @*/ List<Pet> pets;

    //@ public invariant pets != null;

    /**
     * Constructs a new Owner with an empty pets list.
     */
    //@ ensures pets != null;
    //@ ensures pets.size() == 0;
    public Owner() {
        this.pets = new ArrayList<>();
    }

    /**
     * Returns the owner's address.
     */
    //@ ensures \result == address;
    //@ pure
    public /*@ nullable @*/ String getAddress() {
        return this.address;
    }

    /**
     * Sets the owner's address.
     * @param address the address
     */
    //@ assignable this.address;
    //@ ensures this.address == address;
    public void setAddress(/*@ nullable @*/ String address) {
        this.address = address;
    }

    /**
     * Returns the owner's city.
     */
    //@ ensures \result == city;
    //@ pure
    public /*@ nullable @*/ String getCity() {
        return this.city;
    }

    /**
     * Sets the owner's city.
     * @param city the city
     */
    //@ assignable this.city;
    //@ ensures this.city == city;
    public void setCity(/*@ nullable @*/ String city) {
        this.city = city;
    }

    /**
     * Returns the owner's telephone number.
     */
    //@ ensures \result == telephone;
    //@ pure
    public /*@ nullable @*/ String getTelephone() {
        return this.telephone;
    }

    /**
     * Sets the owner's telephone number.
     * @param telephone the telephone number (should be 10 digits)
     */
    //@ assignable this.telephone;
    //@ ensures this.telephone == telephone;
    public void setTelephone(/*@ nullable @*/ String telephone) {
        this.telephone = telephone;
    }

    /**
     * Returns the list of pets owned by this owner.
     */
    //@ ensures \result == pets;
    //@ ensures \result != null;
    //@ pure
    public /*@ non_null @*/ List<Pet> getPets() {
        return this.pets;
    }

    /**
     * Adds a new pet to this owner's collection.
     * Only new (unpersisted) pets can be added.
     * @param pet the pet to add
     */
    //@ requires pet != null;
    //@ requires pets != null;
    //@ requires pet.isNew();
    //@ assignable pets;
    //@ ensures pets.contains(pet);
    public void addPet(/*@ non_null @*/ Pet pet) {
        if (pet.isNew()) {
            this.pets.add(pet);
        }
    }

    /**
     * Returns the number of pets owned by this owner.
     * @return the pet count
     */
    //@ requires pets != null;
    //@ ensures \result >= 0;
    //@ ensures \result == pets.size();
    //@ pure
    public int getPetCount() {
        return this.pets.size();
    }

    /**
     * Checks if this owner has complete contact information.
     * @return true if address, city, and telephone are all set
     */
    //@ ensures \result == (address != null && city != null && telephone != null);
    //@ pure
    public boolean hasCompleteContactInfo() {
        return this.address != null && this.city != null && this.telephone != null;
    }

    /**
     * Checks if this owner has any pets.
     * @return true if the owner has at least one pet
     */
    //@ requires pets != null;
    //@ ensures \result == (pets.size() > 0);
    //@ pure
    public boolean hasPets() {
        return !this.pets.isEmpty();
    }

}

