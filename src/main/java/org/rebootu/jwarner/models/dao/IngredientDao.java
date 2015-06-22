package org.rebootu.jwarner.models.dao;

import org.rebootu.jwarner.models.Ingredient;

import org.rebootu.jwarner.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joseph on 6/15/2015.
 */

@Transactional
@Repository
public interface IngredientDao extends CrudRepository<Ingredient, Integer> {

    Ingredient findByName(String ingredientName);

    ArrayList<Ingredient> findAll();
}
