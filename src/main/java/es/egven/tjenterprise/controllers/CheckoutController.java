package es.egven.tjenterprise.controllers;

import es.egven.tjenterprise.model.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckoutController {

    @Autowired
    OrderDAO dao;

    /**
     * Mapping for checkout page
     * @return Checkout page
     */
    @GetMapping(value = "/cart/checkout")
    public String showCheckout(){
        return "checkout";
    }

    // TODO : check fields before getting checkout
    //      get details from order for content dependant messages ...


}
