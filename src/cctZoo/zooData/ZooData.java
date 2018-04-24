/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.zooData;

import cctZoo.models.animals.AnimalFactory;
import cctZoo.models.animals.interfaces.Animal;
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
    
    public ZooData(){
        this.animalFactory = new AnimalFactory();
        this.animals = new ArrayList<>(animalFactory.getRandomAnimals(100));
        this.zooKeepers = new ArrayList<>();
    }

    public List<Animal> getAnimals() { return animals; }
    public void setAnimals(List<Animal> animals) { this.animals = animals; }

    public List<ZooKeeper> getZooKeepers() { return zooKeepers; }
    public void setZooKeepers(List<ZooKeeper> zooKeepers) { this.zooKeepers = zooKeepers; }

}
