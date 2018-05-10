/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.models.employees.zooKeeper;

import java.util.ArrayList;
import java.util.List;

/**
 * This enum represents the qualifications a zoo keeper can have.
 * @author Gustavo Lessa
 */
public enum Qualification {
    AVIAN, REPTILE, MAMMAL, INSECT, AQUATIC;

    public static List<Qualification> getQualifications(){
        List<Qualification> qualifications = new ArrayList<>();
        for(Qualification q : Qualification.values()){
            qualifications.add(q);
        }
        return qualifications;
    }

}

