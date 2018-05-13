package cctZoo.models.animals;

import cctZoo.models.animals.abstracts.Animal;
import cctZoo.models.animals.interfaces.Aquatic;
import cctZoo.models.animals.interfaces.Reptile;

/**
 * Concrete Aquatic Reptile class.
 * @author rbsrafa
 */
public class AquaticReptile extends Animal implements Aquatic, Reptile{
    
    /**
     * Aquatic Reptile constructor.
     * @param species
     * @param name
     * @param gender 
     */
    public AquaticReptile(String species, String name, String gender) {
        super(species, name, gender);
    }
    
    /**
     * Aquatic Reptile constructor.
     * @param species
     * @param gender 
     */
    public AquaticReptile(String species, String gender) {
        super(species, gender);
    }    
    
    /**
     * Aquatic Reptile constructor.
     * @param species
     * @param gender
     * @param offspring1
     * @param offspring2 
     */
    public AquaticReptile(String species, String gender, Animal offspring1, Animal offspring2) {
        super(species, gender, offspring1, offspring2);
    }
    
    /**
     * Aquatic Reptile constructor.
     * @param species
     * @param gender
     * @param offspring1 
     */
    public AquaticReptile(String species, String gender, Animal offspring1) {
        super(species, gender, offspring1);
    }
    
    /**
     * Aquatic Reptile constructor.
     * @param species
     * @param gender
     * @param isOffspring 
     */
    public AquaticReptile(String species, String gender, boolean isOffspring) {
        super(species, gender, isOffspring);
    }
    
    /**
     * Aquatic Reptile constructor.
     * @param species
     * @param name
     * @param gender
     * @param doa
     * @param DOB 
     */
    public AquaticReptile(String species, String name, String gender, String doa, String DOB){
        super(species, name, gender, doa, DOB);
    }
    
    /**
     * Aquatic Reptile constructor
     * @param species
     * @param name
     * @param gender
     * @param DOB 
     */
    public AquaticReptile(String species, String name, String gender,String DOB){
        super(species, name, gender,DOB);
    }
    
}
