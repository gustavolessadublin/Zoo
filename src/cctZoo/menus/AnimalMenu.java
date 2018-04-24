/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.menus;

import cctZoo.controllers.AnimalsController;
import cctZoo.views.View;
import cctZoo.zooData.ZooData;

/**
 *
 * @author rbsrafa
 */
public class AnimalMenu extends Menu{
    private AnimalsController animals;
    
    public AnimalMenu(ZooData zooData){
        this.animals = new AnimalsController(zooData.getAnimals(), new View());
        this.setOptions();
        while(!this.exit){
            System.out.println("\nAnimal Menu\n-----------\n");
            this.displayMenu();
            this.optionSelector();
        }
        
    }

    @Override
    public void optionSelector() {
        System.out.println("\nPlease select an option:");
        int option = this.in.nextInt();
        switch(option){
            case 1: this.showAnimals();
                break;
            case 2: this.addAnimal();
                break;
            case 3: this.searchAnimal();
                break;
            case 4: this.updateAnimal();
                break;
            case 5: this.showMammals();
                break;
            case 6: this.showReptiles();
                break;
            case 7: this.showAvians();
                break;
            case 8: this.showInsects();
                break;
            case 9: this.showAquatics();
                break;
            case 10: System.exit(0);
                break;    
        }
    }

    @Override
    public void setOptions() {
        String[] options = {"Show Animals", "Add Animal", "Search Animal",
                            "Update Animal", "Show Mammals", "Show Reptiles",
                            "Show Avians", "Show Insects", "Show Aquatics",
                            "Exit Program"};
        for(String s: options){
            this.options.add(s);
        }
    }
    
    public void showAnimals(){
        this.animals.display();
    }
    
    public void addAnimal(){
        
    }
    
    public void searchAnimal(){
        
    }
    
    public void updateAnimal(){
        
    }
    
    public void showMammals(){
        this.animals.displayMammals();
    }
    
    public void showReptiles(){
        this.animals.displayReptiles();
    }
    
    public void showAvians(){
        this.animals.displayAvians();
    }
    
    public void showInsects(){
        this.animals.displayInsects();
    }
    
    public void showAquatics(){
        this.animals.displayAquatics();
    }
    
}
