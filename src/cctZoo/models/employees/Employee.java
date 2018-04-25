/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.models.employees;

import cctZoo.models.Model;

/**
 *
 * @author rbsrafa
 */
public abstract class Employee extends Model{
    private static int lastId;
    private String name;
    private String gender;
    
    public Employee(String gender) {
        super(++lastId);
        this.gender = gender;
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
