/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.views;

import cctZoo.models.animals.abstracts.Animal;

/**
 *
 * @author rbsrafa
 */
public class AnimalView extends View{
    private TableList table;
    
    public AnimalView(){
        table = new TableList("ID", "Species", "Type", "Name", "Gender", 
                              "DOB", "Date of Arrival","Vaccines", "Offspring", 
                              "ZooKeeper").sortBy(1).withUnicode(true);
    }
    
    /**
     * This method populates the TableList with an animal
     * @param a 
     */
    public void addAnimalToTable(Animal a){
        String[] row = {
            Integer.toString(a.getId()), a.getSpecies(), a.getAnimalTypes().toString(),
            a.getName(), a.getGender(), a.getDOB(), a.getDateOfArrival(), a.getVaccines(),
            Integer.toString(a.getNumberOfOffspring()), 
            a.getKeeper().getName()
        };
        table.addRow(row);
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
