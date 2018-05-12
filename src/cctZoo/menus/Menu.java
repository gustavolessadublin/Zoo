/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.menus;

import cctZoo.zooData.DataFactory;
import cctZoo.zooData.DataValidation;
import cctZoo.zooData.ZooData;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Abstract Menu class
 * @author rbsrafa
 */
public abstract class Menu {
    protected ZooData zooData;
    protected String title;
    protected List<String> options;
    protected boolean exit;
    protected Scanner in;
    protected DataValidation validate;
    protected DataFactory dataFactory;

    /**
     * Menu constructor that takes a ZooData as argument.
     * @param zooData (ZooData)
     */
    public Menu(ZooData zooData){
        this.zooData = zooData;
        this.validate = new DataValidation();
        this.dataFactory = new DataFactory(zooData);
        this.title = "Default title";
        this.options = new ArrayList<>();
        this.in = new Scanner(System.in);
    }
    
    public abstract void optionSelector();
    
    /**
     * This method displays and activate the menu option selector.
     * While the exit option is not chosen it will keep the menu on a loop.
     */
    public final void startMenu(){
        while(!this.exit){
            this.displayMenu();
            this.optionSelector();
        }
    }
    
    /**
     * This method sets the menu's options
     * @param options (String[])
     */
    public final void setOptions(String[] options){
        for(String s: options) this.options.add(s);
    }
    
    /**
     * This method gets an option from the user, validates it and return the option.
     * @param options
     * @return 
     */
    protected int chooseOption(List options){
        for(int x = 0; x < options.size(); x++){
            System.out.println((x+1)+" - "+options.get(x));
        }
        System.out.println("Please choose an option: ");
        return (validate.checkForInt(in, 1, options.size()))-1;
    }
    
    /**
     * This method displays the menu options on CLI.
     */
    private final void displayMenu(){
        System.out.println("");
        System.out.println(this.title);
        for(int i = 0; i < this.title.length(); i++) System.out.print("-");
        System.out.println("");
        for(int i = 0; i < this.options.size(); i++){
            System.out.println((i+1) + " - " + this.options.get(i));
        }
    }
    
    /**
     * This method sets the menu's title
     * @param title 
     */
    public final void setTitle(String title){
        this.title = title;
    }
}
