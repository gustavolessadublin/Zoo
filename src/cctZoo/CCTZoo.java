package cctZoo;

import cctZoo.menus.MainMenu;
import cctZoo.zooData.ZooData;

/**
 * This class contains the main() method and is responsible for initializing
 * the data and displaying the main menu.
 * @author rbsrafa
 */
public class CCTZoo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ZooData zooData = new ZooData();
        System.out.println("\nWelcome to CCT Zoo!");
        new MainMenu(zooData);
    }
    
}
