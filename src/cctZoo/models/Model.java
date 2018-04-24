/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.models;


/**
 *
 * @author rbsrafa
 */
public abstract class Model {
    private final int id;
    
    public Model(int lastId){
        this.id = lastId;
    }

    public int getId() {
        return id;
    }

    @Override
    public abstract String toString();
}
