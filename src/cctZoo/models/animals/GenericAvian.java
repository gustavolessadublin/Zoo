package cctZoo.models.animals;

import cctZoo.models.animals.abstracts.Animal;
import cctZoo.models.animals.interfaces.Avian;

/**
 * Concrete Avian animal class.
 * @author rbsrafa
 */
public class GenericAvian extends Animal implements Avian{
    private boolean canFly = false;
    
    /**
     * Avian animal constructor.
     * @param species
     * @param name
     * @param gender 
     */
    public GenericAvian(String species, String name, String gender) {
        super(species, name, gender);
    }
    
    /**
     * Avian animal constructor.
     * @param species
     * @param gender 
     */
    public GenericAvian(String species, String gender) {
        super(species, gender);
    }
    
    /**
     * Avian animal constructor.
     * @param species
     * @param gender
     * @param offspring1
     * @param offspring2 
     */
    public GenericAvian(String species, String gender, Animal offspring1, Animal offspring2) {
        super(species, gender, offspring1, offspring2);
    }
    
    /**
     * Avian animal constructor.
     * @param species
     * @param gender
     * @param offspring1 
     */
    public GenericAvian(String species, String gender, Animal offspring1) {
        super(species, gender, offspring1);
    }
    
    /**
     * Avian animal constructor.
     * @param species
     * @param gender
     * @param isOffspring 
     */
    public GenericAvian(String species, String gender, boolean isOffspring) {
        super(species, gender, isOffspring);
    }
    
    /**
     * Avian animal constructor.
     * @param species
     * @param name
     * @param gender
     * @param doa
     * @param DOB 
     */
    public GenericAvian(String species, String name, String gender, String doa, String DOB){
        super(species, name, gender, doa, DOB);
    }
    
    /**
     * Avian animal constructor.
     * @param species
     * @param name
     * @param gender
     * @param DOB 
     */
    public GenericAvian(String species, String name, String gender,String DOB){
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
