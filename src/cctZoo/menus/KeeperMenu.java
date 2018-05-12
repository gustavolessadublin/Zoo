/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.menus;

import cctZoo.models.employees.zooKeeper.Qualification;
import cctZoo.zooData.ZooData;
import java.util.List;

/**
 *
 * @author gustavolessa1
 */
public class KeeperMenu extends EmployeeMenu {
    
    public KeeperMenu(ZooData zooData) {
        super(zooData);
        
        this.setOptions(new String[]{"List Keepers","Add Keeper","Search Keepers","Update Keeper","Return to main menu"});
        this.setTitle("Keeper Menu");
        this.startMenu();
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
        }
    }

    private void updateKeeper() {
        System.out.println("Update Keeper Wizard");
        int id = this.chooseId()-1;
        
        this.updateName(id);
        this.updateGender(id);
        this.updateQualifications(id);
        
        System.out.println("\nKeeper Updated!");
        this.keepers.display(keepers.getKeeper(id));
    }
    
    private void updateName(int id){
        System.out.println("\nCurrent name: "+keepers.getKeeper(id).getName());
        String name = this.chooseName();
        while (name.isEmpty()){
            this.chooseName();
        }
        keepers.getKeeper(id).setName(name);
    }
    
    private void updateGender(int id){
        System.out.println("\nCurrent gender: "+keepers.getKeeper(id).getGender());
        keepers.getKeeper(id).setGender(this.chooseGender());
    }
    
    private void updateQualifications(int id){
        System.out.println("\nCurrent qualifications: "+keepers.getKeeper(id).getQualifications());
        if(keepers.getKeeper(id).getQualifications().size()<3){
            System.out.println("Would you like to add another Qualification? (Y/N)");
            if(validate.checkForYes(in)){
                List<Qualification> qualifications = this.otherQualifications(keepers.getKeeper(id).getQualifications());
                for (int x = keepers.getKeeper(id).getQualifications().size(); x<3; x++){
                    System.out.println("Select a qualification:");
                    keepers.getKeeper(id).addQualification(qualifications.remove(this.chooseOption(qualifications)));
                    if (x < 2){
                        System.out.println("Would you like to add another one? (Y/N)");
                        if(!validate.checkForYes(in)){
                            break;
                        }               
                    }
                }               
            }
        }
    }
    
    private List<Qualification> otherQualifications(List<Qualification> qualifications){
        List<Qualification> options = Qualification.getQualifications();
        for(Qualification q : qualifications){
            options.remove(q);
        }
        return options;
    }
    
}
