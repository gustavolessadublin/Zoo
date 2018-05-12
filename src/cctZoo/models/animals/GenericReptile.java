package cctZoo.models.animals;

import cctZoo.models.animals.abstracts.Animal;
import cctZoo.models.animals.interfaces.Reptile;

/**
 * Concrete Reptile animal class.
 * @author rbsrafa
 */
public class GenericReptile extends Animal implements Reptile{
    
    /**
     * Reptile animal constructor.
     * @param species
     * @param name
     * @param gender 
     */
    public GenericReptile(String species, String name, String gender) {
        super(species, name, gender);
    }
    
    /**
     * Reptile animal constructor.
     * @param species
     * @param gender 
     */
    public GenericReptile(String species, String gender) {
        super(species, gender);
    }
    
    /**
     * Reptile animal constructor.
     * @param species
     * @param gender
     * @param offspring1
     * @param offspring2 
     */
    public GenericReptile(String species, String gender, Animal offspring1, Animal offspring2) {
        super(species, gender, offspring1, offspring2);
    }
    
    /**
     * Reptile animal constructor.
     * @param species
     * @param gender
     * @param offspring1 
     */
    public GenericReptile(String species, String gender, Animal offspring1) {
        super(species, gender, offspring1);
    }
    
    /**
     * Reptile animal constructor.
     * @param species
     * @param gender
     * @param isOffspring 
     */
    public GenericReptile(String species, String gender, boolean isOffspring) {
        super(species, gender, isOffspring);
    }
    
    /**
     * Reptile animal constructor.
     * @param species
     * @param name
     * @param gender
     * @param doa
     * @param DOB 
     */
    public GenericReptile(String species, String name, String gender, String doa, String DOB){
        super(species, name, gender, doa, DOB);
    }
    
    /**
     * Reptile animal constructor.
     * @param species
     * @param name
     * @param gender
     * @param DOB 
     */
    public GenericReptile(String species, String name, String gender,String DOB){
        super(species, name, gender,DOB);
    }
 
}
