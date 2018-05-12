/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.views;

import cctZoo.models.employees.zooKeeper.ZooKeeper;

/**
 * This class generates tables of keepers
 * @author rbsrafa
 * @author Gustavo Lessa
 */
public class KeeperView extends View{
    private TableList table;
    
    /**
     * Constructor initializes the table by adding its headers and setting the
     * sort by.
     */
    public KeeperView(){
        table = new TableList("ID", "Name", "Gender", 
                              "Assigned Animal IDs ","Qualifications").sortBy(1).withUnicode(true);
    }
    
    /**
     * This method adds a row to the table using a ZooKeeper object's info.
     * @param k (ZooKeeper) keeper to be added.
     */
    public void addKeeperToTable(ZooKeeper k){
        String[] row = {
            Integer.toString(k.getId()), k.getName(), 
            k.getGender(), k.caredAnimals(), k.getQualifications().toString()
        };
        table.addRow(row);
    }
    
    /**
     * This method prints the table, clearing it afterwards.
     */
    public void displayTable(){        
        this.table.print();
        this.clearTable();
        System.out.println();
    }
    
    /**
     * This method clears the table by removing its content.
     */
    public void clearTable(){
        this.table.removeAll();
    }
    
}
