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
    
}
