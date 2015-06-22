package org.rebootu.jwarner.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Created by Joseph on 6/19/2015.
 */
@Entity
@Table(name = "ingredients")
public class Ingredient extends AbstractEntity {
    private String ingredientName;
    private int idNumber;

    public Ingredient(String ingredientName, int idNumber){
        this.ingredientName = ingredientName;
        this.idNumber = idNumber;
    }

    public Ingredient(){}

    @Column(name = "name")
    public String getIngredientName(){
        return this.ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    @Column(name = "idNumber")
    public int getIdNumber() {
        return this.idNumber;
    }

    public void setIdNumber( int idNumber) {
        this.idNumber = idNumber;
    }






}



