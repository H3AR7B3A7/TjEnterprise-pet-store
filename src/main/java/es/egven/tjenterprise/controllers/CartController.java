package es.egven.tjenterprise.controllers;

import es.egven.tjenterprise.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.math.BigDecimal;
import java.util.HashMap;

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

    @ModelAttribute(value = "nCart")
    public Cart createNewCart(){
        return new Cart(new HashMap<>(), new BigDecimal(0));
    }

    @GetMapping
    public Cart getCart(){
        .getCartContent();
        .getTotalPrice();
    }


}
