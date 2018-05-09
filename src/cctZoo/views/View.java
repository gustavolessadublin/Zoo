package cctZoo.views;

import cctZoo.models.Model;
import cctZoo.views.interfaces.Displayable;

/**
 * This class provides a CLI for models.
 * @author rbsrafa
 */
public class View implements Displayable{
    // TODO implement table mode on View
    public View(){
        
    }

    /**
     * This method displays the details of a given model.
     * @param m (Model)
     */
    @Override
    public void display(Model m){
        System.out.println(m);
    }
}
