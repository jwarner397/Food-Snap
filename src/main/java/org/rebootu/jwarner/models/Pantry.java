package org.rebootu.jwarner.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

/**
 * Created by Joseph on 6/16/2015.
 */
/* @Entity
@Table(name = "pantrys")
public class Pantry extends AbstractEntity {
    private int ownerID;
    // private ArrayList<String> ingredientList;

    public Pantry (int ownerID, ArrayList<String> ingredientList){
        this.ownerID = ownerID;
        // this.ingredientList = ingredientList;
    }

    // empty constructor so Spring can do its magic
    public Pantry() {}

    // @NotNull
    @Column(name = "ownerId", unique = true, nullable = false)
    public int getOwnerID() {
        return ownerID;
    }

    protected void setOwnerID(int ownerID){
        this.ownerID = ownerID;
    }

    /* @Column(name = "list")
    public ArrayList<String> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(ArrayList<String> ingredientList){
        this.ingredientList = ingredientList;
    }*/


// }
