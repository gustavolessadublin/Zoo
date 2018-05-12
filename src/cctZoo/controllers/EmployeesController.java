/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.controllers;

import cctZoo.menus.SearchKeeperMenu;
import cctZoo.models.animals.abstracts.Animal;
import cctZoo.models.employees.zooKeeper.Qualification;
import cctZoo.models.employees.zooKeeper.ZooKeeper;
import cctZoo.views.KeeperView;
import cctZoo.views.View;
import cctZoo.zooData.ZooData;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;

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
    
    public List<Integer> getAllIds(){
        List<Integer> ids = new ArrayList<>();
        for(ZooKeeper k : keepers){
            ids.add(k.getId());
        }
        return ids;
    }
    
    public ZooKeeper getKeeper(int id){
        
        return keepers.get(id);
    }
    
    public void display(){
        this.view.clearTable();
        for(ZooKeeper k: keepers){
            this.view.addKeeperToTable(k);
        }
        this.view.displayTable();
    }
    
    public void add(ZooKeeper k){
        this.keepers.add(k);
    }
    
    public void display(int keeperId){
        int counter = 0;
        for(ZooKeeper k : keepers){
            if (k.getId()==keeperId){
                counter++;
                this.display(k);
                break;
            }
        }
        if(counter==0){
            System.out.println("ID not found!");
        }
    }

    public void display(Object k) {
        this.view.display("\n"+ k);
    }
    
    public void display(List<ZooKeeper> group){
        this.view.clearTable();
        for(ZooKeeper k: group){
            this.view.addKeeperToTable(k);
        }
        this.view.displayTable();
    }
    
    public boolean searchQualifications(List<Qualification> qualifications, boolean all){
        this.view.clearTable();
        int counter = 0;
        for(ZooKeeper k : keepers){
            if(all && CollectionUtils.containsAll(k.getQualifications(), qualifications)){
                counter++;
                this.view.addKeeperToTable(k);
            } else if (!all && CollectionUtils.containsAny(k.getQualifications(), qualifications)){
                counter++;
                this.view.addKeeperToTable(k);
            }
        }
        if(counter!=0){
            this.view.displayTable();
            return true;
        }
        return false;
    }
    
    public boolean searchGender(String gender){
        this.view.clearTable();
        int counter = 0;
        for(ZooKeeper k : keepers){
            if(k.getGender().equalsIgnoreCase(gender)){
                this.view.addKeeperToTable(k);
            } 
        }
        if(counter!=0){
            this.view.displayTable();
            return true;
        }
        return false;
    }
    
    public boolean searchName(String name){
        this.view.clearTable();
        int counter = 0;
        for(ZooKeeper k : keepers){
            if(k.getName().toUpperCase().contains(name.toUpperCase())){
                counter++;
                this.view.addKeeperToTable(k);
            }
        }
        if(counter!=0){
            this.view.displayTable();
            return true;
        }
        return false;
    }

    public boolean searchNumberOfAnimals(int from, int to) {
        this.view.clearTable();
        int counter = 0;
        for(ZooKeeper k : keepers){
            if(k.getAnimals().size() >= from && k.getAnimals().size() <= to){
                counter++;
                this.view.addKeeperToTable(k);
            }
        }
        if(counter!=0){
            this.view.displayTable();
            return true;
        }
        return false;
    }
    
    public boolean searchSpecies(String specie){
        this.view.clearTable();
        List<ZooKeeper> uniques = new ArrayList<>();
        for(ZooKeeper k : keepers){
            for(Animal a : k.getAnimals()){
                if(a.getSpecies().equalsIgnoreCase(specie) && !uniques.contains(k)){
                    uniques.add(k);
                    break;
                }            
            }
        }
        if(!uniques.isEmpty()){
            for(ZooKeeper z : uniques){
                this.view.addKeeperToTable(z);
            }
            this.view.displayTable();
            return true;
        }
        return false;        
    }
    

}
