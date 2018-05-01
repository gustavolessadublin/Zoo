/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.zooData;

import cctZoo.models.animals.AquaticAvian;
import cctZoo.models.animals.AquaticMammal;
import cctZoo.models.animals.AquaticReptile;
import cctZoo.models.animals.AvianMammal;
import cctZoo.models.animals.GenericAquatic;
import cctZoo.models.animals.GenericAvian;
import cctZoo.models.animals.GenericInsect;
import cctZoo.models.animals.GenericMammal;
import cctZoo.models.animals.GenericReptile;
import cctZoo.models.animals.abstracts.AbstractAnimal;
import cctZoo.models.animals.interfaces.Animal;
import cctZoo.models.animals.interfaces.Aquatic;
import cctZoo.models.animals.interfaces.Avian;
import cctZoo.models.animals.interfaces.Insect;
import cctZoo.models.animals.interfaces.Mammal;
import cctZoo.models.animals.interfaces.Reptile;
import cctZoo.models.employees.zooKeeper.Qualification;
import cctZoo.models.employees.zooKeeper.ZooKeeper;
import cctZoo.zooData.FileRW;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.apache.commons.collections4.CollectionUtils;

/**
 *
 * @author rbsrafa
 */
public class DataFactory {
    FileRW rw;
    ZooData zooData;
    
    public DataFactory(ZooData zooData){
        rw = new FileRW();
        this.zooData = zooData;
    }
    
//    public Animal getRandomAnimal(){
//        Animal a = this.generateRandomAnimal();
//        return a;
//    }
    
    public void getRandomAnimals(int amount){
        for(int i = 0; i < amount; i++){
            zooData.getAnimals().add(this.generateRandomAnimal());
        }
    }
    
    private AbstractAnimal generateRandomAnimal(){
        AbstractAnimal a = null;
        Random rand = new Random();
        String[] gender = {"Male", "Female"};
        String[] species = {"Dolphin", "Whale", "Crocodile", "Penguin", "Dragonfly",
                            "Beetle", "Tiger", "Zebra", "Lion", "Snake", "Komodo Dragon",
                            "Seagull", "Owl", "Bat", "Shark", "Octopus"};
        
        String specie = species[rand.nextInt(species.length)];
        
        if(specie.equals("Dolphin") || specie.equals("Whale")){
            a = new AquaticMammal(specie, gender[rand.nextInt(gender.length)]);
        }else if(specie.equals("Crocodile")){
            a = new AquaticReptile(specie, gender[rand.nextInt(gender.length)]);
        }else if(specie.equals("Penguin")){
            a = new AquaticAvian(specie, gender[rand.nextInt(gender.length)]);
        }else if(specie.equals("Dragonfly") || specie.equals("Beetle")){
            a = new GenericInsect(specie, gender[rand.nextInt(gender.length)]);
        }else if(specie.equals("Tiger") || specie.equals("Zebra") || specie.equals("Lion")){
            a = new GenericMammal(specie, gender[rand.nextInt(gender.length)]);
        }else if(specie.equals("Snake") || specie.equals("Komodo Dragon")){
            a = new GenericReptile(specie, gender[rand.nextInt(gender.length)]);
        }else if(specie.equals("Seagull") || specie.equals("Owl")){
            a = new GenericAvian(specie, gender[rand.nextInt(gender.length)]);
        }else if(specie.equals("Bat")){
            a = new AvianMammal(specie, gender[rand.nextInt(gender.length)]);
        }else if(specie.equals("Shark") || specie.equals("Octopus")){
            a = new GenericAquatic(specie, gender[rand.nextInt(gender.length)]);
        }
              
        a.setName(rw.getRandomName(a.getGender()));       
        assignKeeper(a);
        return a;
    }
    
    
    
    private void assignKeeper(AbstractAnimal a){
        ArrayList<Qualification> animalTypes = new ArrayList<>();
        if (a instanceof Mammal){ animalTypes.add(Qualification.MAMMAL);}
        if (a instanceof Reptile){ animalTypes.add(Qualification.REPTILE);}
        if (a instanceof Avian){ animalTypes.add(Qualification.AVIAN);}
        if (a instanceof Aquatic){ animalTypes.add(Qualification.AQUATIC);}
        if (a instanceof Insect){ animalTypes.add(Qualification.INSECT);}

        //TODO check statement
        boolean done = false;
        while(!done){
            for(ZooKeeper z : zooData.getZooKeepers()){
                if (CollectionUtils.containsAll(z.getQualifications(),animalTypes) && (z.getAnimals()==null || z.getAnimals().size()<10)){
                    z.addAnimal(a);
                    a.setKeeper(z);
                    done = true;
                    break;
                } 
            }
            if(a.getKeeper()==null){
                zooData.getZooKeepers().add(this.generateRandomKeeper(animalTypes));
            }
        }
    }
    
    public List<ZooKeeper> getRandomKeepers(int amount){
        List<ZooKeeper> keepers = new ArrayList<>();
        for(int i = 0; i < amount; i++){
            keepers.add(this.generateRandomKeeper());
        }
        return keepers;
    }
    
    private ZooKeeper generateRandomKeeper(){
        String gender = randomGender();
        String name = rw.getRandomName(gender).concat(" ").concat(rw.getRandomSurname());        
        return new ZooKeeper(gender, name, randomQualifications());
    }
    
    private ZooKeeper generateRandomKeeper(ArrayList<Qualification> qualifications){
        String gender = randomGender();
        String name = rw.getRandomName(gender).concat(" ").concat(rw.getRandomSurname());        
        return new ZooKeeper(gender, name, qualifications);
    }
    
    private String randomGender(){
        String[] gender = {"Male", "Female"};
        return gender[new Random().nextInt(2)];
    }
    
    private ArrayList<Qualification> randomQualifications(){
        ArrayList<Qualification> options = new ArrayList<>();
        ArrayList<Qualification> selectedQualifications = new ArrayList<>();
        for(Qualification q : Qualification.values()){
            options.add(q);
        }
        while(selectedQualifications.size()<3){
            selectedQualifications.add(options.remove(new Random().nextInt(options.size())));
        }
        return selectedQualifications;
    }
}