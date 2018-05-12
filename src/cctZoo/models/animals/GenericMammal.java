package cctZoo.models.animals;

import cctZoo.models.animals.abstracts.Animal;
import cctZoo.models.animals.interfaces.Mammal;

/**
 * Concrete Mammal class.
 * @author rbsrafa
 */
public class GenericMammal extends Animal implements Mammal{
    
    /**
     * Mammal animal constructor.
     * @param species
     * @param name
     * @param gender 
     */
    public GenericMammal(String species, String name, String gender) {
        super(species, name, gender);
    }
    
    /**
     * Mammal animal constructor.
     * @param species
     * @param gender 
     */
    public GenericMammal(String species, String gender) {
        super(species, gender);
    }
    
    /**
     * Mammal animal constructor.
     * @param species
     * @param gender
     * @param offspring1
     * @param offspring2 
     */
    public GenericMammal(String species, String gender, Animal offspring1, Animal offspring2) {
        super(species, gender, offspring1, offspring2);
    }
    
    /**
     * Mammal animal constructor.
     * @param species
     * @param gender
     * @param offspring1 
     */
    public GenericMammal(String species, String gender, Animal offspring1) {
        super(species, gender, offspring1);
    }
    
    /**
     * Mammal animal constructor.
     * @param species
     * @param gender
     * @param isOffspring 
     */
    public GenericMammal(String species, String gender, boolean isOffspring) {
        super(species, gender, isOffspring);
    }
    
    /**
     * Mammal animal constructor.
     * @param species
     * @param name
     * @param gender
     * @param doa
     * @param DOB 
     */
    public GenericMammal(String species, String name, String gender, String doa, String DOB){
        super(species, name, gender, doa, DOB);
    }
    
    /**
     * Mammal animal constructor.
     * @param species
     * @param name
     * @param gender
     * @param DOB 
     */
    public GenericMammal(String species, String name, String gender, String DOB){
        super(species, name, gender, DOB);
    }

}
