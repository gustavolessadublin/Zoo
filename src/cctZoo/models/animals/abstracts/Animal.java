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
    
    /**
     * This method returns if the animal is medicated.
     * @return 
     */
    public boolean isMedicated(){ return this.medication.isMedicated(); }
    
    /**
     * This method sets if the animal is medicated
     * @param b 
     */
    public void setMedicated(boolean b) {this.medication.setMedicated(b);}

    /**
     * This method sets the medication name
     * @param name 
     */
    public void setMedicationName(String name){ this.medication.setName(name); }
    
    /**
     * This method gets the medication name.
     * @return 
     */
    public String getMedicationName(){ return this.medication.getName(); }
    
    /**
     * This method gets the last animal id.
     * @return 
     */
    public static int getLastId() { return lastId; }

    /**
     * This method gets the animal species.
     * @return 
     */
    public String getSpecies() { return species; }
    
    /**
     * This method sets the animal species.
     * @param species 
     */
    public void setSpecies(String species) { this.species = species; }

    /**
     * This method gets the animal name.
     * @return 
     */
    public String getName() { return name; }
    
    /**
     * This method sets the animal name.
     * @param name 
     */
    public void setName(String name) { this.name = name; }

    /**
     * This method gets the animal gender.
     * @return 
     */
    public String getGender() { return gender; }
    
    /**
     * This method sets the animal gender.
     * @param gender 
     */
    public void setGender(String gender) { this.gender = gender; }

    /**
     * This method gets the animal date of birth.
     * @return 
     */
    public String getDOB() { return DOB; }
    
    /**
     * This method sets the animal date of birth.
     * @param DOB 
     */
    public void setDOB(String DOB) { this.DOB = DOB; }

    /**
     * This method gets the animal date of arrival.
     * @return 
     */
    public String getDateOfArrival() { return dateOfArrival; }
    
    /**
     * This method sets the animal date of arrival.
     * @param dateOfArrival 
     */
    public void setDateOfArrival(String dateOfArrival) { this.dateOfArrival = dateOfArrival; } 

    /**
     * This method returns if the animal has offspring.
     * @return 
     */
    public boolean isOffspring() { return offspring;}
    
    /**
     * This method sets if the animal has offspring.
     * @param offspring 
     */
    public void setOffspring(boolean offspring) { this.offspring = offspring;}

    /**
     * This method gets the animal keeper.
     * @return 
     */
    public ZooKeeper getKeeper() { return keeper; }
    
    /**
     * This method sets the animal keeper.
     * @param keeper 
     */
    public void setKeeper(ZooKeeper keeper) { this.keeper = keeper; }

    /**
     * This method gets the animal offspring.
     * @return 
     */
    public Offspring getOffsprings() { return offsprings; }
    
    /**
     * this method sets the animal offspring.
     * @param offsprings 
     */
    public void setOffsprings(Offspring offsprings) { this.offsprings = offsprings; }
    
    /**
     * This method sets the animal offspring list.
     * @param offspringList 
     */
    public void setOffSpring(List<Animal> offspringList){
        this.offsprings.setOffspringList(offspringList);
    }

    /**
     * This method gets the animal vaccines.
     * @return 
     */
    public List<Vaccine> getVaccines() {return vaccines;}

    /**
     * This method adds the animal vaccines.
     * @param vaccine 
     */
    public void addVaccines(Vaccine vaccine) {this.vaccines.add(vaccine);}

    /**
     * @author lucinal1
     */
    private class Offspring{  
        private List<Animal> offspringList;
        
        /**
         * Offspring constructor that accepts two animal offsprings.
         * @param offspring1
         * @param offspring2 
         */
        public Offspring(Animal offspring1, Animal offspring2){
            this.offspringList = new ArrayList<>();
            offspringList.add(offspring1);
            offspringList.add(offspring2);

        }

        /**
         * Animal constructor that accepts one animal offspring.
         * @param offspring1 
         */
        public Offspring(Animal offspring1){
            this.offspringList = new ArrayList<>();
            offspringList.add(offspring1);

        }

        /**
         * This method returns the offspring list.
         * @return 
         */
        public List<Animal> getOffspringList() { 
            return offspringList;
        }

        /**
         * This method sets the offspring list.
         * @param offspringList 
         */
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
