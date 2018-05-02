/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.models.animals.abstracts;

import cctZoo.models.Model;
import cctZoo.models.animals.interfaces.Animal;
import cctZoo.models.employees.zooKeeper.ZooKeeper;

/**
 *
 * @author rbsrafa
 */
public abstract class AbstractAnimal extends Model implements Animal{
    private static int lastId;
    private String species, name, gender, DOB, dateOfArrival;
    private ZooKeeper keeper;
    private Offspring offspring;
    
    public AbstractAnimal(String species, String name, String gender) {
        super(++lastId);
        this.species = species;
        this.name = name;
        this.gender = gender;
    }
    
    public AbstractAnimal(String species, String gender) {
        super(++lastId);
        this.species = species;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Animal\n" +
               "------\n" +
               "Id: " + this.getId() + "\n" +
               "Species: " + this.species + "\n" +
               "Name: " + this.name + "\n" +
               "Gender: " + this.gender + "\n"+
               "Keeper: " + this.keeper.getName() + "\n";
        
    }

    public static int getLastId() { return lastId; }

    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getDOB() { return DOB; }
    public void setDOB(String DOB) { this.DOB = DOB; }

    public String getDateOfArrival() { return dateOfArrival; }
    public void setDateOfArrival(String dateOfArrival) { this.dateOfArrival = dateOfArrival; }

    public ZooKeeper getKeeper() { return keeper; }
    public void setKeeper(ZooKeeper keeper) { this.keeper = keeper; }

    public Offspring getOffspring() { return offspring; }
    public void setOffspring(Offspring offspring) { this.offspring = offspring; }
    
    
    
    
    private class Offspring{
       
        
        public Offspring(){
            
            
        }
 
    }
 
}
