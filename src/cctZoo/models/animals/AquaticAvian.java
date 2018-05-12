package cctZoo.models.animals;

import cctZoo.models.animals.abstracts.Animal;
import cctZoo.models.animals.interfaces.Aquatic;
import cctZoo.models.animals.interfaces.Avian;

/**
 * Concrete Aquatic Avian class.
 * @author rbsrafa
 */
public class AquaticAvian extends Animal implements Aquatic, Avian{
    
    /**
     * Aquatic Avian constructor.
     * @param species
     * @param name
     * @param gender 
     */
    public AquaticAvian(String species, String name, String gender) {
        super(species, name, gender);
    }
    
    /**
     * Aquatic Avian constructor
     * @param species
     * @param gender 
     */
    public AquaticAvian(String species, String gender) {
        super(species, gender);
    }
    
    /**
     * Aquatic Avian constructor
     * @param species
     * @param gender
     * @param offspring1
     * @param offspring2 
     */
    public AquaticAvian(String species, String gender, Animal offspring1, Animal offspring2) {
        super(species, gender, offspring1, offspring2);
    }
    
    /**
     * Aquatic Avian constructor
     * @param species
     * @param gender
     * @param offspring1 
     */
    public AquaticAvian(String species, String gender, Animal offspring1) {
        super(species, gender, offspring1);
    }
    
    /**
     * Aquatic Avian constructor
     * @param species
     * @param gender
     * @param isOffspring 
     */
    public AquaticAvian(String species, String gender, boolean isOffspring) {
        super(species, gender, isOffspring);
    }
    
    /**
     * Aquatic Avian constructor
     * @param species
     * @param name
     * @param gender
     * @param doa
     * @param DOB 
     */
    public AquaticAvian(String species, String name, String gender, String doa, String DOB){
        super(species, name, gender, doa, DOB);
    }

}
