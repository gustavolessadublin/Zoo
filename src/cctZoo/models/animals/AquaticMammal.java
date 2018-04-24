/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.models.animals;

import cctZoo.models.animals.abstracts.AbstractAnimal;
import cctZoo.models.animals.interfaces.Aquatic;
import cctZoo.models.animals.interfaces.Mammal;

/**
 *
 * @author rbsrafa
 */
public class AquaticMammal extends AbstractAnimal implements Aquatic, Mammal{
    
    public AquaticMammal(String species, String name, String gender) {
        super(species, name, gender);
    }
    
    public AquaticMammal(String species, String gender) {
        super(species, gender);
    }
    
}
