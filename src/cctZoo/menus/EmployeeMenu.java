/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.menus;

import cctZoo.controllers.EmployeesController;
import cctZoo.models.employees.zooKeeper.Qualification;
import cctZoo.models.employees.zooKeeper.ZooKeeper;
import cctZoo.views.View;
import cctZoo.zooData.DataValidation;
import cctZoo.zooData.ZooData;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo Lessa
 */
public class EmployeeMenu extends Menu{
    private EmployeesController keepers;
    private DataValidation validate;
   
    public EmployeeMenu(ZooData zooData){
        super(zooData);
        validate = new DataValidation();
        this.keepers = new EmployeesController((ArrayList<ZooKeeper>) zooData.getZooKeepers(), new View());
        String[] options = {"List Keepers","Add Keeper","Search Keepers","Search Options", "Return to main menu", "Exit Program"};
        this.setOptions(options);
        this.setTitle("Keeper Menu");
        this.startMenu();
    }

    @Override
    public void optionSelector() {
        System.out.println("\nPlease select an option:");
        int option = this.in.nextInt();
        switch(option){
            case 1: this.showKeepers();
                break;
            case 2: this.addKeeper();
                break;
            case 3: this.searchKeeper();
                break;
            case 4: new MainMenu(this.zooData);
                break;
            case 5: System.exit(0);
                break;
        }
    }


    protected void showKeepers() {
        this.keepers.display();
    }

    protected void addKeeper() {
        
        System.out.println("Add Keeper Wizard");
  
        String gender = getGender();
        String name = getName(gender);
        List<Qualification> qualifications = getQualifications();
        
        System.out.println("\nConfirm keeper's information:");
        System.out.println("\nGender: "+gender);
        System.out.println("Name: "+name);
        System.out.println("Qualifications: "+qualifications);
        
        System.out.println("Would you like to add this keeper?");
        if (validate.checkForYes(in)){
            keepers.add(new ZooKeeper(gender,name,qualifications));
        }
    }
    
    private List getQualifications(){
        System.out.println("Would you like to choose the qualifications?");
        List<Qualification> qualifications = null;
        if(validate.checkForYes(in)){
            qualifications = chooseQualifications();
        } else {
            qualifications = dataFactory.randomQualifications();
        }
        return qualifications;
    }
    
    private List chooseQualifications(){
        List<Qualification> qualifications = Qualification.getQualifications();
        List<Qualification> chosen = new ArrayList<>();
        for (int x = 0; x<3; x++){
            System.out.println("Select a qualification:");
            chosen.add(qualifications.remove(chooseOption(qualifications)));
            if (x < 2){
                System.out.println("Would you like to add another one? (Y/N)");
                if(!validate.checkForYes(in)){
                    break;
                }               
            }
        }
        return chosen;
    }
    
    private int chooseOption(List options){
        for(int x = 0; x < options.size(); x++){
            System.out.println((x+1)+" - "+options.get(x));
        }
        System.out.println("Please choose an option: ");
        return (validate.checkForInt(in, 1, options.size()))-1;
    }
    
    private String getGender(){
        System.out.println("Would you like to choose the gender? (Y/N)");
        if(validate.checkForYes(in)){
            System.out.println("1 - Male");
            System.out.println("2 - Female");
            System.out.println("Please choose an option: ");
            int ans = validate.checkForInt(in, 1, 2);
            if (ans == 1){
                return "Male";
            } else if (ans == 2){
                return "Female";
            }
        } else {
            return dataFactory.randomGender();
        }
        return getGender();
    }
    
    private String getName(String gender){
        String name;
        if(userWantsToChooseName()){
            name = (printChooseName("first name"));
            name = name.concat(" ").concat(printChooseName("last name")); 
        } else {
            name = dataFactory.getRandomName(gender);
        }
        return name;
    }
    
    private boolean userWantsToChooseName(){
        System.out.println("Would you like to choose the keeper's name? (Y/N)");
        return validate.checkForYes(in);
    }
    
    private String printChooseName(String question) {
        System.out.println("Please choose the "+question+":");
        return in.nextLine();
    }

    protected void searchKeeper() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
