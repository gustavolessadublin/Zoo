/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.models.animals;

import cctZoo.models.animals.abstracts.Animal;
import cctZoo.models.animals.interfaces.Avian;
import cctZoo.models.animals.interfaces.Mammal;

/**
 *
 * @author rbsrafa
 */
public class AvianMammal extends Animal implements Avian, Mammal{
    
    public AvianMammal(String species, String name, String gender) {
        super(species, name, gender);
    }
    
    public AvianMammal(String species, String gender) {
        super(species, gender);
    }
    
    public AvianMammal(String species, String gender, Animal offspring1, Animal offspring2) {
        super(species, gender, offspring1, offspring2);
    }
    
    public AvianMammal(String species, String gender, Animal offspring1) {
        super(species, gender, offspring1);
    }
    
    public AvianMammal(String species, String gender, boolean isOffspring) {
        super(species, gender, isOffspring);
    }
    
    public AvianMammal(String species, String name, String gender, String doa, String DOB){
        super(species, name, gender, doa, DOB);
    }

}
