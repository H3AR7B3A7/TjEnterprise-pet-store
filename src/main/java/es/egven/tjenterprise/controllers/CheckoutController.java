package es.egven.tjenterprise.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
