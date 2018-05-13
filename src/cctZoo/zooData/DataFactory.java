package cctZoo.zooData;

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
import cctZoo.models.employees.zooKeeper.Qualification;
import cctZoo.models.employees.zooKeeper.ZooKeeper;
import cctZoo.models.vaccine.Vaccine;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import org.apache.commons.collections4.CollectionUtils;

/**
 * This class is responsible for generating data.
 * @author rbsrafa
 * @author Gustavo Lessa
 * @author lucival1
 * @author fernandotenorio
 */
public class DataFactory {
    FileRW rw; 
    ZooData zooData; //object that holds access to the 
    DateFormat dateFormat;
    
    /**
     * Initiaclize the DataFactory class.
     * @param zooData (ZooData)
     */
    public DataFactory(ZooData zooData){
        rw = new FileRW();
        this.zooData = zooData;
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    }
    
    /**
     * This method receive a number n and then generates a n number of Animal
     * Objects.
     * @param amount 
     */
    public void getRandomAnimals(int amount){
        for(int i = 0; i < amount; i++){
            zooData.getAnimals().add(this.defineRandomAnimal());
        }
    }
      
    /**
     * This method generates a random date.
     * @return 
     * Returns a random date in the format dd/mm/yyyy
     */
    public Date getRandomDate(){
        Random rand = new Random();
        //DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        GregorianCalendar gc = new GregorianCalendar();
        gc.add(GregorianCalendar.MONTH, -rand.nextInt(12));
        gc.add(GregorianCalendar.DAY_OF_MONTH, -rand.nextInt(20));
        gc.add(GregorianCalendar.YEAR, -rand.nextInt(4));
        Date date = gc.getTime();
        //String formatedDate = dateFormat.format(date);
        return date;
    }

    /**
     * This method defines some of most important animal characteristics
     * (species, gender and Offspring)before generating the Animal object.
     * @return 
     * A Animal object.
     */
    private Animal defineRandomAnimal(){
        Animal a = null;
        Random rand = new Random();
        String[] genders = {"Male", "Female"};
        String[] species = {"Dolphin", "Whale", "Crocodile", "Penguin", "Dragonfly",
                            "Beetle", "Tiger", "Zebra", "Lion", "Snake", "Komodo Dragon",
                            "Seagull", "Owl", "Bat", "Shark", "Octopus", "Ant"};
                
        String specie = species[rand.nextInt(species.length)];//select an animal species
        String gender = genders[rand.nextInt(genders.length)];//select an animal gender
        int offsprings = 0;
        if(gender.equals("Female")){
            offsprings = hasOffsprings();//determine how many offsprings female will have
            for(int i=0; i<offsprings; i++){//when offsprings > 0, creates offsprings(max 2) 
                a = this.generateAnimal(specie, gender, -1);//create Offspring Animals
                zooData.getAnimals().add(a);//Add the new Offspring in the Animal list
            }
            return this.generateAnimal(specie, gender, offsprings);//creates the female with respective Offspring number
        }
        a = this.generateAnimal(specie, gender, 0);//creates the male Animals
        return a;
    }
    
    /**
     * This method decides how many Offsprings the Animal will have.
     * @return 
     * The return is a int between 0-2 that represents the number of Offspring.
     */
    public int hasOffsprings(){
        Random rand = new Random();
        return rand.nextInt(3);
    }
        
    /**
     * Generate a Animal after receive the defining parameters, 
     * after creating the animal also sets the animal name, DOB, date of arrival,
     * keeper, vaccines and medication variables.
     * @param specie (String)
     * @param gender(String)
     * @param offsprings (int)
     * @return 
     * Returns an Animal Object
     */
    public Animal generateAnimal(String specie, String gender, int offsprings){
        Animal a = null;
        
        switch (specie) {//verify the Animal species and select the apropriate case
            case "Dolphin":
            case "Whale":
                switch(offsprings){//verify the Offspring number and call apropriate Animal constructor
                    case(2): a = new AquaticMammal(specie, gender,
                            zooData.getAnimals().get(zooData.getAnimals().size()-1),
                            zooData.getAnimals().get(zooData.getAnimals().size()-2));
                    break;
                    case(1): a = new AquaticMammal(specie, gender,
                            zooData.getAnimals().get(zooData.getAnimals().size()-1));
                    break;
                    case(0): a = new AquaticMammal(specie, gender);
                    break;
                    default: a = new AquaticMammal(specie, gender, true);
                    break;
                }   
                break;
            case "Crocodile":
                switch(offsprings){//follows the same idea from previous comment
                    case(2): a = new AquaticReptile(specie, gender,
                            zooData.getAnimals().get(zooData.getAnimals().size()-1),
                            zooData.getAnimals().get(zooData.getAnimals().size()-2));
                    break;
                    case(1): a = new AquaticReptile(specie, gender,
                            zooData.getAnimals().get(zooData.getAnimals().size()-1));
                    break;
                    case(0): a = new AquaticReptile(specie, gender);
                    break;
                    default: a = new AquaticReptile(specie, gender, true);
                    break;
                }
                break;
            case "Penguin":
                switch(offsprings){//follows the same idea from previous comment
                    case(2): a = new AquaticAvian(specie, gender,
                            zooData.getAnimals().get(zooData.getAnimals().size()-1),
                            zooData.getAnimals().get(zooData.getAnimals().size()-2));
                    break;
                    case(1): a = new AquaticAvian(specie, gender,
                            zooData.getAnimals().get(zooData.getAnimals().size()-1));
                    break;
                    case(0): a = new AquaticAvian(specie, gender);
                    break;
                    default: a = new AquaticAvian(specie, gender, true);
                    break;
                }
                
                break;
            case "Tiger":
            case "Zebra":
            case "Lion":
                switch(offsprings){//follows the same idea from previous comment
                    case(2): a = new GenericMammal(specie, gender,
                            zooData.getAnimals().get(zooData.getAnimals().size()-1),
                            zooData.getAnimals().get(zooData.getAnimals().size()-2));
                    break;
                    case(1): a = new GenericMammal(specie, gender,
                            zooData.getAnimals().get(zooData.getAnimals().size()-1));
                    break;
                    case(0): a = new GenericMammal(specie, gender);
                    break;
                    default: a = new GenericMammal(specie, gender, true);
                    break;
                }
                break;
            case "Snake":
            case "Komodo Dragon":
                switch(offsprings){//follows the same idea from previous comment
                    case(2): a = new GenericReptile(specie, gender,
                            zooData.getAnimals().get(zooData.getAnimals().size()-1),
                            zooData.getAnimals().get(zooData.getAnimals().size()-2));
                    break;
                    case(1): a = new GenericReptile(specie, gender,
                            zooData.getAnimals().get(zooData.getAnimals().size()-1));
                    break;
                    case(0): a = new GenericReptile(specie, gender);
                    break;
                    default: a = new GenericReptile(specie, gender, true);
                    break;
                }
                break;
            case "Seagull":
            case "Owl":
                switch(offsprings){//follows the same idea from previous comment
                    case(2): a = new GenericAvian(specie, gender,
                            zooData.getAnimals().get(zooData.getAnimals().size()-1),
                            zooData.getAnimals().get(zooData.getAnimals().size()-2));
                            ((Avian)a).setFly(true);
                    break;
                    case(1): a = new GenericAvian(specie, gender,
                            zooData.getAnimals().get(zooData.getAnimals().size()-1));
                            ((Avian)a).setFly(true);
                    break;
                    case(0): a = new GenericAvian(specie, gender);
                            ((Avian)a).setFly(true);
                    break;
                    default: a = new GenericAvian(specie, gender, true);
                            ((Avian)a).setFly(true);
                    break;
                }
                
                break;
            case "Bat":
                switch(offsprings){//follows the same idea from previous comment
                    case(2): a = new AvianMammal(specie, gender,
                            zooData.getAnimals().get(zooData.getAnimals().size()-1),
                            zooData.getAnimals().get(zooData.getAnimals().size()-2));
                            ((Avian)a).setFly(true);
                    break;
                    case(1): a = new AvianMammal(specie, gender,
                            zooData.getAnimals().get(zooData.getAnimals().size()-1));
                            ((Avian)a).setFly(true);
                    break;
                    case(0): a = new AvianMammal(specie, gender);
                            ((Avian)a).setFly(true);
                    break;
                    default: a = new AvianMammal(specie, gender, true);
                            ((Avian)a).setFly(true);
                    break;
                }
                ((Avian)a).setFly(true);
                break;
            case "Shark":
            case "Octopus":
                switch(offsprings){//follows the same idea from previous comment
                    case(2): a = new GenericAquatic(specie, gender,
                            zooData.getAnimals().get(zooData.getAnimals().size()-1),
                            zooData.getAnimals().get(zooData.getAnimals().size()-2));
                    break;
                    case(1): a = new GenericAquatic(specie, gender,
                            zooData.getAnimals().get(zooData.getAnimals().size()-1));
                    break;
                    case(0): a = new GenericAquatic(specie, gender);
                    break;
                    default: a = new GenericAquatic(specie, gender, true);
                    break;
                }
                break;
            case "Dragonfly":
            case "Beetle":
            case "Ant":
                a = new GenericInsect(specie, gender);
                break;
            default:
                break;
        }
              
        a.setName(rw.getRandomName(a.getGender()));//sets Animal name based in its gender
        this.assingDatesToAnimal(a);
        this.assignKeeper(a);//assigns animal to the keeper
        this.generateRandomlyVaccines(a);//creates the vaccines
        this.setMedication(a);//set Animal medication
        this.assingDatesToAnimal(a);
        
        return a;
    }
    
    /**
     * This method interacts with an user to set the medication of an animal.
     * @param a 
     */
    public void setMedication(Animal a){
        Random rand = new Random();
        boolean medicated = false;
        if(rand.nextInt() % 2 == 0) medicated = true;
        a.setMedicated(medicated);
    }
    
    /**
     * This method assigns random date of birth and date of arrival to animals.
     * @param a 
     */
    public void assingDatesToAnimal(Animal a){
        Date DOB = this.getRandomDate();
        Date dateOfArrival = this.getRandomDate();
        
        if(DOB.compareTo(dateOfArrival) > 0) DOB = dateOfArrival;
        
        a.setDOB(this.dateFormat.format(DOB));
        a.setDateOfArrival(this.dateFormat.format(dateOfArrival));
    }
    
    /**
     * This method assigns the first available and compatible keeper to an
     * Animal a.
     * @param a (Animal) animal to be assigned.
     */
    public void assignKeeper(Animal a){  
        // create an ArrayList of types.
        ArrayList<Qualification> animalTypes = new ArrayList<>();
        
        // add the animal type by checking if the class is an instance of
        // the interfaces
        if (a instanceof Mammal){ animalTypes.add(Qualification.MAMMAL);}
        if (a instanceof Reptile){ animalTypes.add(Qualification.REPTILE);}
        if (a instanceof Avian){ animalTypes.add(Qualification.AVIAN);}
        if (a instanceof Aquatic){ animalTypes.add(Qualification.AQUATIC);}
        if (a instanceof Insect){ animalTypes.add(Qualification.INSECT);}

        boolean assigned = false; // true if it was assigned, false if wasn't
        while(!assigned){
            for(ZooKeeper z : zooData.getZooKeepers()){ // for each keeper
                // if keeper is compatible AND has less than the limit of animals
                if (CollectionUtils.containsAll(z.getQualifications(),animalTypes)
                        && (z.getAnimals()==null || z.getAnimals().size()<10)){
                    z.addAnimal(a); //add animal to keeper
                    a.setKeeper(z); // add keeper to animal
                    assigned = true; // set assigned true
                    break;
                } 
            }            
            // if none was found, generate randomly
            if(a.getKeeper()==null){
                zooData.getZooKeepers().add(this.generateRandomKeeper(animalTypes));
            }
        }
    }
    
    /**
     * This method generates any number of random keepers and returns them as
     * a List.
     * @param amount (int) - number of keepers to be generated.
     * @return List of keepers generated.
     */
    public List<ZooKeeper> getRandomKeepers (int amount){
        List<ZooKeeper> keepers = new ArrayList<>();
        for(int i = 0; i < amount; i++){
            keepers.add(this.generateRandomKeeper());
        }
        return keepers;
    }
    
    /**
     * This method retrieves a random name calling methods that retrieve the
     * information from txt files.
     * @param gender (String)
     * @return String - generated name.
     */
    public String getRandomName(String gender){
        return rw.getRandomName(gender).concat(" ").concat(rw.getRandomSurname());
    }
    
    /**
     * This method generates a random keeper (including random qualifications). 
     * @return ZooKeeper
     */
    public ZooKeeper generateRandomKeeper(){
        String gender = randomGender();
        String name = getRandomName(gender);        
        return new ZooKeeper(gender, name, randomQualifications());
    }
    
    /**
     * This method generates a random keeper, with specific qualifications.
     * @param qualifications
     * @return ZooKeeper
     */
    public ZooKeeper generateRandomKeeper(ArrayList<Qualification> qualifications){
        String gender = randomGender(); // get random gender
        String name = getRandomName(gender);// get random name
        return new ZooKeeper(gender, name, qualifications); // create object
    }
    
    /**
     * Method to Randomly generate Gender
     * @return Random Gender
     */
    public String randomGender(){
        String[] gender = {"Male", "Female"};
        return gender[new Random().nextInt(2)];
    }
    
    /**
     * Method that gets Qualifications Randomly.
     * @return  Qualifications
     */
    public List<Qualification> randomQualifications(){
        List<Qualification> options = Qualification.getQualifications();
        ArrayList<Qualification> selectedQualifications = new ArrayList<>();
        while(selectedQualifications.size()<3){
            selectedQualifications.add(options.remove(new Random().nextInt(options.size())));
        }
        return selectedQualifications;
    }
    
    /**
     * Method to Randomly generate Vaccines to animals.
     * @param a 
     */
    public void generateRandomlyVaccines(Animal a){
        List<Vaccine> vaccines = zooData.getVaccines();
        List<Vaccine> options = new ArrayList<>();
        List<String> types = a.getAnimalTypes();        
        
        for(Vaccine v : vaccines){            
            for(String s : types){
               
                if (s.equalsIgnoreCase(v.getType())){
                    options.add(v);
                }               
            }
        }
        Random rand = new Random();
        if(options.size()>0){
         a.addVaccines(options.get(rand.nextInt(options.size())));   
        } 
    } 
    /**
     * Method to Generate a List of Vaccines to Animals, note that insects are not included
     * @return 
     */
    public  List<Vaccine> generateVaccines() {
       List<Vaccine> vaccines = new ArrayList<>();
       
       vaccines.add(new Vaccine("Pest Control","Mammal"));
       vaccines.add(new Vaccine("Flu","Avian"));
       vaccines.add(new Vaccine("Parasit Control","Aquatic"));
       vaccines.add(new Vaccine("Parasit","Reptile"));
       vaccines.add(new Vaccine("None", "Insect"));
       return vaccines;  
      }
}
