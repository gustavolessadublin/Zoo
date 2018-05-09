package cctZoo.models.animals;

import cctZoo.models.animals.abstracts.Animal;
import cctZoo.models.animals.interfaces.Insect;

/**
 *
 * @author rbsrafa
 */
public class GenericInsect extends Animal implements Insect{
    
    public GenericInsect(String species, String name, String gender) {
        super(species, name, gender);
    }
    
    public GenericInsect(String species, String gender) {
        super(species, gender);
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
