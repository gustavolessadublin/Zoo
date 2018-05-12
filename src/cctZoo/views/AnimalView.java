package cctZoo.views;

import cctZoo.models.animals.abstracts.Animal;
import cctZoo.models.animals.interfaces.Avian;

/**
 * Animal view class.
 * @author rbsrafa
 */
public class AnimalView extends View{
    private TableList table;
    
    /**
     * Default constructor that initializes a table view.
     */
    public AnimalView(){
        table = new TableList("ID", "Species", "Type", "Flight", "Name", "Gender", 
                              "DOB", "Date of Arrival","Vaccines", "Medication","Offspring", 
                              "ZooKeeper").sortBy(1).withUnicode(true);
    }
    
    /**
     * This method populates the TableList with an animal
     * @param a 
     */
    public void addAnimalToTable(Animal a){
        String[] row = {
            Integer.toString(a.getId()), a.getSpecies(), a.getAnimalTypes().toString(), this.canFly(a),
            a.getName(), a.getGender(), a.getDOB(), a.getDateOfArrival(), a.getVaccines().toString(),
            this.medicated(a), Integer.toString(a.getNumberOfOffspring()), 
            a.getKeeper().getName()
        };
        table.addRow(row);
    }
    
    /**
     * This method prints true if the animal can fly and false otherwise.
     * @param a
     * @return 
     */
    public String canFly(Animal a){
        if(a instanceof Avian) return Boolean.toString(((Avian) a).canFly());
        else return "False";
    }
    
    /**
     * This method checks if an animal is medicated and prints the medication or
     * none in case the animal is not medicated.
     * @param a
     * @return 
     */
    public String medicated(Animal a){
        if(a.isMedicated()) return a.getMedicationName();
        else return "none";
    }
    
    /**
     * This method prints the animals table on CLI
     */
    public void display(){        
        this.table.print();
        this.table.removeAll();
        System.out.println();
    }
    
}
