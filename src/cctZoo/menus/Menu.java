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
    protected String title;
    protected List<String> options;
    protected boolean exit;
    protected Scanner in;
    
    /**
     * Default Menu constructor.
     */
    public Menu(){
        this.title = "Default title";
        this.options = new ArrayList<>();
        this.in = new Scanner(System.in);
    }
    
    public abstract void optionSelector();
    
    public void startMenu(){
        while(!this.exit){
            this.displayMenu();
            this.optionSelector();
        }
    }
    
    public void setOptions(String[] options){
        for(String s: options){
            this.options.add(s);
        }
    }
    
    /**
     * This method displays the menu options on CLI.
     */
    private void displayMenu(){
        System.out.println(this.title);
        for(int i = 0; i < this.title.length(); i++) System.out.print("-");
        System.out.println("\n");
        for(int i = 0; i < this.options.size(); i++){
            System.out.println((i+1) + " - " + this.options.get(i));
        }
    }
    
    public void setTitle(String title){
        this.title = title;
    }
}
