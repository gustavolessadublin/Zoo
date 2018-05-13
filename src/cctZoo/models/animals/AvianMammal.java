package cctZoo.models.animals;

import cctZoo.models.animals.abstracts.Animal;
import cctZoo.models.animals.interfaces.Avian;
import cctZoo.models.animals.interfaces.Mammal;

/**
 * Concrete Avian Mammal class.
 * @author rbsrafa
 */
public class AvianMammal extends Animal implements Avian, Mammal{
    private boolean canFly = false;
    
    /**
     * Avian Mammal constructor.
     * @param species
     * @param name
     * @param gender 
     */
    public AvianMammal(String species, String name, String gender) {
        super(species, name, gender);
    }
    
    /**
     * Avian Mammal constructor.
     * @param species
     * @param gender 
     */
    public AvianMammal(String species, String gender) {
        super(species, gender);
    }
    
    /**
     * Avian Mammal constructor.
     * @param species
     * @param gender
     * @param offspring1
     * @param offspring2 
     */
    public AvianMammal(String species, String gender, Animal offspring1, Animal offspring2) {
        super(species, gender, offspring1, offspring2);
    }
    
    /**
     * Avian Mammal constructor.
     * @param species
     * @param gender
     * @param offspring1 
     */
    public AvianMammal(String species, String gender, Animal offspring1) {
        super(species, gender, offspring1);
    }
    
    /**
     * Avian Mammal constructor.
     * @param species
     * @param gender
     * @param isOffspring 
     */
    public AvianMammal(String species, String gender, boolean isOffspring) {
        super(species, gender, isOffspring);
    }
    
    /**
     * Avian Mammal constructor.
     * @param species
     * @param name
     * @param gender
     * @param doa
     * @param DOB 
     */
    public AvianMammal(String species, String name, String gender, String doa, String DOB){
        super(species, name, gender, doa, DOB);
    }
    
    /**
     * Avian Mammal constructor.
     * @param species
     * @param name
     * @param gender
     * @param DOB 
     */
    public AvianMammal(String species, String name, String gender,String DOB){
        super(species, name, gender,DOB);
    }

    @Override
    public boolean canFly() {
        return this.canFly;
    }

    @Override
    public void setFly(boolean b) {
        this.canFly = b;
    }

}
