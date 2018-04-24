/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.views;

import cctZoo.models.Model;
import cctZoo.views.interfaces.Displayable;

/**
 *
 * @author rbsrafa
 */
public class View implements Displayable{
    
    public View(){
        
    }

    @Override
    public void display(Model m) {
        System.out.println(m.toString());
    }

}
