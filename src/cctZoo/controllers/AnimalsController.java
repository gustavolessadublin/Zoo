package cctZoo.controllers;

import cctZoo.models.Model;
import cctZoo.models.animals.abstracts.Animal;
import cctZoo.models.animals.interfaces.Aquatic;
import cctZoo.models.animals.interfaces.Avian;
import cctZoo.models.animals.interfaces.Insect;
import cctZoo.models.animals.interfaces.Mammal;
import cctZoo.models.animals.interfaces.Reptile;
import cctZoo.views.TableList;
import cctZoo.views.View;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author therealfarfetchd
 * 
 * TableList tl = new TableList(3, "ID", "String 1", "String 2").sortBy(0).withUnicode(true);
// from a list
yourListOrWhatever.forEach(element -> tl.addRow(element.getID(), element.getS1(), element.getS2()));
// or manually
tl.addRow("Hi", "I am", "Bob");

tl.print();
 */

/**
 *
 * @author rbsrafa
 */
public class AnimalsController {
    private List<Animal> animals;
    private View view;
    TableList table;
    
    public AnimalsController(List<Animal> animals, View view){
        this.animals = animals;
        this.view = view;
        table = new TableList(5, "ID", "Name", "Gender", "Offspring", "ZooKeeper").sortBy(0).withUnicode(true);
    }
    
    public void printTitle(){
        System.out.println("ID   Species     Name    Gender   Offspring   Zoo Keeper");
        System.out.println("--   -------     ----    ------   ---------   ----------");
    }
    
    /**
     * This method displays a list of animals on CLI.
     */
    public void display(){        
        for(Animal a: animals){
            String[] row = {Integer.toString(a.getId()), a.getName(), a.getGender(), Boolean.toString(a.isOffspring()), a.getKeeper().getName()};
            table.addRow(row);
        }
        table.sortBy(0);
        table.print();        
    }
    
    /**
     * This method adds a new animal to the list of animals.
     * @param a 
     */
    public void add(Animal a){
        this.animals.add(a);
    }
    
    /**
     * This method returns a list of mammals from the animals list.
     * @return 
     */
    public List<Animal> getMammals(){
        List<Animal> mammals = new ArrayList<>();
        for(Animal a : animals) if(a instanceof Mammal) mammals.add(a);
        return mammals;
    }
    
    /**
     * This method displays all the mammals from the animals list.
     */
    public void displayMammals(){
        List<Animal> mammals = this.getMammals();
        for(Animal a: mammals) {
            String[] row = {Integer.toString(a.getId()), a.getName(), a.getGender(), Boolean.toString(a.isOffspring()), a.getKeeper().getName()};
            table.addRow(row);
        }
        table.sortBy(0);
        table.print();
    }
    
    /**
     * This method returns a list of all reptiles from the animals list.
     * @return 
     */
    public List<Animal> getReptiles(){
        List<Animal> reptiles = new ArrayList<>();
        for(Animal a : animals) if(a instanceof Reptile) reptiles.add(a);
        return reptiles;
    }
    
    /**
     * This method display all the reptiles from the animals list.
     */
    public void displayReptiles(){
        List<Animal> reptiles = this.getReptiles();
        for(Animal a: reptiles) {
            String[] row = {Integer.toString(a.getId()), a.getName(), a.getGender(), Boolean.toString(a.isOffspring()), a.getKeeper().getName()};
            table.addRow(row);
        }
        table.sortBy(0);
        table.print();
    }
    
    /**
     * This method returns all the avians from the animals list.
     * @return 
     */
    public List<Animal> getAvians(){
        List<Animal> avians = new ArrayList<>();
        for(Animal a : animals) if(a instanceof Avian) avians.add(a);
        return avians;
    }
    
    /**
     * This method displays all the avians from the animals list.
     */
    public void displayAvians(){
        List<Animal> avians = this.getAvians();
        this.printTitle();
        for(Animal a: avians) {
            String[] row = {Integer.toString(a.getId()), a.getName(), a.getGender(), Boolean.toString(a.isOffspring()), a.getKeeper().getName()};
            table.addRow(row);
        }
        table.sortBy(0);
        table.print();
    }
    
    /**
     * This method returns all the insects from the animals list.
     * @return 
     */
    public List<Animal> getInsects(){
        List<Animal> insects = new ArrayList<>();
        for(Animal a : animals) if(a instanceof Insect) insects.add(a);
        return insects;
    }
    
    /**
     * This method displays all the insects from the animals list.
     */
    public void displayInsects(){
        List<Animal> insects = this.getInsects();
        this.printTitle();
        for(Animal a: insects) {
            String[] row = {Integer.toString(a.getId()), a.getName(), a.getGender(), Boolean.toString(a.isOffspring()), a.getKeeper().getName()};
            table.addRow(row);
        }
        table.sortBy(0);
        table.print();
    }
    
    /**
     * This method returns all the aquatics from the animals list.
     * @return 
     */
    public List<Animal> getAquatics(){
        List<Animal> aquatics = new ArrayList<>();
        for(Animal a : animals) if(a instanceof Aquatic) aquatics.add(a);
        return aquatics;
    }
    
    /**
     * This method displays all the aquatics from the animals list.
     */
    public void displayAquatics(){
        List<Animal> aquatics = this.getAquatics();
        this.printTitle();
        for(Animal a: aquatics) {
            String[] row = {Integer.toString(a.getId()), a.getName(), a.getGender(), Boolean.toString(a.isOffspring()), a.getKeeper().getName()};
            table.addRow(row);
        }
        table.sortBy(0);
        table.print();
    }
    
}
