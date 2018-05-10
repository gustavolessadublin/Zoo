/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.models.animals;

import cctZoo.models.animals.abstracts.Animal;
import cctZoo.models.animals.interfaces.Mammal;

/**
 *
 * @author rbsrafa
 */
public class GenericMammal extends Animal implements Mammal{
    
    public GenericMammal(String species, String name, String gender) {
        super(species, name, gender);
    }
    
    public GenericMammal(String species, String gender) {
        super(species, gender);
    }
    
    public GenericMammal(String species, String gender, Animal offspring1, Animal offspring2) {
        super(species, gender, offspring1, offspring2);
    }
    
    public GenericMammal(String species, String gender, Animal offspring1) {
        super(species, gender, offspring1);
    }
    
    public GenericMammal(String species, String gender, boolean isOffspring) {
        super(species, gender, isOffspring);
    }
    
    public GenericMammal(String species, String name, String gender, String doa, String DOB){
        super(species, name, gender, doa, DOB);
    }
    public GenericMammal(String species, String name, String gender, String DOB){
        super(species, name, gender, DOB);
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
