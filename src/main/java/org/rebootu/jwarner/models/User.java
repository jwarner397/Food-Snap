package org.rebootu.jwarner.models;

import org.rebootu.jwarner.models.util.PasswordHash;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joseph on 6/1/2015.
 */
@Entity
@Table(name = "users")
public class User extends AbstractEntity {
    private String userName;
    private String hash;

    /**
     * ingredients in user's pantry
     */
    private ArrayList<Ingredient> pantryList;


    public User(String userName, String password) {
        this.hash = PasswordHash.getHash(password);
        this.userName = userName;
        this.pantryList = new ArrayList<>();

    }

    // empty constructor so Spring can do its magic
    public User() {}

    @NotNull
    @Column(name = "username", unique = true, nullable = false)
    public String getUserName() {
        return userName;
    }

    protected void setUserName(String userName){
        this.userName = userName;
    }

    @NotNull
    @Column(name = "hash")
    public String getHash() {
        return hash;
    }

    protected void setHash(String hash) {
        this.hash = hash;
    }

    @Column(name = "list")
    public ArrayList<Ingredient> getPantryList() {
        return pantryList;
    }

    public void setPantryList(ArrayList<Ingredient> pantryList) {
        this.pantryList = pantryList;
    }

}
