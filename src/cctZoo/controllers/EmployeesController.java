/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.controllers;

import cctZoo.models.Model;
import cctZoo.models.employees.zooKeeper.ZooKeeper;
import cctZoo.views.View;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo Lessa
 */
public class EmployeesController {
    private List<ZooKeeper> keepers;
    private View view;
    
    public EmployeesController(List<ZooKeeper> keepers, View view){
        this.keepers = keepers;
        this.view = view;
    }
    
    public void display(){
        for(ZooKeeper k: keepers){
            this.view.display(k);
        }
    }
    
    public void add(ZooKeeper k){
        this.keepers.add(k);
    }


}
