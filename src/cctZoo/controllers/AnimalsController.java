package cctZoo.controllers;

import cctZoo.models.animals.abstracts.Animal;
import cctZoo.models.animals.interfaces.Aquatic;
import cctZoo.models.animals.interfaces.Avian;
import cctZoo.models.animals.interfaces.Insect;
import cctZoo.models.animals.interfaces.Mammal;
import cctZoo.models.animals.interfaces.Reptile;
import cctZoo.models.employees.zooKeeper.ZooKeeper;
import cctZoo.models.vaccine.Vaccine;
import cctZoo.views.AnimalView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rbsrafa
 */
public class AnimalsController {
    private List<Animal> animals;
    private AnimalView view;
    AnimalView animal;
    ZooKeeper zooKeeper;
    
    public AnimalsController(List<Animal> animals, AnimalView view){
        this.animals = animals;
        this.view = view;
    }
    
    /**
     * This method displays a list of animals on CLI.
     */
    public void display(){  
        for(Animal a: animals) this.view.addAnimalToTable(a);
        this.view.display();
  
    }
    
    public void display(Animal a){
        System.out.println(a);
    }
    
    public Animal findAnimal(int id){
        Animal animal = null;
        for(Animal a: this.animals) if(a.getId() == id) animal = a;
        return animal;
    }
    
    /**
     * This method returns a list of the animal's types.
     * @return 
     */
    public List<String> getAnimalTypes(){
        return this.animals.get(0).getAnimalTypes();
    }
    
    public List<String> getAnimalTypes(Animal a){
        List<String> types = new ArrayList<>();
        if (a instanceof Mammal){ types.add("Mammal");}
        if (a instanceof Reptile){ types.add("Mammal");}
        if (a instanceof Avian){ types.add("Mammal");}
        if (a instanceof Aquatic){ types.add("Mammal");}
        if (a instanceof Insect){ types.add("Mammal");}
        return types;
    }
    

    
    /**
     * This method adds a new animal to the list of animals.
     * @param a 
     */
    public void add(Animal a){
       Animal an = null;
       ZooKeeper zooKeeper = null;
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
        for(Animal a: mammals) this.view.addAnimalToTable(a);
        this.view.display();
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
        for(Animal a: reptiles) this.view.addAnimalToTable(a);
        this.view.display();
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
        for(Animal a: avians) this.view.addAnimalToTable(a);
        this.view.display();
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
        for(Animal a: insects) this.view.addAnimalToTable(a);
        this.view.display();
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
        for(Animal a: aquatics) this.view.addAnimalToTable(a);
        this.view.display();
    }
    
}
