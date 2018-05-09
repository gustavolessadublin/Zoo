/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.models.animals;

import cctZoo.models.animals.abstracts.Animal;
import cctZoo.models.animals.interfaces.Aquatic;
import cctZoo.models.animals.interfaces.Avian;

/**
 *
 * @author rbsrafa
 */
public class AquaticAvian extends Animal implements Aquatic, Avian{
    
    public AquaticAvian(String species, String name, String gender) {
        super(species, name, gender);
    }
    
    public AquaticAvian(String species, String gender) {
        super(species, gender);
    }
    
    public AquaticAvian(String species, String gender, Animal offspring1, Animal offspring2) {
        super(species, gender, offspring1, offspring2);
    }
    
    public AquaticAvian(String species, String gender, Animal offspring1) {
        super(species, gender, offspring1);
    }
    
    public AquaticAvian(String species, String gender, boolean isOffspring) {
        super(species, gender, isOffspring);
    }
    
    
}
