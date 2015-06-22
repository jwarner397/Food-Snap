package org.rebootu.jwarner.controllers;

import org.rebootu.jwarner.models.Ingredient;
import org.rebootu.jwarner.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by Joseph on 6/19/2015.
 */
@Controller
public class RecipeController extends AbstractController {

    @RequestMapping(value = "/displayRecipes", method = RequestMethod.GET)
    public String getRecipes(HttpServletRequest request, Model model){
        // bring user into scope
        User user = getUserFromSession(request);
        ArrayList<Ingredient> ingredients;

        // get user's ingredient list
        try{
            ingredients = user.getPantryList();
        } catch (NullPointerException e) {
            e.printStackTrace();
            return displayError("You have not chosen any Pantry items yet!", model);
        }

        String csvList = null;

        for(int i = 0; i < ingredients.size(); i++) {
            csvList = csvList + ingredients.get(i).getIngredientName() + ", ";

        }

        // cast ingredient array to string for API call



        return null;
    }
}
