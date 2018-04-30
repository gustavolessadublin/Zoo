/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.models.employees.zooKeeper;

import cctZoo.zooData.FileRW;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Gustavo Lessa
 */
public class KeeperFactory {
    FileRW rw;
    
    public KeeperFactory(){
        rw = new FileRW();
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
