/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.views;

import cctZoo.models.employees.zooKeeper.ZooKeeper;

/**
 *
 * @author rbsrafa
 */
public class KeeperView extends View{
    private TableList table;
    
    public KeeperView(){
        table = new TableList("ID", "Name", "Gender", 
                              "Assigned Animal IDs ","Qualifications").sortBy(1).withUnicode(true);
    }
    
    /**
     * This method populates the TableList with an animal
     * @param a 
     */
    public void addKeeperToTable(ZooKeeper k){
        String[] row = {
            Integer.toString(k.getId()), k.getName(), 
            k.getGender(), k.caredAnimals(), k.getQualifications().toString()
        };
        table.addRow(row);
    }
    
    /**
     * This method prints the animals table on CLI
     */
    public void displayTable(){        
        this.table.print();
        this.clearTable();
        System.out.println();
    }
    
    public void clearTable(){
        this.table.removeAll();
    }
    
}
