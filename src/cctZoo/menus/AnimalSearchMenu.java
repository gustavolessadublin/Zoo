package cctZoo.menus;

import cctZoo.controllers.AnimalsController;
import cctZoo.views.AnimalView;
import cctZoo.zooData.ZooData;

/**
 *
 * @author rbsrafa
 */
public class AnimalSearchMenu extends Menu{
    private AnimalsController animals;

    /**
     * Basic constructor that accepts a zoodata as argument.
     * @param zooData 
     */
    public AnimalSearchMenu(ZooData zooData) {
        super(zooData);
        this.animals = new AnimalsController(zooData.getAnimals(), new AnimalView());
        String[] options = {"Find Animal by ID", "Show Mammals", "Show Reptiles", "Show Avians",
                            "Show Insects", "Show Aquatics", "Return to Animal Menu", "Exit Program"};
        this.setOptions(options);
        this.setTitle("Animal Search Menu");
        this.startMenu();
    }

    /**
     * This method is responsible for linking the menu options with their
     * respective actions.
     */
    @Override
    public void optionSelector() {
        System.out.println("\nPlease select an option:");
        int option = this.validate.checkForInt(in);
        switch(option){
            case 1: this.findAnimal();
                break;
            case 2: this.animals.displayMammals();
                break;
            case 3: this.animals.displayReptiles();
                break;
            case 4: this.animals.displayAvians();
                break;
            case 5: this.animals.displayInsects();
                break;
            case 6: this.animals.displayAquatics();
                break;
            case 7: new AnimalMenu(this.zooData);
                break;
            case 8: System.exit(0);
                break;
        }
    }
    
    /**
     * This method interacts with the user to search for an animal.
     */
    private void findAnimal(){
        System.out.println("Please type the animal id:"); 
        System.out.println("Available ids from 1 to " + this.animals.getAnimals().size());
        int id = this.validate.checkForInt(this.in);
        if(this.animals.findAnimal(id) != null){ this.animals.display(this.animals.findAnimal(id)); }    
    }
    
    
}
