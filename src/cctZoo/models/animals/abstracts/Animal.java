package cctZoo.models.animals.abstracts;

import cctZoo.medication.Medication;
import cctZoo.models.Model;
import cctZoo.models.employees.zooKeeper.ZooKeeper;
import cctZoo.models.vaccine.Vaccine;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rbsrafa
 */
public abstract class Animal extends Model{
    private static int lastId;
    private String species,  name, gender, DOB, dateOfArrival;  
    private boolean offspring = false;
    private ZooKeeper keeper;
    private Offspring offsprings;
    private Medication medication = new Medication("Antibiotic");
    private List<Vaccine>vaccines = new ArrayList<>();    
    
    /**
     * Animal constructor.
     * @param species
     * @param name
     * @param gender 
     */
    public Animal(String species, String name, String gender) {
        super(++lastId);
        this.species = species;
        this.name = name;
        this.gender = gender;
    }
    
    /**
     * Animal Constructor
     * @param species
     * @param gender 
     */
    public Animal(String species, String gender) {
        super(++lastId);
        this.species = species;
        this.gender = gender;
    }
    
    /**
     * Animal constructor
     * @param species
     * @param gender
     * @param offspring1
     * @param offspring2 
     */
    public Animal(String species, String gender, Animal offspring1, Animal offspring2) {
        super(++lastId);
        this.species = species;
        this.gender = gender;
        offsprings = new Offspring(offspring1, offspring2);
    }
    
    /**
     * Animal constructor
     * @param species
     * @param gender
     * @param offspring1 
     */
    public Animal(String species, String gender, Animal offspring1) {
        super(++lastId);
        this.species = species;
        this.gender = gender;
        offsprings = new Offspring(offspring1);
    }
    
    /**
     * Animal constructor
     * @param species
     * @param gender
     * @param offspring 
     */
    public Animal(String species, String gender, boolean offspring) {
        super(++lastId);
        this.species = species;
        this.gender = gender;
        this.offspring = offspring;
    }

    /**
     * Animal constructor
     * @param species
     * @param name
     * @param gender
     * @param doa
     * @param DOB 
     */
    public Animal(String species, String name, String gender, String doa, String DOB){
        super(++lastId);
        this.species = species;       
        this.name = name;
        this.gender = gender;
        this.dateOfArrival = doa;
        this.DOB = DOB;    
    }
    
    /**
     * Animal constructor
     * @param species
     * @param name
     * @param gender
     * @param DOB 
     */
    public Animal(String species, String name, String gender, String DOB){
        super(++lastId);
        this.species = species;
        this.name = name;
        this.gender = gender;
        this.DOB = DOB;          
    }
    
    /**
     * This method displays a single animal on CLI.
     * @return 
     */
    @Override
    public String toString() {
        return "Animal\n------\n" +
               "ID: " + this.getId() + "\n" +
               "Species: " + this.getSpecies() + "\n" +
               "Name: " + this.getName() + "\n" +
               "Gender: " + this.getGender() + "\n" +
               "Date of Arrival: " + this.getDateOfArrival() +"\n" +
               "Date of Birth: " + this.getDOB() + "\n" +
               "Vaccine:" +this.vaccines.toString().getBytes()+ "\n" +
               "Medicated: " + this.isMedicated() + "\n" +
               "Offspring: " + this.getNumberOfOffspring() + "\n" +
               "Keeper: " + "ID - " + this.keeper.getId() + " " + this.keeper.getName() + "\n";     
    }
    
    /**
     * This method returns the number of animals as offspring
     * @return (int)
     */
    public int getNumberOfOffspring(){ 
        if(this.offsprings == null) return 0;
        else return this.offsprings.getNumberOfOffspring();
    }
    
    /**
     * This method returns the animal's type;
     * @return 
     */
    public List<String> getAnimalTypes(){
        List<String> types = new ArrayList<>();
        for(Class c: this.getClass().getInterfaces()){
            types.add(c.getSimpleName());
        }
        return types;
    }
    
    public boolean isMedicated(){ return this.medication.isMedicated(); }
    public void setMedicated(boolean b) {this.medication.setMedicated(b);}

    public void setMedicationName(String name){ this.medication.setName(name); }
    public String getMedicationName(){ return this.medication.getName(); }
    
    public static int getLastId() { return lastId; }

    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getDOB() { return DOB; }
    public void setDOB(String DOB) { this.DOB = DOB; }

    public String getDateOfArrival() { return dateOfArrival; }
    public void setDateOfArrival(String dateOfArrival) { this.dateOfArrival = dateOfArrival; } 

    public boolean isOffspring() { return offspring;}
    public void setOffspring(boolean offspring) { this.offspring = offspring;}

    public ZooKeeper getKeeper() { return keeper; }
    public void setKeeper(ZooKeeper keeper) { this.keeper = keeper; }

    public Offspring getOffsprings() { return offsprings; }
    public void setOffsprings(Offspring offsprings) { this.offsprings = offsprings; }
    
    public void setOffSpring(List<Animal> offspringList){
        this.offsprings.setOffspringList(offspringList);
    }

    public List<Vaccine> getVaccines() {return vaccines;}

    public void addVaccines(Vaccine vaccine) {this.vaccines.add(vaccine);}

    private class Offspring{
        
       private List<Animal> offspringList;
        
        public Offspring(Animal offspring1, Animal offspring2){
            this.offspringList = new ArrayList<>();
            offspringList.add(offspring1);
            offspringList.add(offspring2);
            
        }
        
        public Offspring(Animal offspring1){
            this.offspringList = new ArrayList<>();
            offspringList.add(offspring1);
            
        }

        public List<Animal> getOffspringList() { 
            return offspringList;
        }

        public void setOffspringList(List<Animal> offspringList) {
            this.offspringList = offspringList;
        }
        
        /**
         * This method returns the number of animals as offspring
         * @return (int) number of offspring 
         */
        public int getNumberOfOffspring(){
            return this.offspringList.size();
        }
 
    }
 
}
