/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.models.employees.zooKeeper;

import cctZoo.models.animals.abstracts.Animal;
import cctZoo.models.employees.Employee;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the zoo keepers. 
 * @author Gustavo Lessa
 */
public class ZooKeeper extends Employee{

    private List<Qualification> qualifications; // a list of qualifications
    private List<Animal> caredAnimals; // a list of cared animals
    private static int limitOfQualifications = 3; // limit of qualifications
    private static int limitOfAnimals = 10; // limit of animals
    
    /**
     * This constructor creates a ZooKeeper with no qualifications
     * @param gender 
     */
    public ZooKeeper(String gender){
        super(gender);
        qualifications = new ArrayList<>();
        caredAnimals = new ArrayList<>();
    }
    
    /**
     * This constructor creates a keeper already with desired qualifications.
     * @param gender
     * @param name
     * @param qualifications 
     */
    public ZooKeeper(String gender, String name, List<Qualification> qualifications){
        super(gender, name);
        this.qualifications = qualifications;
        caredAnimals = new ArrayList<>();
    }
    
    /**
     * This method retrieves the limit of qualifications a keeper can have.
     * @return int - limit
     */
    public static int getLimitOfQualifications(){
        return limitOfQualifications;
    }
    
    /**
     * This method sets the limit of qualifications a keeper can have.
     * @param limit (int) - limit to be set
     */
    public static void setLimitOfQualifications(int limit){
        limitOfQualifications = limit;
    }
    
    /**
     * This method retrieves the limit of animals a keeper can take care of at
     * the same time.
     * @return int - limit
     */
    public static int getLimitOfAnimals(){
        return limitOfAnimals;
    }
    
    /**
     * This method sets the limit of animals a keeper can have.
     * @param limit (int) - limit to be set
     */
    public static void setLimitOfAnimals(int limit){
        limitOfAnimals = limit;
    }
    
    /**
     * This method returns the qualifications of a zoo keeper, stored in an ArrayList.
     * @return ArrayList of Enums representing the keeper's qualifications.
     */
    public List getQualifications(){
        return qualifications;
    }
    
    /**
     * This method verifies adds a qualification to the keeper, after verifying
     * if the limit of 3 qualifications was already reached.
     * @param q - Qualification (Enum) of the qualification to add.
     */
    public void addQualification(Qualification q){
        if (qualifications.size()<limitOfQualifications){
            qualifications.add(q);
        } else {
            System.out.println("Keeper has already the maximum number of"
                    + " qualifications.");
        }
    }
    
    /**
     * This method removes a qualification after checking if it was in the
     * keeper's records.
     * @param q - Qualification (Enum) to be removed.
     */
    public void removeQualification(Qualification q){
        if (qualifications.contains(q)){
            qualifications.remove(q);
        } else {
            System.out.println("The keeper does not have the qualification.");
        }
    }
    
    /**
     * This method adds an animal to the keeper's cared animals list, after checking
     * if the limit of animals was reached.
     * @param a (Animal) the animal to be added to keeper's cared animals list.
     */
    public void addAnimal(Animal a){
        if(caredAnimals.size()<limitOfAnimals){ // if limit wasn't reached
            caredAnimals.add(a); // add animal
        } else { // if limit was reached, display message
            System.out.println("Keeper is already taking care of 10 animals");
        }
    }
    
    /**
     * This method returns an ArrayList of the cared animals.
     * @return ArrayList of animals, representing the cared animals.
     */
    public List<Animal> getAnimals(){
        return caredAnimals;
    }
    
    /**
     * This method removes an animal from the cared animals list after checking
     * if it was there in the first place.
     * @param a (Animal) the animal object to be removed from the list.
     */
    public void removeAnimal(Animal a){
        if(caredAnimals.contains(a)){ // if animal exists on thel ist 
            caredAnimals.remove(a); // remove it
        } else { // if the animal isn't on the list, display message
            System.out.println("This keeper is not taking care of this animal.");
        }
    }
    
    /**
     * This method returns a String listing the ID of all animals under care of 
     * the keeper or a message in case there are no animals assigned.
     * @return String - concatenated animal IDs.
     */
    public String caredAnimals(){
        String ans = "";
        // concat the IDs using comma as separator until the last one.
        for(int a = 0; a < caredAnimals.size(); a++){
            ans = ans.concat(Integer.toString(caredAnimals.get(a).getId()));
            if(a<(caredAnimals.size()-1)){ // if it is the last don' print comma
                ans = ans.concat(", ");
            }
        }
        if(ans.isEmpty()){
            ans = "no animals assigned.";
        }
        return ans;
    }
    
    /**
     * This method overrides the toString() to display the keeper's info.
     * @return String - representing the keeper's info.
     */
    @Override
    public String toString() {
        return "Keeper\n" +
       "------\n" +
       "Id: " + this.getId() + "\n" +
       "Name: " + this.getName() + "\n" +
       "Gender: " + this.getGender() + "\n" +
       "Qualifications: "+ this.getQualifications() + "\n" +
       "Animals: "+ caredAnimals()+"\n";
    }
}
