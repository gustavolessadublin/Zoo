package cctZoo.zooData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class reads and writes contents of a file.
 * @author rbsrafa
 */
public class FileRW {
    Random rand;
    Path malePath;
    Path femalePath;
    Path surnamesPath;
    
    /**
     * Default constructor. Sets the path of the files that contain a set of names and surnames.
     */
    public FileRW(){
        rand = new Random();
        malePath = Paths.get("src", "Data", "maleFirstNames.txt");
        femalePath = Paths.get("src", "Data", "femaleFirstNames.txt");
        surnamesPath = Paths.get("src", "Data", "surnames.txt");
    }
    
    /**
     * This method randomly generates a name based in the specified gender.
     * @param gender
     * @return String name.
     */
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
    
    /**
     * This method randomly generates a surname.
     * @return String surname.
     */
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
