/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.models.animals;

import cctZoo.models.animals.abstracts.Animal;
import cctZoo.models.animals.interfaces.Aquatic;
import cctZoo.models.animals.interfaces.Reptile;

/**
 *
 * @author rbsrafa
 */
public class AquaticReptile extends Animal implements Aquatic, Reptile{
    
    public AquaticReptile(String species, String name, String gender) {
        super(species, name, gender);
    }
    
    public AquaticReptile(String species, String gender) {
        super(species, gender);
    }
    
}
