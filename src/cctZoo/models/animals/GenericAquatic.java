package cctZoo.models.animals;

import cctZoo.models.animals.abstracts.Animal;
import cctZoo.models.animals.interfaces.Aquatic;

/**
 * Concrete Aquatic animal.
 * @author rbsrafa
 */
public class GenericAquatic extends Animal implements Aquatic{
    
    /**
     * Aquatic animal constructor.
     * @param species
     * @param name
     * @param gender 
     */
    public GenericAquatic(String species, String name, String gender) {
        super(species, name, gender);
    }
    
    /**
     * Aquatic animal constructor.
     * @param species
     * @param gender 
     */
    public GenericAquatic(String species, String gender) {
        super(species, gender);
    }
    
    /**
     * Aquatic animal constructor.
     * @param species
     * @param gender
     * @param offspring1
     * @param offspring2 
     */
    public GenericAquatic(String species, String gender, Animal offspring1, Animal offspring2) {
        super(species, gender, offspring1, offspring2);
    }
    
    /**
     * Aquatic animal constructor.
     * @param species
     * @param gender
     * @param offspring1 
     */
    public GenericAquatic(String species, String gender, Animal offspring1) {
        super(species, gender, offspring1);
    }
    
    /**
     * Aquatic animal constructor.
     * @param species
     * @param gender
     * @param isOffspring 
     */
    public GenericAquatic(String species, String gender, boolean isOffspring) {
        super(species, gender, isOffspring);
    }
    
    /**
     * Aquatic animal constructor.
     * @param species
     * @param name
     * @param gender
     * @param doa
     * @param DOB 
     */
    public GenericAquatic(String species, String name, String gender, String doa, String DOB){
        super(species, name, gender, doa, DOB);
    }

}
