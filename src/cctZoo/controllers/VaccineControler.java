/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.controllers;

import cctZoo.models.animals.abstracts.Animal;
import cctZoo.models.employees.zooKeeper.Qualification;
import cctZoo.views.AnimalView;
import cctZoo.views.View;
import cctZoo.zooData.DataFactory;
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
    DataFactory data;

    public VaccineControler(List<Vaccine> listVacine, AnimalView view) {
        this.listVacine = listVacine;
        this.view=view;
    }
//    public void Vaccine(){
//        List<Animal>vacc = this.add();
//        vacc.forEach((a) -> {
//            this.view.display((Model)a);
//        });
//        this.listVacine.add((Vaccine) vacc);
//       
//        
//    }
    public Animal randomVacine(String specie, String name, String gender, String doa, String dob){
        Animal an= null;
        List<Qualification> animalType = new ArrayList<>();
        Random ran = new Random();
        String [] vaccines = {"Parasit Control","Pest Control"};
        if(animalType.size() == 1){
            String vac = animalType.get(0).toString();
            vac = vaccines[ran.nextInt(vaccines.length)];
            if(vac.equalsIgnoreCase("mammal")){
            vac = an.getVaccines();
            data.assignKeeper(an);
            System.out.println(an);
            }
        } 
        return an;
    }
    
//    public List<Animal> add()
//    {  
//        List<Animal>mamm = this.randomVacine();
//        int vac = 0;
//        for(int i = vac; i < vac; i++ ){
//            animals.stream().filter((a) -> (a instanceof Mammal)).forEachOrdered((a) -> {
//                mamm.add(a);
//            });
//            zooData.getAnimals().add((Animal) this.randomVacine());
//        
//        }
//        return mamm;
//          
//    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }   
}
