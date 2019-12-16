package es.egven.tjenterprise.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * CART CONTROLLER
 * @author d.Dog
 */
@Controller
public class CartController {
    @GetMapping(value = {"/cart"})
    public String showCart(ModelMap map){
        return "cart";
    }
}
