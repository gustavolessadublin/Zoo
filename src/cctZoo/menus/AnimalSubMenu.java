package cctZoo.menus;

import cctZoo.controllers.AnimalsController;
import cctZoo.views.AnimalView;
import cctZoo.zooData.ZooData;

/**
 *
 * @author rbsrafa
 */
public class AnimalSubMenu extends Menu{
    private AnimalsController animals;

    public AnimalSubMenu(ZooData zooData) {
        super(zooData);
        this.animals = new AnimalsController(zooData.getAnimals(), new AnimalView());
        String[] options = {"Show Mammals", "Show Reptiles", "Show Avians",
                            "Show Insects", "Show Aquatics", "Return to Animal Menu", "Exit Program"};
        this.setOptions(options);
        this.setTitle("Animal Search Menu");
        this.startMenu();
    }

    @Override
    public void optionSelector() {
        System.out.println("\nPlease select an option:");
        int option = this.in.nextInt();
        switch(option){
            case 1: this.animals.displayMammals();
                break;
            case 2: this.animals.displayReptiles();
                break;
            case 3: this.animals.displayAvians();
                break;
            case 4: this.animals.displayInsects();
                break;
            case 5: this.animals.displayAquatics();
                break;
            case 6: new AnimalMenu(this.zooData);
                break;
            case 7: System.exit(0);
                break;
        }
    }
    
}
