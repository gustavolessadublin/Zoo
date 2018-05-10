/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cttZoo.models.vaccine;

import cctZoo.models.animals.abstracts.Animal;
import java.util.Date;

/**
 *
 * @author fernandotenorio
 */
public class Vaccine  extends Animal{
    private int idVaccine;
    private String nameVaccine;
    private String dateVaccine;

 
    public Vaccine(int idVaccine, String nameVaccine, String dateVaccine, String species, String gender) {
        super(species, gender);
        this.idVaccine = idVaccine;
        this.nameVaccine = nameVaccine;
        this.dateVaccine = dateVaccine;
    }

    public int getIdVaccine() {
        return idVaccine;
    }

    public void setIdVaccine(int idVaccine) {
        this.idVaccine = idVaccine;
    }

    public String getNameVaccine() {
        return nameVaccine;
    }

    public void setNameVaccine(String nameVaccine) {
        this.nameVaccine = nameVaccine;
    }

    public String getDateVaccine() {
        return dateVaccine;
    }

    public void setDateVaccine(String dateVaccine) {
        this.dateVaccine = dateVaccine;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
