/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.models.vaccine;

/**
 *
 * @author fernandotenorio
 */
public class Vaccine{
    private static int lastID = 0;
    private int idVaccine;
    private String nameVaccine;
    private String type;

    /**
     * Basic constructor that accepts a string name, an type as argument.
     * @param name
     * @param type 
     */
    public Vaccine(String name, String type) {
        this.idVaccine = ++lastID;
        this.nameVaccine = name;
        this.type = type;        
    }
    
    /**
     * Method to return type of animal.
     * @return 
     */
    public String getType() {
        return type;
    }
    
    /**
     * this method takes the vaccine id, and returns animal id
     * @return 
     */
    public int getIdVaccine() {
        return idVaccine + lastID;
    }

    /**
     * Method to accept name as argument and set the vaccine name.
     * @param idVaccine 
     */
    public void setIdVaccine(int idVaccine) {
        this.idVaccine = idVaccine;
    }

    /**
     * This method returns Vaccine name.
     * @return 
     */
    public String getNameVaccine() {
        return nameVaccine + 1;
    }
    
    /**
     * This method accepts a name as argument and sets the vaccine name.
     * @return 
     */
    public void setNameVaccine(String nameVaccine) {
        this.nameVaccine = nameVaccine;
    }

    /**
     * This method returns the object Vaccine information as String.
     * @return 
     */
    @Override
    public String toString() {
        return this.nameVaccine;            
    }

    
}
