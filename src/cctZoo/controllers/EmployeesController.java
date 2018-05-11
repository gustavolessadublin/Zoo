/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.controllers;

import cctZoo.models.employees.zooKeeper.ZooKeeper;
import cctZoo.views.KeeperView;
import cctZoo.views.View;
import java.util.List;

/**
 *
 * @author Gustavo Lessa
 */
public class EmployeesController {
    private List<ZooKeeper> keepers;
    private KeeperView view;
    
    public EmployeesController(List<ZooKeeper> keepers, KeeperView view){
        this.keepers = keepers;
        this.view = view;
    }
    
    public void displayAll(){
        for(ZooKeeper k: keepers){
            this.view.addKeeperToTable(k);
        }
        this.view.displayTable();
    }
    
    public void add(ZooKeeper k){
        this.keepers.add(k);
    }

    public void display(ZooKeeper k) {
        this.view.display(k);
    }

}
