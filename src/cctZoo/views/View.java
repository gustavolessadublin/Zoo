package cctZoo.views;

import cctZoo.views.interfaces.Displayable;

/**
 * This class provides a CLI for models.
 * @author rbsrafa
 */
public class View implements Displayable{
    
    /**
     * Default View constructor.
     */
    public View(){
        
    }

    /**
     * This method displays the details of a given model.
     * @param m (Model)
     */
    @Override
    public void display(Object m){
        System.out.println(m);
    }
}
