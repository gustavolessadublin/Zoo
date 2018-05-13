/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.controllers;

import cctZoo.models.animals.abstracts.Animal;
import cctZoo.models.employees.zooKeeper.Qualification;
import cctZoo.models.employees.zooKeeper.ZooKeeper;
import cctZoo.views.KeeperView;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;

/**
 * This class is the controller for the employees (ZooKeepers).
 * @author Gustavo Lessa
 */
public class EmployeesController {
    private List<ZooKeeper> keepers;
    private KeeperView view;
    
    /**
     * This constructor takes a List of ZooKeepers and a KeeperView object as 
     * arguments.
     * @param keepers - List
     * @param view - KeeperView object.
     */
    public EmployeesController(List<ZooKeeper> keepers, KeeperView view){
        this.keepers = keepers;
        this.view = view;
    }
    
    /**
     * This method generates a List containing the ID of all the 
     * keepers from the zoo.
     * @return 
     */
    public List<Integer> getAllIds(){
        List<Integer> ids = new ArrayList<>(); //creates new ArrayList
        for(ZooKeeper k : keepers){ // for each loop through all keepers 
            ids.add(k.getId()); // add ID of the current to the IDs list.
        }
        return ids; //return the list
    }
    
    /**
     * This method retrieves a keeper using an ID number.
     * @param id - Integer
     * @return ZooKeeper object.
     */
    public ZooKeeper getKeeperById(int id){ 
        
        for(ZooKeeper k : keepers){ // for each zookeeper in the system
            if (k.getId()==id){     // if the current "keeper id" equals "id"
                return k;           // return current ZooKeeper object
            }
        }
        System.out.println("ID not found!"); // displayed only if not found
        return null;                         // returns null if not found
    }
    
    public ZooKeeper getKeeper(int index){
        return this.keepers.get(index);
    }
    
    /**
     * This method is overloaded and when taking no arguments, displays info 
     * about ALL keepers calling methods from KeeperView.
     */
    public void display(){
        this.view.clearTable();             // clear existing table
        for(ZooKeeper k: keepers){          // for each zookeeper
            this.view.addKeeperToTable(k);  // call method from KeeperView to 
        }                                   // add the current keeper to table
        this.view.displayTable();   // calls the method to display the table
    }
    
    /**
     * This method is overloaded and when taking an int keeperId as argument,
     * displays info about the keeper that has that ID.
     * @param keeperId - int
     */
    public void display(int keeperId){
        int counter = 0;                // counter to check if keeper was found
        for(ZooKeeper k : keepers){     // for each keeper
            if (k.getId()==keeperId){   // if Ids match
                counter++;              // adds 1 to the counter
                this.display(k);        // calls display(Object k) method
                break;                  // break out of the loop
            }
        }
        if(counter==0){ // if not found
            System.out.println("ID not found!"); // print message
        }
    }

    /**
     * This method is overloaded and when taking an Object, prints it calling
     * the display(Object k) method from KeeperView.
     * @param k - an Object
     */
    public void display(Object k) {
        this.view.display("\n"+ k); // calls KeeperView method to display
    }
    
    /**
     * This method is overloaded and when taking a List, it creates
     * a table from their info and displays it, calling methods from
     * KeeperView object.
     * @param group - List
     */
    public void display(List<ZooKeeper> group){
        this.view.clearTable();     // clear existing table
        for(ZooKeeper k: group){    // for each keeper in the given group
            this.view.addKeeperToTable(k); // add it to the table
        }
        this.view.displayTable(); // display the table
    }
    
    /**
     * This method adds a ZooKeeper to the List keepers.
     * @param k - ZooKeeper
     */
    public void add(ZooKeeper k){
        this.keepers.add(k); // adds ZooKeeper to the List.
    }
    
    /**
     * This method searches for and displays keepers by qualification, taking a
     * List and a boolean to determine if the keepers has to have
     * ALL qualifications from the list (true) or ANY qualifications from the 
     * list (false).
     * @param qualifications - List
     * @param all - boolean (true for ALL qualifications, false for ANY)
     * @return true if matches were found, false otherwise.
     */
    public boolean searchQualifications(List<Qualification> qualifications, boolean all){
        this.view.clearTable(); // clear the current table
        int counter = 0;        // set a counter to check if there were matches,
                                // to avoid empty tables with just header.
        for(ZooKeeper k : keepers){ //for each keeper
            if(all && CollectionUtils.containsAll(k.getQualifications(),
                    qualifications)){ // if keepers qualifications contain all
                                      // qualifications from list
                counter++;            // adds 1 to the counter
                this.view.addKeeperToTable(k); // add current keeper to the table
            } else if (!all && CollectionUtils.containsAny(k.getQualifications(),
                    qualifications)){ // if keepers qualifications contain any
                                      // qualification from list
                counter++;            // adds 1 to the counter
                this.view.addKeeperToTable(k); //adds to table
            }
        }
        if(counter!=0){ // if at least a match was found 
            this.view.displayTable(); // display table
            return true; // return true;
        }
        return false; // return false if nothing was found
    }
    
    /**
     * This method searches and displays keepers by gender, taking a String
     * as argument and returning true if a match was found.
     * @param gender - String
     * @return - true if found at least one (false otherwise)
     */
    public boolean searchGender(String gender){
        this.view.clearTable(); // clear table
        int counter = 0; // sets counter to avoid empty tables
        for(ZooKeeper k : keepers){ // for each keeper
            if(k.getGender().equalsIgnoreCase(gender)){ // if gender match
                this.view.addKeeperToTable(k); // add keeper to the table
                counter++; // add 1 to the counter
            } 
        }
        if(counter!=0){ // if something was found
            this.view.displayTable(); // display table
            return true; // return true
        }
        return false; // return false if nothing was found
    }
    
    /**
     * This method searches for and displays keepers by name, returning even
     * partial words
     * @param name - String to be searched for.
     * @return - true if something was found (and displayed)
     */
    public boolean searchName(String name){
        this.view.clearTable(); // clear exising table
        int counter = 0;        // sets counter to avoid empty table
        for(ZooKeeper k : keepers){ // for each keeper
            if(k.getName().toUpperCase()
                    .contains(name.toUpperCase())){ // if keeper's name contains
                                                    // the String
                counter++; // add 1 to counter
                this.view.addKeeperToTable(k); // add keeper to the table
            }
        }
        if(counter!=0){ // if something was found
            this.view.displayTable(); // display the table
            return true; // return true
        }
        return false; // return false if nothing was found
    }

    /**
     * This method search for number of animals under care, using lower and
     * upper boundaries. 
     * @param from - int (lower boundary), inclusive.
     * @param to - int (upper boundary), inclusive.
     * @return true if something was found, false otherwise
     */
    public boolean searchNumberOfAnimals(int from, int to) {
        this.view.clearTable(); //clear table
        int counter = 0; // sets counter to avoid empty table
        for(ZooKeeper k : keepers){ // for each keeper
            if(k.getAnimals().size() >= from &&
                    k.getAnimals().size() <= to){ // if size of list of animals
                                                  // is inside boundaries
                counter++; // add 1 to the counter
                this.view.addKeeperToTable(k); // add keeper to the table
            }
        }
        if(counter!=0){ // if something was found
            this.view.displayTable(); // display table
            return true; // return true
        }
        return false; // return false if nothing was found.
    }
    
    /**
     * This method searches and displays keepers by species under their care.
     * @param specie - String
     * @return true if something was found, false otherwise
     */
    public boolean searchSpecies(String specie){
        this.view.clearTable(); // clear the existing table
        List<ZooKeeper> uniques = new ArrayList<>(); // list to be filled with
                                                    // species with no repetition
        for(ZooKeeper k : keepers){ // for each keeper
            for(Animal a : k.getAnimals()){ // for each animal under care
                if(a.getSpecies().equalsIgnoreCase(specie) &&
                        !uniques.contains(k)){ // check if it matches with 
                                               // desired specie and if it was
                                               // already added to the list
                    uniques.add(k); // add to the list
                    break; // break out of loop
                }            
            }
        }
        if(!uniques.isEmpty()){ // if matcher were found
            for(ZooKeeper z : uniques){ // for each keeper in the list
                this.view.addKeeperToTable(z); // add to the table
            }
            this.view.displayTable(); // display table
            return true; // return true
        }
        return false; // return false if nothing was found
    }
    
}
