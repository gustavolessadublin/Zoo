/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.models.employees.zooKeeper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This enum represents the qualifications a zoo keeper can have.
 * @author Gustavo Lessa
 */
public enum Qualification {
    AVIAN, REPTILE, MAMMAL, INSECT, AQUATIC;

    /**
     * This method returns a List of all qualifications.
     * @return 
     */
    public static List<Qualification> getQualifications(){
        List<Qualification> qualifications = new ArrayList<>();
        qualifications.addAll(Arrays.asList(Qualification.values()));
        return qualifications;
    }
    
    public static List<String> getNames(){
        List<String> names = new ArrayList<>();
        for(Enum e: Qualification.values()){
            names.add(e.toString());
        }
        return names;
    }

}

