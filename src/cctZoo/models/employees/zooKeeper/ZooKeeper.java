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
 *
 * @author Gustavo Lessa
 */
public class ZooKeeper extends Employee{

    List<Qualification> qualifications;
    List<Animal> caredAnimals;
    
    public ZooKeeper(String gender){
        super(gender);
        qualifications = new ArrayList<>();
        caredAnimals = new ArrayList<>();
    }
    
    public ZooKeeper(String gender, String name, List<Qualification> qualifications){
        super(gender, name);
        this.qualifications = qualifications;
        caredAnimals = new ArrayList<>();
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
     * @param Qualification (Enum) - representing the desired qualification to add.
     */
    public void addQualification(Qualification q){
        if (qualifications.size()<3){
            qualifications.add(q);
        } else {
            System.out.println("Keeper has already 3 qualifications.");
        }
    }
    
    /**
     * This method removes a qualification after checking if it was in the
     * keeper's records.
     * @param Qualification (Enum) - representing the qualification to be removed.
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
     * if the 10 animals limit was reached.
     * @param Animal - the animal to be added to keeper's cared animals list.
     */
    public void addAnimal(Animal a){
        if(caredAnimals.size()<10){
            caredAnimals.add(((Animal)a));
        } else {
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
     * @param Animal - the animal object to be removed from the list.
     */
    public void removeAnimal(Animal a){
        if(caredAnimals.contains(a)){
            caredAnimals.remove(a);
        } else {
            System.out.println("This keeper is not taking care of this animal.");
        }
    }
    
    /**
     * This method returns a String listing the ID of all animals under care of 
     * the keeper.
     * @return String - concatenated animal IDs.
     */
    public String caredAnimals(){
        String ans = "";
        for(Animal a : caredAnimals){
           ans = ans.concat(((Animal)a).getId()+ " ");
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
