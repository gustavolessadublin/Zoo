package cctZoo.zooData;

import cctZoo.models.animals.abstracts.Animal;

import cctZoo.models.employees.zooKeeper.ZooKeeper;
import cctZoo.models.vaccine.Vaccine;
import java.util.ArrayList;
import java.util.List;

/**
 * ZooData class keeps all the info about the zoo.
 * @author rbsrafa
 */
public class ZooData {
    private List<Animal> animals;
    private List<ZooKeeper> zooKeepers;
    private List<Vaccine> vaccines;
    private DataFactory dataFactory;
    
    /**
     * Default ZooData constructor.
     */
    public ZooData(){
        this.animals = new ArrayList<>();
        this.zooKeepers = new ArrayList<>();
        this.dataFactory = new DataFactory(this);
        this.vaccines = dataFactory.generateVaccines();
        this.dataFactory.getRandomAnimals(100);
        this.zooKeepers.addAll(this.dataFactory.getRandomKeepers(40 - zooKeepers.size()));
    }
    
    /**
     * This method returns the zoo animal list.
     * @return 
     */
    public List<Animal> getAnimals() { return animals; }
    
    /**
     * This method sets the zoo animal list.
     * @param animals 
     */
    public void setAnimals(List<Animal> animals) { this.animals = animals; }

    /**
     * This method returns the zoo keeper list.
     * @return 
     */
    public List<ZooKeeper> getZooKeepers() { return zooKeepers; }
    
    /**
     * This method sets the zoo keeper list.
     * @param zooKeepers 
     */
    public void setZooKeepers(List<ZooKeeper> zooKeepers) { this.zooKeepers = zooKeepers; }
    
    /**
     * This method gets a list of vaccines.
     * @return 
     */
    public List<Vaccine> getVaccines() {return vaccines;}
    
    /**
     * This method sets a list of vaccines.
     * @param vaccine 
     */
    public void setVaccines(List<Vaccine> vaccine) {this.vaccines = vaccine;}

}
