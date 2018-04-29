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
        super(zooData);
        this.animals = new AnimalsController(this.zooData.getAnimals(), new View());
        String[] options = {"Show Animals", "Add Animal", "Search Animal",
                            "Update Animal", "Show Mammals", "Show Reptiles",
                            "Show Avians", "Show Insects", "Show Aquatics",
                            "Return to Main Menu", "Exit Program"};
        
        this.setOptions(options);
        this.setTitle("Animal Menu");
        this.startMenu();
    }

    /**
     * This method is responsible for linking the menu options with their
     * respective actions.
     */
    @Override
    public void optionSelector() {
        System.out.println("\nPlease select an option:");
        int option = this.in.nextInt();
        switch(option){
            case 1: this.animals.display();
                break;
            case 2: this.addAnimal();
                break;
            case 3: this.searchAnimal();
                break;
            case 4: this.updateAnimal();
                break;
            case 5: this.animals.displayMammals();
                break;
            case 6: this.animals.displayReptiles();
                break;
            case 7: this.animals.displayAvians();
                break;
            case 8: this.animals.displayInsects();
                break;
            case 9: this.animals.displayAquatics();
                break;
            case 10: new MainMenu(this.zooData);
                break;
            case 11: System.exit(0);
                break;
        }
    }
    
    public void addAnimal(){
        
    }
    
    public void searchAnimal(){
        
    }
    
    public void updateAnimal(){
        
    }
    
    public void returnToMain(){
        
    }
    
}
