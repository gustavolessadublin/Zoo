/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.medication;

/**
 *
 * @author rbsrafa
 */
public class Medication{
    private String name;
    private boolean medicated;

    public Medication(String name) {
        this.name = name;
        this.medicated = false;
    }

    @Override
    public String toString() {
        return "Medication\n" +
               "Name: " + this.name + "\n" +
               "Medicated: " + this.medicated;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isMedicated() { return medicated; }
    public void setMedicated(boolean medicated) { this.medicated = medicated; }

    }
