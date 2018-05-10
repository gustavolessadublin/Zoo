/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.controllers;
import cctZoo.models.Model;
import cctZoo.models.animals.AquaticMammal;
import cctZoo.models.animals.abstracts.Animal;
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
public class VaccineControler {
    ZooData zooData;
    private List<Vaccine> listVacine;
    private View view;
    private List<Animal> animals;

    public VaccineControler(List<Vaccine> listVacine, View view) {
        this.listVacine = listVacine;
        this.view=view;
    }
    public void Vaccine(){
        List<Animal>vacc = this.add();
        vacc.forEach((a) -> {
            this.view.display((Model)a);
        });
        this.listVacine.add((Vaccine) vacc);
       
        
    }
    public List<Animal> randomVacine(){
        Animal an= null;
        Random ran = new Random();
        AquaticMammal mammal = null;
        String [] vaccines = {"Parasit Control","Pest sControl"};
        String vac = vaccines[ran.nextInt(vaccines.length)];
        
        if(vac.equals("")){
            an = new Vaccine(0, vac, vac, vac, vac);
            System.out.println(an);
        }
        an.setName(vac);
        return (List<Animal>) an;
    }
    
    public List<Animal> add()
    {  
        List<Animal>mamm = this.randomVacine();
        int vac = 0;
        for(int i = vac; i < vac; i++ ){
            animals.stream().filter((a) -> (a instanceof Mammal)).forEachOrdered((a) -> {
                mamm.add(a);
            });
            zooData.getAnimals().add((Animal) this.randomVacine());
        
        }
        return mamm;
          
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }   
}
