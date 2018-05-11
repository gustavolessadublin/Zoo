package cctZoo.menus;

import cctZoo.controllers.AnimalsController;

import cctZoo.models.animals.GenericAquatic;
import cctZoo.models.animals.GenericAvian;
import cctZoo.models.animals.GenericInsect;
import cctZoo.models.animals.GenericMammal;
import cctZoo.models.animals.GenericReptile;
import cctZoo.models.animals.abstracts.Animal;
import cctZoo.models.employees.zooKeeper.Qualification;
import cctZoo.views.AnimalView;
import cctZoo.zooData.DataFactory;
import cctZoo.zooData.ZooData;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rbsrafa
 */
public class AnimalMenu extends Menu{
    private AnimalsController animals;
    DataFactory data;
    
    
    public AnimalMenu(ZooData zooData){
        super(zooData);
        this.animals = new AnimalsController(this.zooData.getAnimals(), new AnimalView());
        String[] options = {"Show Animals", "Add Animal", "Medicate Animal",
                            "Search Options", "Return to Main Menu", "Exit Program"};
        this.data = new DataFactory(zooData);
        this.setOptions(options);
        this.setTitle("Animal Menu");
        this.startMenu();
        
    }

    /**
     * This method is responsible for linking the menu options with their
     * respective actions.
     */
    @Override
    public void optionSelector() {
        System.out.println("\nPlease select an option:");
        int option = this.validate.checkForInt(in);
        switch(option){
            case 1: this.animals.display();
                break;
            case 2: this.addAnimal();
                break;
            case 3: this.medicateAnimal();
                break;
            case 4: new AnimalSearchMenu(this.zooData);
                break;
            case 5: new MainMenu(this.zooData);
                break;
            case 6: System.exit(0);
                break;
        }
    }
    
    /**
     * This method sets the animal medication to true;
     */
    public void medicateAnimal(){
        System.out.println("Please type the ID of the animal to medicate");
        Animal a = this.animals.findAnimal(this.validate.checkForInt(in));
        a.setMedicated(true);
        System.out.println("");
    }
    
    public void addAnimal(){
        List<Qualification> types = Qualification.getQualifications();
        
        Animal a = null;
        System.out.println("Type here animal informataion: ");
        System.out.println("-----------------------------");
        System.out.println("Enter Animal Specie: ");
        String specie = this.in.next(); 
        System.out.println("Enter Animal Name: ");
        String name = this.in.next();
        System.out.println("Enter Animal Gender");
        String gender = this.in.next();
        System.out.println("Enter date of arrival");
        String date = this.in.next();
        System.out.println("Enter date of birth");
        String dob = this.in.next();
        System.out.println("");
        List<Qualification> selectedTypes = this.chooseAnimalType();
        System.out.println("");
        a = createAnimal(specie, name, gender, date, dob, selectedTypes);
        data.assignKeeper(a);
        this.animals.add(a);

        System.out.println("Does this animal have offspring?");
        System.out.println("");
        boolean answer = this.validate.checkForYes(in);
        addOffSpring(a);
    }
    
    private List chooseAnimalType(){
        List<Qualification> types = Qualification.getQualifications();
        List<Qualification> chosen = new ArrayList<>();
        for (int x = 0; x<2; x++){
            System.out.println("Select a type:");
            chosen.add(types.remove(chooseOption(types)));
            if (x < 1){
                System.out.println("Would you like to add another one? (Y/N)");
                if(!validate.checkForYes(in)){
                    break;
                }               
            }
        }
        return chosen;
    }
    
    private int chooseOption(List options){
        for(int x = 0; x < options.size(); x++){
            System.out.println((x+1)+" - "+options.get(x));
        }
        System.out.println("Please choose an option: ");
        return (validate.checkForInt(in, 1, options.size()))-1;
    }
    
    public void checkForOffSpring(boolean answer){
        if(answer){
            
        }
    }
    
    public void addOffSpring(Animal a){
        
        System.out.println("Type here animal informataion: ");
        System.out.println("-----------------------------"); 
        System.out.println("Enter Animal Name: ");
        String name = this.in.next();
        System.out.println("Enter Animal Gender");
        String gender = this.in.next();
        System.out.println("Enter date of arrival");
        String date = this.in.next();
        System.out.println("Enter date of birth");
        String dob = this.in.next();
        
        a = this.createAnimal(name, gender, dob, a);
        this.data.assignKeeper(a);
    }
    
    public Animal createAnimal(String specie, String name, String gender, String doa, String dob, List<Qualification> selectedTypes ){
        Animal a = null;
        if(selectedTypes.size() == 1){
            String type = selectedTypes.get(0).toString();
            if(type.equalsIgnoreCase("mammal")){
              a = new GenericMammal(specie, name, gender, doa, dob);
            }else if(type.equalsIgnoreCase("reptile")){
              a = new GenericReptile(specie, name, gender, doa, dob);
            }else if(type.equalsIgnoreCase("avian")){
              a = new GenericAvian(specie, name, gender, doa, dob);
            }
            else if(type.equalsIgnoreCase("aquatic")){
              a = new GenericAquatic(specie, name, gender, doa, dob);
            }
            else if(type.equalsIgnoreCase("insect")){
              a = new GenericInsect(specie, name, gender, doa, dob);
            }
        }
        
        return a;
        
    }
    
    public Animal createAnimal(String name, String gender,String dob, Animal a){
            if(a.equals("mammal")){
              a = new GenericMammal(a.getSpecies(), name, gender,dob);
            }else if(a.equals("reptile")){
              a = new GenericReptile(a.getSpecies(), name, gender,dob);
            }
        return a;
    }   
}
