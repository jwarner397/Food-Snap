package org.rebootu.jwarner.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Joseph on 6/19/2015.
 */
@Entity
@Table(name = "ingredients")
public class Ingredient extends AbstractEntity implements Serializable {
    private String name;
    // private int ownerId;

    public Ingredient(String name, int ownerId){
        this.name = name;
        // this.ownerId = ownerId;
    }

    public Ingredient(){}

    @Column(name = "name")
    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*@Column(name = "ownerId", nullable = false)
    public int getOwnerId() {
        return this.ownerId;
    }*/



}



