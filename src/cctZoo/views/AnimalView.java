/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.views;

import cctZoo.models.Model;

/**
 *
 * @author rbsrafa
 */
public class AnimalView extends View{

    @Override
    public void display(Model m) {
        System.out.println(m);
    }
    
}
