package cctZoo.controllers;

import cctZoo.models.Model;
import cctZoo.models.animals.abstracts.Animal;
import cctZoo.models.animals.interfaces.Aquatic;
import cctZoo.models.animals.interfaces.Avian;
import cctZoo.models.animals.interfaces.Insect;
import cctZoo.models.animals.interfaces.Mammal;
import cctZoo.models.animals.interfaces.Reptile;
import cctZoo.views.View;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rbsrafa
 */
public class AnimalsController {
    private List<Animal> animals;
    private View view;
    
    public AnimalsController(List<Animal> animals, View view){
        this.animals = animals;
        this.view = view;
    }
    
    public void printTitle(){
        System.out.println("ID   Species     Name    Gender   Offspring   Zoo Keeper");
        System.out.println("--   -------     ----    ------   ---------   ----------");
    }
    
    /**
     * This method displays a list of animals on CLI.
     */
    public void display(){
        this.printTitle();
        for(Animal a: animals) this.view.display((Model) a);
        System.out.println("");
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
        this.printTitle();
        for(Animal a: mammals) this.view.display((Model) a);
        System.out.println("");
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
        this.printTitle();
        for(Animal a: reptiles) this.view.display((Model) a);
        System.out.println("");
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
        for(Animal a: avians) this.view.display((Model) a);
        System.out.println("");
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
        for(Animal a: insects) this.view.display((Model) a);
        System.out.println("");
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
        for(Animal a: aquatics) this.view.display((Model) a);
        System.out.println("");
    }
    
}
