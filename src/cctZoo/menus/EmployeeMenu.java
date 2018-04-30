/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.menus;

import cctZoo.controllers.AnimalsController;
import cctZoo.controllers.EmployeesController;
import cctZoo.models.employees.zooKeeper.ZooKeeper;
import cctZoo.views.View;
import cctZoo.zooData.ZooData;
import java.util.ArrayList;

/**
 *
 * @author Gustavo Lessa
 */
public class EmployeeMenu extends Menu{
    private EmployeesController keepers;
    private String[] options;
   
    public EmployeeMenu(ZooData zooData){
        super(zooData);
        this.keepers = new EmployeesController((ArrayList<ZooKeeper>) zooData.getZooKeepers(), new View());
        String[] options = {"List Keepers","Add Keeper","Search Keepers"};
        this.setOptions(options);
        this.setTitle("Keeper Menu");
        this.startMenu();
    }

    @Override
    public void optionSelector() {
        System.out.println("\nPlease select an option:");
        int option = this.in.nextInt();
        switch(option){
            case 1:
                this.showKeepers();
                break;
            case 2:
                this.addKeeper();
                break;
            case 3:
                this.searchKeeper();
                break;
        }
    }


    private void showKeepers() {
        this.keepers.display();
    }

    private void addKeeper() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void searchKeeper() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
