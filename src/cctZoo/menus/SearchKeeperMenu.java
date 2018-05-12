/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.menus;

 
import cctZoo.models.animals.abstracts.Animal;
import cctZoo.models.employees.zooKeeper.Qualification;
import cctZoo.zooData.ZooData;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for the Search Keepers menu.
 * @author Gustavo Lessa
 */
public class SearchKeeperMenu extends EmployeeMenu{

    /**
     * This constructor takes a ZooData object and calls its super
     * @param zooData - ZooData object
     */
    public SearchKeeperMenu(ZooData zooData) {
        super(zooData);
        this.setOptions(new String[]{"ID","Qualifications","Gender","Name",
            "Animal", "Amount of animals","Return to Keeper Menu",
            "Return to Main Menu","Exit Program"}); // set options
        this.setTitle("Search Keepers By:"); // set title
        this.startMenu(); // display menu
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
            case 9:
                this.exitProgram();
                break;
        }
    }
    
    /**
     * This method displays a keeper by ID.
     */
    private void searchKeeperById() {
        this.keepers.display(this.chooseId());
    }

    /**
     * This method searches keeper by qualifications and allow user to search
     * for ALL or ANY of those qualifications.
     */
    private void searchKeeperByQualification() {
        // get qualifications from user
        List<Qualification> qualifications = chooseQualifications();
        
        System.out.println("\nMust the keeper be specialized in ALL "
                + "chosen qualifications? (Y/N)");
        
        // if yes, all qualifications must be presented in the keeper object,
        // using 'true' as argument.
        if(validate.checkForYes(in)){
            // display message containing 'and' before the last qualification
            System.out.println("\nKeepers specialized in " 
                    + qualificationsNames(qualifications, true));
            // search for ALL qualifications
            this.keepers.searchQualifications(qualifications, true);
            
        } else {
            // display message conatining 'or' before the last qualification
            System.out.println("\nKeepers specialized in "+qualificationsNames(qualifications, false));
            // search for ANY qualification
            this.keepers.searchQualifications(qualifications, false); 
        }
    }
    
    /**
     * This method retrieves a String of all qualifications from a List, 
     * depending if ALL (using AND) qualification or ANY (using OR)
     * qualifications are needed.
     * @param qualifications (List<Qualification>)
     * @param all true for ALL and false for ANY
     * @return String - formated qualification names.
     */
    private String qualificationsNames(List<Qualification> qualifications, boolean all){
        String ans = "";
        int size = qualifications.size();
        String word = "";
        if (all){
            word = " and ";
        } else {
            word = " or ";
        }
        
        // concat using comma until size - 2.
        for(int x = 0; x < size-2; x++){
            ans = ans.concat(qualifications.get(x).toString().concat(", "));
        }
        
        // concat the last qualifications using the right word and ending in dot.
        ans = ans.concat(qualifications.get(size-2).toString().concat(word)
                .concat(qualifications.get(size-1).toString().concat(".")));
        return ans;
    }

    /**
     * This method searches keeper by gender.
     */
    private void searchKeeperGender() {
        // call searchGender() method using the gender chosen by the user and
        // returns false if no keepers were found
        if(!keepers.searchGender(this.chooseGender())){
            System.out.println("No keepers were found.");
        }
    }

    /**
     * This method searches keepers by name.
     */
    private void searchKeeperByName() {
        System.out.println("Please type the name (or part of name) to be "
                + "searched:");
        // call method that displays table of results and returns 'true' or 
        // returns false when no result were found
        if(!keepers.searchName(validate.checkForString(in))){
            System.out.println("No keepers were found.");
        }
    }

    /**
     * This method searches keepers by species.
     */
    private void searchKeeperByAnimal() {
        
        // create new list for unique species
        List<String> species = new ArrayList<>();
        
        // for each animal in the system
        for(Animal a : zooData.getAnimals()){ 
            // if specie wasn't already on the list, add it
            if(!species.contains(a.getSpecies())){ 
                species.add(a.getSpecies());
            }
        }
        
        // print species available
        System.out.println("\nSpecies available:");
        System.out.println("");
        for(int x = 0; x < species.size(); x++){
            System.out.println((x+1)+ " - "+species.get(x));
        }
        
        // ask for user input
        System.out.println("\nPlease choose an option:");
        
        // get user input and search for that specie, returning false if nothing
        // was found
        if(!keepers.searchSpecies(species.get((validate.checkForInt(in, 1, species.size()))-1))){
            System.out.println("No keepers were found.");
        }
    }

    /**
     * This method searches keepers for amount of animals under their care.
     */
    private void searchKeeperAmountAnimals() {
        System.out.println("Please choose the number of animals");
        System.out.println("From:");
        int from = validate.checkForInt(in, 0, 10);
        System.out.println("To:");
        int to = validate.checkForInt(in, 0, 10);
        
        // search for keepers using user input and return false if no results
        // were found
        if(!keepers.searchNumberOfAnimals(from, to)){
            System.out.println("No keepers found.");
        }
    }   
}
