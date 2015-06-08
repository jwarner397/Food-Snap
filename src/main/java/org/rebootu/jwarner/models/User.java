package org.rebootu.jwarner.models;

import org.rebootu.jwarner.models.util.PasswordHash;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Joseph on 6/1/2015.
 */
@Entity
@Table(name = "users")
public class User extends AbstractEntity {
    private String userName;
    private String hash;

    /**
     * A collection of all the recipes this user has received.
     */
    // private ArrayList recipeList;


    public User(String userName, String password) {
        this.hash = PasswordHash.getHash(password);
        this.userName = userName;
        // this.recipeList = new ArrayList();
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

    /* @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "owner_id")
    public ArrayList getRecipeList() {
        return recipeList;
    }

    private void setRecipeList(ArrayList recipeList) {
        this.recipeList = recipeList;
    }

    void addRecipe (Recipe recipe) throws IllegalArgumentException {

        // Ensure a holding for the symbol doesn't already exist
        if (recipeList.containsKey(recipe.getSymbol())) {
            throw new IllegalArgumentException("A holding for symbol " + recipe.getSymbol()
                    + " already exits for user " + getUid());
        }

        recipeList.put(recipe.getSymbol(), recipe);
    } */
}
