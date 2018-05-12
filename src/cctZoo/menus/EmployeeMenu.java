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
import cctZoo.zooData.ZooData;
import java.util.ArrayList;
import java.util.List;

/**
 * This abstract class represents any menus regarding employees. 
 * @author Gustavo Lessa
 */
public abstract class EmployeeMenu extends Menu{
    protected EmployeesController keepers; // controller to perform operations

    /**
     * Constructor takes a ZooData object as argument.
     * @param zooData - ZooData object
     */
    public EmployeeMenu(ZooData zooData){
        super(zooData); // calls constructor from super
        this.keepers = new EmployeesController((ArrayList<ZooKeeper>) zooData
                .getZooKeepers(), new KeeperView()); // new controller
    }

    /**
     * This method exits the program after displaying a message.
     */
    protected void exitProgram(){
        System.out.println("Closing program...");
        System.exit(0);
    }
    
    /**
     * This method displays all keepers
     */
    protected void showKeepers() {
        this.keepers.display(); // call method from controller
    }
    
    /**
     * This method displays the keeper given as argument.
     * @param k - ZooKeeper object
     */
    protected void showKeeper(ZooKeeper k){
        this.keepers.display(k); // call method from controller
    }
    

    /**
     * This method guides the user through the creation of a new keeper,
     * calling other methods to retrieve the required information.
     */
    protected void addKeeper() {   
        System.out.println("Add Keeper Wizard");
  
        String gender = getGender(); // call method to let user choose gender
        String name = getName(gender); // call method to let user call name.
        List<Qualification> qualifications = getQualifications(); // method 
                                         //to let user choose qualifications
        //Confirm informtion
        System.out.println("\nConfirm keeper's information:");
        System.out.println("\nGender: "+gender);
        System.out.println("Name: "+name);
        System.out.println("Qualifications: "+qualifications);
        
        System.out.println("\nWould you like to add this keeper? (Y/N)");
        if (validate.checkForYes(in)){ // wait for user input and validate it
            keepers.add(new ZooKeeper(gender,name,qualifications)); // add keeper
        }
    }
    
    /**
     * This method returns a List of qualifications chosen by the user or 
     * generated randomly, according the user's decision.
     * @return List of qualifications.
     */
    protected List getQualifications(){
        System.out.println("\nWould you like to choose the qualifications?");
        List<Qualification> qualifications = null;
        if(validate.checkForYes(in)){ // is user wants to choose
            qualifications = chooseQualifications(); // get the input
        } else { // if user doesn't want to choose
            qualifications = dataFactory.randomQualifications(); //generate
                                                                 // randomly
        }
        return qualifications; // return List<Qualification>
    }
    
    /**
     * This method allows user to choose qualifications.
     * @return List<Qualification>
     */
    protected List chooseQualifications(){
        // retrieve all options available from Enum
        List<Qualification> qualifications = Qualification.getQualifications();
        
        // create a List of qualifications to be filled with the chosen ones
        List<Qualification> chosen = new ArrayList<>(); 
        for (int x = 0; x<ZooKeeper.getLimit(); x++){ // for 'limit' times allow user choose
                                       // a new qualification
            System.out.println("Select a qualification:");
            
            // chooseOption method returns index of option chosen by user
            // remove from qualification list while addint to chosen list
            chosen.add(qualifications.remove(chooseOption(qualifications)));
            if (x < 2){ // if it isn't the last iteration
                // user can decide if another one will be added
                System.out.println("Would you like to add another one? (Y/N)");
                if(!validate.checkForYes(in)){
                    break;
                }               
            }
        }
        return chosen; // return list of chosen qualifications
    }
    
    /**
     * This method returns a gender chosen by the user or generated randomly,
     * according to user's decision.
     * @return String - gender
     */
    protected String getGender(){
        System.out.println("\nWould you like to choose the gender? (Y/N)");
        if(validate.checkForYes(in)){ // if user wants to choose
            return chooseGender(); // get input
        } else { // if user doesn't want to choose
            return dataFactory.randomGender(); // generate randomly
        }
    }
    
    /**
     * This method allows the user to choose a gender.
     * @return String - gender.
     */
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
    
    /**
     * This method returns a String input by user
     * @return 
     */
    protected String chooseName(){
        String name; // a single String in the format "Firstname Lastname"
        name = (printChooseName("first name")); // ask user to input first name
        name = name.concat(" ").concat(printChooseName("last name"));// last name
        return name; // return concatenated String
    }
    
    /**
     * This method returns a name (String) input by the user or generated
     * randomly, according to user's decision.
     * @param gender (String)
     * @return String - name
     */
    protected String getName(String gender){
        String name;
        if(userWantsToChooseName()){ // as it reads...
            return chooseName(); // call method to receive input
        } else { // if user doens't want to choose
            name = dataFactory.getRandomName(gender); //generate randomly
        }
        return name;
    }
    
    /**
     * This method asks if user wants to choose name and returns input
     * @return true if user wants to choose a name for the keeper
     */
    protected boolean userWantsToChooseName(){
        System.out.println("Would you like to choose the keeper's name? (Y/N)");
        return validate.checkForYes(in);
    }
    
    /**
     * Method to ask user to input something based on a String.
     * @param question - a String to be inserted in the sentence.
     * @return String - line input by the user
     */
    protected String printChooseName(String question) {
        System.out.println("Please choose the "+question+":");
        String ans = "";
        while(ans.isEmpty()){
            ans = in.nextLine();
        }
        return ans;
    }
    
    /**
     * This method displays a list of existing IDs and return the user input.
     * @return int - ID chosen by the user.
     */
    protected int chooseId(){
        System.out.println("The following IDs are currently in the database:");
        List<Integer> ids = this.keepers.getAllIds(); // get all IDs.
        
        // display them nicely
        for(int x = 0; x < ids.size(); x++){
            if(x%6 == 0){System.out.println("");}
            System.out.print(ids.get(x) + "\t");
        }
        
        // ask user for input
        System.out.println("\nPlease choose an ID: ");
        
        // retrieved validated input considering the available options
        return validate.checkForInt(in, ids.get(0), ids.get(ids.size()-1));
    }
}
