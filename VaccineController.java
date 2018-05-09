/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.controllers;
import cctZoo.models.Model;
import cctZoo.models.animals.AquaticMammal;
import cctZoo.models.animals.abstracts.AbstractAnimal;
import cctZoo.models.animals.interfaces.Animal;
import cctZoo.models.animals.interfaces.Mammal;
import cctZoo.views.View;
import cctZoo.zooData.ZooData;

import java.util.List;
import cttZoo.models.vaccine.Vaccine;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author fernandotenorio
 */
public class VaccineController {
    ZooData zooData;
    private List<Vaccine> listVacine;
    private View view;

    public VaccineController(List<Vaccine> listVacine, View view) {
        this.listVacine = listVacine;
        this.view=view;
    }
    public int Vaccine(int vac){
        for(int i = vac; i < vac; i++ ){
            zooData.getAnimals().add((Animal) this.addVaccine());
        }
        return vac;
    }
    public List<Animal> addVaccine(){
        AbstractAnimal an= null;
        Random ran = new Random();
        AquaticMammal mammal = null;
        String [] vaccines = {"Parasit Control","Pest sControl"};
        String vac = vaccines[ran.nextInt(vaccines.length)];
        
        if(vac.equals(mammal)){
            an = new Vaccine(0, vac, vac, vac, vac);
            System.out.println(an);
        }
        an.setName(vac);
        return (List<Animal>) an;
    }
    
    public Vaccine add(Vaccine v)
    {  
        List<Animal>vacc = this.addVaccine();
        for(Animal a : vacc) this.view.display((Model)a);
        this.listVacine.add((Vaccine) vacc);
        return v;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }   
}
