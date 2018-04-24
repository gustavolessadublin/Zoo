/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.models.animals;

import cctZoo.models.animals.abstracts.AbstractAnimal;
import cctZoo.models.animals.interfaces.Reptile;

/**
 *
 * @author rbsrafa
 */
public class GenericReptile extends AbstractAnimal implements Reptile{
    
    public GenericReptile(String species, String name, String gender) {
        super(species, name, gender);
    }
    
    public GenericReptile(String species, String gender) {
        super(species, gender);
    }
    
}
