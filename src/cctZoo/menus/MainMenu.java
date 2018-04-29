package cctZoo.menus;

import cctZoo.zooData.ZooData;

/**
 *
 * @author rbsrafa
 */
public class MainMenu extends Menu{    
    
    public MainMenu(ZooData zooData){
        super(zooData);
        String[] options = {"Animal Menu", "Employee Menu", "Exit Program"};
        this.setOptions(options);
        this.setTitle("Main Menu");
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
            case 1: new AnimalMenu(this.zooData);
                break;
            case 2: new EmployeeMenu();
                break;
            case 3: System.exit(0);
                break;
        }
    }

}
