/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.menus;

import cctZoo.controllers.EmployeesController;
import cctZoo.models.employees.zooKeeper.Qualification;
import cctZoo.models.employees.zooKeeper.ZooKeeper;
import cctZoo.views.KeeperView;
import cctZoo.zooData.DataValidation;
import cctZoo.zooData.ZooData;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo Lessa
 */
public abstract class EmployeeMenu extends Menu{
    protected EmployeesController keepers;

   
    public EmployeeMenu(ZooData zooData){
        super(zooData);
        this.keepers = new EmployeesController((ArrayList<ZooKeeper>) zooData.getZooKeepers(), new KeeperView());

    }

    protected void showKeepers() {
        this.keepers.display();
    }
    
    protected void showKeeper(ZooKeeper k){
        this.keepers.display(k);
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
        
        System.out.println("\nWould you like to add this keeper?");
        if (validate.checkForYes(in)){
            keepers.add(new ZooKeeper(gender,name,qualifications));
        }
    }
    
    protected List getQualifications(){
        System.out.println("\nWould you like to choose the qualifications?");
        List<Qualification> qualifications = null;
        if(validate.checkForYes(in)){
            qualifications = chooseQualifications();
        } else {
            qualifications = dataFactory.randomQualifications();
        }
        return qualifications;
    }
    
    
    protected List chooseQualifications(){
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
    
    protected int chooseOption(List options){
        for(int x = 0; x < options.size(); x++){
            System.out.println((x+1)+" - "+options.get(x));
        }
        System.out.println("Please choose an option: ");
        return (validate.checkForInt(in, 1, options.size()))-1;
    }
    
    protected String getGender(){
        System.out.println("\nWould you like to choose the gender? (Y/N)");
        if(validate.checkForYes(in)){
            return chooseGender();
        } else {
            return dataFactory.randomGender();
        }
    }
    
    protected String chooseGender(){
        System.out.println("1 - Male");
        System.out.println("2 - Female");
        System.out.println("Please choose a gender: ");
        int ans = validate.checkForInt(in, 1, 2);
        if (ans == 1){
            return "Male";
        } else {
            return "Female";
        }
    }
    
    protected String chooseName(){
        String name;
        name = (printChooseName("first name"));
        name = name.concat(" ").concat(printChooseName("last name"));
        return name;
    }
    
    protected String getName(String gender){
        String name;
        if(userWantsToChooseName()){
            return chooseName();
        } else {
            name = dataFactory.getRandomName(gender);
        }
        return name;
    }
    
    protected boolean userWantsToChooseName(){
        System.out.println("Would you like to choose the keeper's name? (Y/N)");
        return validate.checkForYes(in);
    }
    
    protected String printChooseName(String question) {
        System.out.println("Please choose the "+question+":");
        String ans = "";
        while(ans.isEmpty()){
            ans = in.nextLine();
        }
        return ans;
    }
    
    protected int chooseId(){
        System.out.println("The following IDs are currently in the database:");
        List<Integer> ids = this.keepers.getAllIds();
        
        for(int x = 0; x < ids.size(); x++){
            if(x%6 == 0){System.out.println("");}
            System.out.print(ids.get(x) + "\t");
        }
        System.out.println("\nPlease choose an ID: ");
        return validate.checkForInt(in, ids.get(0), ids.get(ids.size()-1));
    }
}
