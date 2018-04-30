/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.zooData;

import cctZoo.models.animals.AnimalFactory;
import cctZoo.models.animals.interfaces.Animal;
import cctZoo.models.animals.interfaces.Aquatic;
import cctZoo.models.animals.interfaces.Avian;
import cctZoo.models.animals.interfaces.Insect;
import cctZoo.models.animals.interfaces.Mammal;
import cctZoo.models.animals.interfaces.Reptile;
import cctZoo.models.employees.zooKeeper.KeeperFactory;
import cctZoo.models.employees.zooKeeper.Qualification;
import cctZoo.models.employees.zooKeeper.ZooKeeper;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rbsrafa
 */
public class ZooData {
    private List<Animal> animals;
    private List<ZooKeeper> zooKeepers;
    private AnimalFactory animalFactory;
    private KeeperFactory keeperFactory;
    
    public ZooData(){
        this.animalFactory = new AnimalFactory();
        this.keeperFactory = new KeeperFactory();
        this.animals = new ArrayList<>(animalFactory.getRandomAnimals(100));
        this.zooKeepers = new ArrayList<>(keeperFactory.getRandomKeepers(40));
    }

    public List<Animal> getAnimals() { return animals; }
    public void setAnimals(List<Animal> animals) { this.animals = animals; }

    public List<ZooKeeper> getZooKeepers() { return zooKeepers; }
    public void setZooKeepers(List<ZooKeeper> zooKeepers) { this.zooKeepers = zooKeepers; }
    
    public void assignAnimal(Animal a){
        ArrayList<Qualification> animalTypes = new ArrayList<>();
        if (a instanceof Mammal){ animalTypes.add(Qualification.MAMMAL);}
        if (a instanceof Reptile){ animalTypes.add(Qualification.REPTILE);}
        if (a instanceof Avian){ animalTypes.add(Qualification.AVIAN);}
        if (a instanceof Aquatic){ animalTypes.add(Qualification.AQUATIC);}
        if (a instanceof Insect){ animalTypes.add(Qualification.INSECT);}
        
    }
    

}
