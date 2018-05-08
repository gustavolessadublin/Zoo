/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        //lba
    }
    
}
