/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.models.employees.zooKeeper;

import cctZoo.models.animals.interfaces.Animal;
import cctZoo.models.employees.Employee;
import java.util.ArrayList;

/**
 *
 * @author Gustavo Lessa
 */
public class ZooKeeper extends Employee{

    ArrayList<Qualification> qualifications;
    ArrayList<Animal> caredAnimals;
    
    public ZooKeeper(String gender){
        super(gender);
        qualifications = new ArrayList<>();
        caredAnimals = new ArrayList<>();
    }
    
    public ArrayList getQualifications(){
        return qualifications;
    }
    
    public void addQualification(Qualification q){
        if (qualifications.size()<3){
            qualifications.add(q);
        } else {
            System.out.println("Keeper has already 3 qualifications.");
        }
    }
    
    public void removeQualification(Qualification q){
        if (qualifications.contains(q)){
            qualifications.remove(q);
        } else {
            System.out.println("The keeper does not have the qualification.");
        }
    }
    
    public void addAnimal(Animal a){
        if(caredAnimals.size()<10){
            caredAnimals.add(a);
        } else {
            System.out.println("Keeper is already taking care of 10 animals");
        }
    }
    
    public ArrayList getAnimals(){
        return caredAnimals;
    }
    
    public void removeAnimal(Animal a){
        if(caredAnimals.contains(a)){
            caredAnimals.remove(a);
        } else {
            System.out.println("This keeper is not taking care of this animal.");
        }
    }
    
    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
