/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.zooData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author rbsrafa
 */
public class FileRW {
    Random rand;
    Path malePath;
    Path femalePath;
    Path surnamesPath;
    
    public FileRW(){
        rand = new Random();
        malePath = Paths.get("src", "Data", "maleFirstNames.txt");
        femalePath = Paths.get("src", "Data", "femaleFirstNames.txt");
        surnamesPath = Paths.get("src", "Data", "surnames.txt");
    }
    
    public String getRandomName(String gender){
        List<String> names = new ArrayList<>();
        String name;
        
        try {
            if(gender.equals("Male")){ names = Files.readAllLines(malePath); }
            else if(gender.equals("Female")){ names = Files.readAllLines(femalePath); }  
        } catch (IOException ex) {
            System.out.println("Could not read file.");
        }  

        return name = names.get(rand.nextInt(names.size()));
    }
    
    public String getRandomSurname(){
        List<String> surnames = new ArrayList<>();
        String surname;
        
        try{
            surnames = Files.readAllLines(this.surnamesPath);
        } catch (IOException ex) {
            System.out.println("Could not read file.");
        }
        
        return surname = surnames.get(rand.nextInt(surnames.size()));
    }
    
}
