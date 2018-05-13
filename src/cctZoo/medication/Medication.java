/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.medication;

/**
 * Medication class responsible for store a name and if is medicated.
 * @author rbsrafa
 */
public class Medication{
    private String name;
    private boolean medicated;

    /**
     * Basic constructor that accepts a string name as argument.
     * @param name 
     */
    public Medication(String name) {
        this.name = name;
        this.medicated = false;
    }

    /**
     * This method returns the object information as a String.
     * @return 
     */
    @Override
    public String toString() {
        return "Medication\n" +
               "Name: " + this.name + "\n" +
               "Medicated: " + this.medicated;
    }

    /**
     * This methodd returns the medication name.
     * @return 
     */
    public String getName() { return name; }
    
    /**
     * This method accepts a name as argument and sets the medication name.
     * @param name 
     */
    public void setName(String name) { this.name = name; }

    /**
     * This method returns if the animal is medicated or not.
     * @return 
     */
    public boolean isMedicated() { return medicated; }
    
    /**
     * This method sets if the animal is medicated.
     * @param medicated 
     */
    public void setMedicated(boolean medicated) { this.medicated = medicated; }

    }
