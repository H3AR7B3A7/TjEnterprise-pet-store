package es.egven.tjenterprise.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * CHECKOUT CONTROLLER
 * @author Egven
 */
@Controller
public class CheckoutController {

    /**
     * Mapping for checkout page
     * @return Checkout page
     */
    @GetMapping(value = "/checkout")
    public String showCheckout(){
        return "checkout";
    }

    // TODO: Check why checkout is not showing
}
