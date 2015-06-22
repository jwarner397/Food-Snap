package org.rebootu.jwarner.controllers;

import org.rebootu.jwarner.models.Ingredient;
import org.rebootu.jwarner.models.User;
import org.rebootu.jwarner.models.dao.IngredientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by Joseph on 6/2/2015.
 */
@Controller
public class PantryController extends AbstractController {

    @Autowired
    public IngredientDao ingredientDao;

    @RequestMapping(value = "/pantry")
    public String pantry(HttpServletRequest request, Model model){


        model.addAttribute("title", "Pantry");
        model.addAttribute("pantryNavClass", "active");

        return "pantry";
    }


    @RequestMapping(value = "/displayPantry", method = RequestMethod.POST)
    public String displayPantry(String pantryItems, HttpServletRequest request, Model model) {

        System.out.println(pantryItems);
        ArrayList<String> ingredientsChosen;
        ArrayList<Ingredient> ingredientList = new ArrayList<>();

        try {
            ingredientsChosen = new ArrayList<String>(Arrays.asList(pantryItems.split("\\s*,\\s*")));
        } catch(NullPointerException e) {
            e.printStackTrace();
            return displayError("You have not chosen any Pantry items yet!", model);
        }

        // test loop
        for (int t = 0; t < ingredientsChosen.size(); t++ ){
            System.out.println(ingredientsChosen.get(t));
        }

        // turn strings of chosen items into array of Ingredient objects
        int length = ingredientsChosen.size();
        for (int i = 0; i < length; i++){
            try {
                ingredientList.add(ingredientDao.findByName(ingredientsChosen.get(i)));
                System.out.println("8" + ingredientList.get(i).getName());
            } catch (NullPointerException e) {
                e.printStackTrace();
                return displayError("You have not chosen any Pantry items yet!", model);
            }
        }

        // save Array list as a pantry object
        User user = getUserFromSession(request);
        user.setPantryList(ingredientList);
        userDao.save(user);

            // pass data to template
        model.addAttribute("title", "My Pantry");
        model.addAttribute("recipeNavClass", "active");
        model.addAttribute("pantryList", ingredientList);
        return "pantry";
    }

    @RequestMapping(value = "/displayPantry", method = RequestMethod.GET)
    public String displayPantry(HttpServletRequest request, Model model) {

        User user = getUserFromSession(request);
        List<Ingredient> items;

        try {
            items = user.getPantryList();
        } catch (NullPointerException e) {
            e.printStackTrace();
            return displayError("You have not chosen any Pantry items yet!", model);
        }

        /* // for testing purposes, take out in final
        int length = items.size();
        for (int i = 0; i < length; i++){
            System.out.println(items.get(i));
        }*/

        // pass data to template
        model.addAttribute("title", "My Pantry");
        model.addAttribute("recipeNavClass", "active");
        model.addAttribute("pantryList", items);
        return "pantry";
    }

    @RequestMapping(value = "/buildPantry", method = RequestMethod.GET)
    public String buildPantry(HttpServletRequest request, Model model) {

        // get all ingredients from table
        ArrayList<Ingredient> allItems = ingredientDao.findAll();
        ArrayList<String> pantryItems = new ArrayList<String>();
        int length = allItems.size();
        for (int i = 0; i < length; i++){
            pantryItems.add(allItems.get(i).getName());

        }

        // testing loop
        /* for (int k = 0; k < length; k++) {
            System.out.println(pantryItems.get(k));
        } */


        // pass data to template
        model.addAttribute("title", "Pantry Items");
        model.addAttribute("recipeNavClass", "active");
        model.addAttribute("pantryItems", pantryItems);

        return "buildPantry";
    }





}