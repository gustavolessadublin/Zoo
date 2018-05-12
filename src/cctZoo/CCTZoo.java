package cctZoo;

import cctZoo.menus.MainMenu;
import cctZoo.zooData.ZooData;

/**
 *
 * @author rbsrafa
 */
public class CCTZoo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ZooData zooData = new ZooData();
        new MainMenu(zooData);
    }
    
}
