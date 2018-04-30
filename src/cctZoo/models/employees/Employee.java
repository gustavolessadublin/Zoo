/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.models.employees;

import cctZoo.models.Model;

/**
 * This abstract class represents a generic Employee and will be extended by
 * the concrete ones, such as ZooKeeper.
 * @author rbsrafa
 * @author Gustavo Lessa
 */
public abstract class Employee extends Model{
    private static int lastId;
    private String name;
    private String gender;
    
    public Employee(String gender) {
        super(++lastId);
        this.gender = gender;
    }
    
    public Employee(String gender, String name) {
        super(++lastId);
        this.gender = gender;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    
    
    
}
