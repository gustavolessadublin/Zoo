/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.menus;

 
import cctZoo.controllers.EmployeesController;
import cctZoo.models.animals.abstracts.Animal;
import cctZoo.models.employees.zooKeeper.Qualification;
import cctZoo.models.employees.zooKeeper.ZooKeeper;
import cctZoo.views.KeeperView;
import cctZoo.zooData.ZooData;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gustavolessa1
 */
public class SearchKeeperMenu extends EmployeeMenu{
  // private EmployeesController keepers;

    public SearchKeeperMenu(ZooData zooData) {
        super(zooData);
        this.setOptions(new String[]{"ID","Qualifications","Gender","Name","Animal",
            "Amount of animals","Return to Keeper Menu","Return to Main Menu"});
        this.setTitle("Search Keepers By:");
        this.startMenu();
    }


    @Override
    public void optionSelector() {
        System.out.println("\nPlease select an option:");
        int option = this.in.nextInt();
        switch(option){
            case 1:
                this.searchKeeperById();
                break;
            case 2:
                this.searchKeeperByQualification();
                break;
            case 3:
                this.searchKeeperGender();
                break;
            case 4:
                this.searchKeeperByName();
                break;    
            case 5:
                this.searchKeeperByAnimal();
                break;
            case 6:
                this.searchKeeperAmountAnimals();
                break;
            case 7:
                new KeeperMenu(this.zooData);
                break;
            case 8:
                new MainMenu(this.zooData);
                break;
        }
    }


    
    private void searchKeeperById() {
        this.keepers.display(chooseId());
    }

    private void searchKeeperByQualification() {
        List<Qualification> qualifications = chooseQualifications();
        System.out.println("\nMust the keeper be specialized in ALL chosen qualifications? (Y/N)");
        
        if(validate.checkForYes(in)){
            System.out.println("\nKeepers specialized in "+qualificationsNames(qualifications, true));
            this.keepers.searchQualifications(qualifications, true);
        } else {
            System.out.println("\nKeepers specialized in "+qualificationsNames(qualifications, false));
            this.keepers.searchQualifications(qualifications, false); 
        }

    }
    
    private String qualificationsNames(List<Qualification> qualifications, boolean all){
        String ans = "";
        int size = qualifications.size();
        String word = "";
        if (all){
            word = " and ";
        } else {
            word = " or ";
        }
        for(int x = 0; x < size-2; x++){
            ans = ans.concat(qualifications.get(x).toString().concat(", "));
        }
        ans = ans.concat(qualifications.get(size-2).toString().concat(word)
                .concat(qualifications.get(size-1).toString().concat(".")));
        return ans;
    }

    private void searchKeeperGender() {
        if(!keepers.searchGender(this.chooseGender())){
            System.out.println("No keepers were found.");
        }
    }

    private void searchKeeperByName() {
        System.out.println("Please type the name (or part of name) to be searched:");
        if(!keepers.searchName(validate.checkForString(in))){
            System.out.println("No keepers were found.");
        }
    
    }

    private void searchKeeperByAnimal() {
        List<String> species = new ArrayList<>();
        for(Animal a : zooData.getAnimals()){
            if(!species.contains(a.getSpecies())){
                species.add(a.getSpecies());
            }
        }
        System.out.println("\nSpecies available:");
        System.out.println("");
        for(int x = 0; x < species.size(); x++){
            System.out.println((x+1)+ " - "+species.get(x));
        }
        System.out.println("\nPlease choose an option:");
        if(!keepers.searchSpecies(species.get((validate.checkForInt(in, 1, species.size()))-1))){
            System.out.println("No keepers were found.");
        }
    }

    private void searchKeeperAmountAnimals() {
        System.out.println("Please choose the number of animals");
        System.out.println("From:");
        int from = validate.checkForInt(in, 0, 10);
        System.out.println("To:");
        int to = validate.checkForInt(in, 0, 10);
        if(!keepers.searchNumberOfAnimals(from, to)){
            System.out.println("No keepers found.");
        }
    }
    
    
}
