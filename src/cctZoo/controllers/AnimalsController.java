package cctZoo.controllers;

import cctZoo.models.animals.AquaticAvian;
import cctZoo.models.animals.AquaticMammal;
import cctZoo.models.animals.AquaticReptile;
import cctZoo.models.animals.AvianMammal;
import cctZoo.models.animals.GenericAquatic;
import cctZoo.models.animals.GenericAvian;
import cctZoo.models.animals.GenericInsect;
import cctZoo.models.animals.GenericMammal;
import cctZoo.models.animals.GenericReptile;
import cctZoo.models.animals.abstracts.Animal;
import cctZoo.models.animals.interfaces.Aquatic;
import cctZoo.models.animals.interfaces.Avian;
import cctZoo.models.animals.interfaces.Insect;
import cctZoo.models.animals.interfaces.Mammal;
import cctZoo.models.animals.interfaces.Reptile;
import cctZoo.models.employees.zooKeeper.ZooKeeper;
import cctZoo.views.AnimalView;
import cctZoo.zooData.DataFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller class for Animal.
 * @author rbsrafa
 */
public class AnimalsController {
    private List<Animal> animals;
    private AnimalView view;
    
    /**
     * Basic constructor accepts a list of animal and animal view.
     * @param animals
     * @param view 
     */
    public AnimalsController(List<Animal> animals, AnimalView view){
        this.animals = animals;
        this.view = view;
    }
    
    public Animal createAnimalByType(String species, String name, String gender, String DOB, String dateOfArrival, List<String> types){
        Animal a = null;
        if(types.size() == 1){
            if(types.get(0).equalsIgnoreCase("avian")){
                a = new GenericAvian(species, name, gender, DOB, dateOfArrival);
            }else if(types.get(0).equalsIgnoreCase("reptile")){
                a = new GenericReptile(species, name, gender, DOB, dateOfArrival);
            }else if(types.get(0).equalsIgnoreCase("mammal")){
                a = new GenericMammal(species, name, gender, DOB, dateOfArrival);
            }else if(types.get(0).equalsIgnoreCase("insect")){
                a = new GenericInsect(species, name, gender, DOB, dateOfArrival);
            }else if(types.get(0).equalsIgnoreCase("aquatic")){
                a = new GenericAquatic(species, name, gender, DOB, dateOfArrival);
            }
        }else if(types.size() == 2){
            String type1 = types.get(0);
            String type2 = types.get(1);
            
            if((type1.equalsIgnoreCase("Aquatic") && type2.equalsIgnoreCase("mammal")) ||
               (type1.equalsIgnoreCase("mammal") && type2.equalsIgnoreCase("aquatic"))    ){
                a = new AquaticMammal(species, name, gender, DOB, dateOfArrival);
            
            }else if((type1.equalsIgnoreCase("Aquatic") && type2.equalsIgnoreCase("avian")) ||
               (type1.equalsIgnoreCase("avian") && type2.equalsIgnoreCase("Aquatic"))    ){
                a = new AquaticAvian(species, name, gender, DOB, dateOfArrival);
           
            }else if((type1.equalsIgnoreCase("Aquatic") && type2.equalsIgnoreCase("reptile")) ||
               (type1.equalsIgnoreCase("reptile") && type2.equalsIgnoreCase("Aquatic"))    ){
                a = new AquaticReptile(species, name, gender, DOB, dateOfArrival);
            }else if((type1.equalsIgnoreCase("avian") && type2.equalsIgnoreCase("mammal")) ||
               (type1.equalsIgnoreCase("mammal") && type2.equalsIgnoreCase("avian"))    ){
                a = new AvianMammal(species, name, gender, DOB, dateOfArrival);
            }
        }
        return a;
    }
    
    /**
     * This method displays a list of animals on CLI.
     */
    public void display(){  
        for(Animal a: animals) this.view.addAnimalToTable(a);
        this.view.display();
  
    }
    
    /**
     * This method displays an animal argument to CLI
     * @param a 
     */
    public void display(Animal a){
        System.out.println(a);
    }
    
    /**
     * This method finds and returns an animal by id.
     * @param id
     * @return 
     */
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
  
    // did not understood this method //
    // TODO
    public List<String> getAnimalTypes(Animal a){
        List<String> types = new ArrayList<>();
        if (a instanceof Mammal){ types.add("Mammal");}
        if (a instanceof Reptile){ types.add("Reptile");}
        if (a instanceof Avian){ types.add("Avian");}
        if (a instanceof Aquatic){ types.add("Aquatic");}
        if (a instanceof Insect){ types.add("Insect");}
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
