package cctZoo.menus;

import cctZoo.controllers.AnimalsController;
import cctZoo.models.animals.abstracts.Animal;
import cctZoo.models.employees.zooKeeper.Qualification;
import cctZoo.views.AnimalView;
import cctZoo.zooData.DataFactory;
import cctZoo.zooData.ZooData;
import java.util.ArrayList;
import java.util.List;

/**
 * Animal Menu class
 * @author rbsrafa
 */
public class AnimalMenu extends Menu{
    private AnimalsController animals;
    DataFactory data;
    
    /**
     * Basic AnimalMenu constructor
     * @param zooData 
     */
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
        System.out.println("\nAnimal has been medicated.\n");
    }
    
    public void addAnimal(){  
        String species = this.chooseSpecies();
        String name = this.chooseName();
        String gender = this.chooseGender();
        String DOB = this.chooseDOB();
        String dateOfArrival = this.chooseDateOfArrival();
        List<String> types = this.chooseTypes();
        Animal animal = this.animals.createAnimalByType(species, name, gender, DOB, dateOfArrival, types);
        this.data.assignKeeper(animal);
        this.animals.add(animal);
        this.chooseOffspring(animal);
        System.out.println();
    }
    
    private void chooseOffspring(Animal parent){
        if(parent.getGender().equalsIgnoreCase("female")){
            System.out.println("Does it have a offspring?\n"
                + "1 - Yes\n" + "2 - No");
            int answer = this.validate.checkForInt(this.in, 1, 2);
            if(answer == 1){
                Animal offspring = this.animals.createAnimalByType(
                    parent.getSpecies(), this.chooseName(), 
                    this.chooseGender(), this.chooseDOB(), 
                    parent.getDateOfArrival(), parent.getAnimalTypes()
                );
                this.data.assignKeeper(offspring);
                this.animals.add(offspring);
                List<Animal> list = new ArrayList<>();
                list.add(offspring);
                parent.setOffSpring(list);
            
                System.out.println("\nParent:");
                System.out.println(parent + "\n");
                System.out.println("Offspring:");
                System.out.println(offspring + "\n");
            }else if(answer == 2){
                System.out.println(parent);
            }
        }
        
    }
    
    private List<String> chooseTypes(){
        List<String> allTypes = Qualification.getNames();
        List<String> types = new ArrayList<>();
        System.out.println("Please select the type of animal:\n");
        
        for(int i = 0; i < allTypes.size(); i++) System.out.println(i+1 + " - " + allTypes.get(i));
        
        int selected = this.validate.checkForInt(in)-1;
        String type1 = allTypes.get(selected);
        String type2;
        allTypes.remove(selected);
        System.out.println("Would you like to select another type?\n"
                + "1 - Yes\n2 - No");
        int answer = this.validate.checkForInt(this.in, 1, 2);
        if(answer == 1){
            System.out.println("Please select the type of animal:\n");
            for(int i = 0; i < allTypes.size(); i++) System.out.println(i+1 + " - " + allTypes.get(i));
            type2 = allTypes.get(this.validate.checkForInt(in)-1);
            types.add(type1);
            types.add(type2);
        }else if(answer == 2){
            types.add(type1);
            return types;
        }

        return types;
    }
    
    private String chooseDateOfArrival(){
        System.out.println("Please type the date of arrival");
        return in.next();
    }
    
    private String chooseDOB(){
        System.out.println("Please type the animal date of birth");
        return this.in.next();
    }
    
    private String chooseSpecies(){
        System.out.println("Please type the animal species: (Eg. Tiger, Whale, Crocodile)");  
        return this.in.next();
    }
    
    private String chooseName(){
        System.out.println("Please type the animal name:");
        return this.in.next();
    }
    
    private String chooseGender(){
        System.out.println("Please type the aniaml gender:\n"
                + "1 - Male\n" + "2 - Female");
        
        if(this.validate.checkForInt(in, 1, 2) == 1) return "Male";
        else return "Female";
    }
}

