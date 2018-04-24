package cctZoo.controllers;

import cctZoo.models.Model;
import cctZoo.models.animals.interfaces.Animal;
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
    
    public void display(){
        for(Animal a: animals) this.view.display((Model) a);
    }
    
    public void add(Animal a){
        this.animals.add(a);
    }
    
    public List<Animal> getMammals(){
        List<Animal> mammals = new ArrayList<>();
        for(Animal a : animals) if(a instanceof Mammal) mammals.add(a);
        return mammals;
    }
    
    public void displayMammals(){
        List<Animal> mammals = this.getMammals();
        for(Animal a: mammals) this.view.display((Model) a);
    }
    
    public List<Animal> getReptiles(){
        List<Animal> reptiles = new ArrayList<>();
        for(Animal a : animals) if(a instanceof Reptile) reptiles.add(a);
        return reptiles;
    }
    
    public void displayReptiles(){
        List<Animal> reptiles = this.getReptiles();
        for(Animal a: reptiles) this.view.display((Model) a);
    }
    
    public List<Animal> getAvians(){
        List<Animal> avians = new ArrayList<>();
        for(Animal a : animals) if(a instanceof Avian) avians.add(a);
        return avians;
    }
    
    public void displayAvians(){
        List<Animal> avians = this.getAvians();
        for(Animal a: avians) this.view.display((Model) a);
    }
    
    public List<Animal> getInsects(){
        List<Animal> insects = new ArrayList<>();
        for(Animal a : animals) if(a instanceof Insect) insects.add(a);
        return insects;
    }
    
    public void displayInsects(){
        List<Animal> insects = this.getInsects();
        for(Animal a: insects) this.view.display((Model) a);
    }
    
    public List<Animal> getAquatics(){
        List<Animal> aquatics = new ArrayList<>();
        for(Animal a : animals) if(a instanceof Aquatic) aquatics.add(a);
        return aquatics;
    }
    
    public void displayAquatics(){
        List<Animal> aquatics = this.getAquatics();
        for(Animal a: aquatics) this.view.display((Model) a);
    }
    
}
