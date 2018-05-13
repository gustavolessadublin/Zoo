package cctZoo.models.animals;

import cctZoo.models.animals.abstracts.Animal;
import cctZoo.models.animals.interfaces.Aquatic;
import cctZoo.models.animals.interfaces.Mammal;

/**
 * Aquatic Mammal concrete class.
 * @author rbsrafa
 */
public class AquaticMammal extends Animal implements Aquatic, Mammal{
    
    /**
     * Aquatic Mammal constructor.
     * @param species
     * @param name
     * @param gender 
     */
    public AquaticMammal(String species, String name, String gender) {
        super(species, name, gender);
    }
    
    /**
     * Aquatic Mammal constructor.
     * @param species
     * @param gender 
     */
    public AquaticMammal(String species, String gender) {
        super(species, gender);
    }
    
    /**
     * Aquatic Mammal constructor.
     * @param species
     * @param gender
     * @param offspring1
     * @param offspring2 
     */
    public AquaticMammal(String species, String gender, Animal offspring1, Animal offspring2) {
        super(species, gender, offspring1, offspring2);
    }
    
    /**
     * Aquatic Mammal constructor.
     * @param species
     * @param gender
     * @param offspring1 
     */
    public AquaticMammal(String species, String gender, Animal offspring1) {
        super(species, gender, offspring1);
    }
    
    /**
     * Aquatic Mammal constructor.
     * @param species
     * @param gender
     * @param isOffspring 
     */
    public AquaticMammal(String species, String gender, boolean isOffspring) {
        super(species, gender, isOffspring);
    }
    
    /**
     * Aquatic Mammal constructor.
     * @param species
     * @param name
     * @param gender
     * @param doa
     * @param DOB 
     */
    public AquaticMammal(String species, String name, String gender, String doa, String DOB){
        super(species, name, gender, doa, DOB);
    }
    
    /**
     * Aquatic Mammal constructor 
     * @param species
     * @param name
     * @param gender
     * @param DOB 
     */
    public AquaticMammal(String species, String name, String gender,String DOB){
        super(species, name, gender,DOB);
    }

}