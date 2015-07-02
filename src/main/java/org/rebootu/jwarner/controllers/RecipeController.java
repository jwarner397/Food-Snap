package org.rebootu.jwarner.controllers;

import org.rebootu.jwarner.models.Ingredient;
import org.rebootu.jwarner.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Joseph on 6/19/2015.
 */
@Controller
public class RecipeController extends AbstractController {

    @RequestMapping(value = "/displayRecipes", method = RequestMethod.GET)
    public String getRecipes(HttpServletRequest request, Model model){
        // bring user into scope
        User user = getUserFromSession(request);
        List<Ingredient> userIngredients;


        // get user's ingredient list
        try{
            userIngredients = user.getPantryList();
        } catch (NullPointerException e) {
            e.printStackTrace();
            return displayError("You have not chosen any Pantry items yet!", model);
        }

        String csvList = "";
        ListIterator<Ingredient> li = userIngredients.listIterator();
        while (li.hasNext()){

            // cast ingredient array to string for API call
            csvList = csvList + li.next().getName() + ", " ;

            // for testing only, take out at finish
            System.out.println(csvList);

        }

        // hit recipe API with csvList


        return null;
    }
}
