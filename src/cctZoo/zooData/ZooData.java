/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.zooData;

import cctZoo.models.animals.abstracts.Animal;
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
    private DataFactory dataFactory;
    
    public ZooData(){
        this.animals = new ArrayList<>();
        this.zooKeepers = new ArrayList<>();
        this.dataFactory = new DataFactory(this);
        this.dataFactory.getRandomAnimals(100);
        this.zooKeepers.addAll(this.dataFactory.getRandomKeepers(40 - zooKeepers.size()));
        //TODO check if we need a Setup class, to keep this ZooData class clean
    }
    
    public List<Animal> getAnimals() { return animals; }
    public void setAnimals(List<Animal> animals) { this.animals = animals; }

    public List<ZooKeeper> getZooKeepers() { return zooKeepers; }
    public void setZooKeepers(List<ZooKeeper> zooKeepers) { this.zooKeepers = zooKeepers; }
}
