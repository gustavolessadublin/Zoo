/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.menus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author rbsrafa
 */
public abstract class Menu {
    protected List<String> options;
    protected boolean exit;
    protected Scanner in;
    
    public Menu(){
        this.options = new ArrayList<>();
        this.in = new Scanner(System.in);
    }
    
    public abstract void optionSelector();
    
    public abstract void setOptions();
    
    public void displayMenu(){
        for(int i = 0; i < this.options.size(); i++){
            System.out.println((i+1) + " - " + this.options.get(i));
        }
    }
}
