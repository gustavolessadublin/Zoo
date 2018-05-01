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
    private DataFactory dataFactory;
    
    public ZooData(){
//        this.animalFactory = new AnimalFactory();
//        this.keeperFactory = new KeeperFactory();
        this.animals = new ArrayList<>();
        this.zooKeepers = new ArrayList<>();
        this.dataFactory = new DataFactory(this);
        //this.animals = new ArrayList<>(animalFactory.getRandomAnimals(100));
      //  this.zooKeepers = new ArrayList<>(keeperFactory.getRandomKeepers(40));
        this.dataFactory.getRandomAnimals(100);
        this.zooKeepers.addAll(this.dataFactory.getRandomKeepers(40 - zooKeepers.size()));
        //TODO check the use of Animal or Abstract animal (getters not present in Animal interface)
        //TODO check if we need a Setup class, to keep this ZooData class clean
    }

    public List<Animal> getAnimals() { return animals; }
    public void setAnimals(List<Animal> animals) { this.animals = animals; }

    public List<ZooKeeper> getZooKeepers() { return zooKeepers; }
    public void setZooKeepers(List<ZooKeeper> zooKeepers) { this.zooKeepers = zooKeepers; }
}
