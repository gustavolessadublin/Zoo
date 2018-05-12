/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.menus;

import cctZoo.models.employees.zooKeeper.Qualification;
import cctZoo.models.employees.zooKeeper.ZooKeeper;
import cctZoo.zooData.ZooData;
import java.util.List;

/**
 * This class extends EmployeeMenu class to create a keeper menu.
 * @author Gustavo Lessa
 */
public class KeeperMenu extends EmployeeMenu {
    
    // constructor takes ZooData object as argument
    public KeeperMenu(ZooData zooData) {
        super(zooData);
        
        this.setOptions(new String[]{"List Keepers","Add Keeper",
            "Search Keepers","Update Keeper","Return to Main Menu",
            "Exit Program"}); // set options
        this.setTitle("Keeper Menu"); // set title
        this.startMenu(); // start menu (method from super)
    }
    
    @Override
    public void optionSelector() {
        System.out.println("\nPlease select an option:");
        int option = this.in.nextInt();
        switch(option){
            case 1:
                this.showKeepers();
                break;
            case 2:
                this.addKeeper();
                break;
            case 3:
                new SearchKeeperMenu(this.zooData);
                break;
            case 4:
                this.updateKeeper();
                break;                
            case 5:
                new MainMenu(this.zooData);
                break;
            case 6:
                this.exitProgram();
                break;
        }
    }
    
    /**
     * This method updates a ZooKeeper's fields by calling other methods that
     * guide the user through the process.
     */
    private void updateKeeper() {
        System.out.println("Update Keeper Wizard");
        int index = this.chooseId()-1; // get index from user input
        
        // update fields from user input
        this.updateName(index);
        this.updateGender(index);
        this.updateQualifications(index);
        
        // confirm update was successful and displays the new info
        System.out.println("\nKeeper Updated!");
        this.keepers.display(keepers.getKeeper(index));
    }
    
    /**
     * This method displays current name and returns user input for new name.
     * @param index - int (position on the List)
     */
    private void updateName(int index){
        System.out.println("\nCurrent name: "+keepers.getKeeper(index).getName());
        String name = this.chooseName(); // method from super
        while (name.isEmpty()){ // avoids empty lines
            this.chooseName();
        }
        keepers.getKeeper(index).setName(name);
    }
    
    /**
     * This method displays current gender and asks user to input new one.
     * @param index - int (position on the List).
     */
    private void updateGender(int index){
        System.out.println("\nCurrent gender: "+keepers.getKeeper(index).getGender());
        keepers.getKeeper(index).setGender(this.chooseGender());
    }
    
    /**
     * This method updates the qualifications by adding according to user
     * input, when the limit of 3 
     * @param index 
     */
    private void updateQualifications(int index){
        
        // check if the limit of qualifications was reached already
        if(keepers.getKeeper(index).getQualifications().size()<
                ZooKeeper.getLimit()){
            
            // show current qualifications
            System.out.println("\nCurrent qualifications: "
                    +keepers.getKeeper(index).getQualifications());           
            
            // if user wants to add another qualification
            System.out.println("Would you like to add another "
                    + "Qualification? (Y/N)");
            if(validate.checkForYes(in)){
                
                // retrieve list of qualifications the keeper doesn' have
                List<Qualification> qualifications
                        = this.otherQualifications(keepers.getKeeper(index)
                                .getQualifications());
                
                // for the number of qualifications allowed to add
                for (int x = keepers.getKeeper(index).getQualifications()
                        .size(); x<ZooKeeper.getLimit(); x++){
                    
                    // ask user to choose one and get input
                    System.out.println("Select a qualification:");
                    keepers.getKeeper(index).addQualification(qualifications.remove(this.chooseOption(qualifications)));
                    
                    // if it isn't the last one, ask if the user wants to add
                    // another qualification
                    if (x < 2){
                        System.out.println("Would you like to add another one? (Y/N)");
                        if(!validate.checkForYes(in)){
                            break;
                        }               
                    }
                }               
            }
        } else { // if limit was reached
            System.out.println("This keeper has already the limit of "
                    + "qualifications");
        }
    }
    
    /**
     * This method takes a List<Qualification> and retrieves the complementar
     * list, containing all Qualifications non existent on the given list.
     * @param qualifications (List<Qualification>)
     * @return List<Qualification> of items not present on first list.
     */
    private List<Qualification> otherQualifications(List<Qualification> qualifications){
        List<Qualification> allOptions = Qualification.getQualifications();
        for(Qualification q : qualifications){
            allOptions.remove(q);
        }
        return allOptions;
    }
    
}
