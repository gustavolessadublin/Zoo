package cctZoo.menus;

import cctZoo.controllers.AnimalsController;
import cctZoo.views.AnimalView;
import cctZoo.zooData.ZooData;

/**
 *
 * @author rbsrafa
 */
public class AnimalMenu extends Menu{
    private AnimalsController animals;
    
    public AnimalMenu(ZooData zooData){
        super(zooData);
        this.animals = new AnimalsController(this.zooData.getAnimals(), new AnimalView());
        String[] options = {"Show Animals", "Add Animal", "Update Animal",
                            "Search Options", "Return to Main Menu", "Exit Program"};
        
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
            case 3: this.updateAnimal();
                break;
            case 4: new AnimalSubMenu(this.zooData);
                break;
            case 5: new MainMenu(this.zooData);
                break;
            case 6: System.exit(0);
                break;
        }
    }
    
    public void addAnimal(){
        
    }
    
    public void updateAnimal(){
        
    }
    
    public void returnToMain(){
        
    }
    
}
