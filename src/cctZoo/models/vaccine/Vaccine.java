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

    public Vaccine(String name, String type) {
        this.idVaccine = ++lastID;
        this.nameVaccine = name;
        this.type = type;        
        
    }
    public String getType() {
        return type;
    }
    
    public int getIdVaccine() {
        return idVaccine + lastID;
    }

    public void setIdVaccine(int idVaccine) {
        this.idVaccine = idVaccine;
    }

    public String getNameVaccine() {
        return nameVaccine + 1;
    }

    public void setNameVaccine(String nameVaccine) {
        this.nameVaccine = nameVaccine;
    }

    @Override
    public String toString() {
        return this.nameVaccine;            
    }

    
}
