package org.rebootu.jwarner.controllers;

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

    @RequestMapping(value = "/pantry")
    public String portfolio(HttpServletRequest request, Model model){



        model.addAttribute("title", "Pantry");
        model.addAttribute("pantryNavClass", "active");

        return "pantry";
    }


    @RequestMapping(value = "/displayRecipes", method = RequestMethod.GET)
    public String quoteForm(HttpServletRequest request, Model model) {

            // pass data to template
            model.addAttribute("title", "Recipes");
            model.addAttribute("recipeeNavClass", "active");
            return "displayRecipes";
    }

    @RequestMapping(value = "/buildPantry", method = RequestMethod.GET)
    public String quote(HttpServletRequest request, Model model) {



        // pass data to template
        model.addAttribute("title", "Pantry Items");
        model.addAttribute("recipeNavClass", "active");

        return "buildPantry";
    }





}