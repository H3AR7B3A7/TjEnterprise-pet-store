package es.egven.tjenterprise.controllers;

import es.egven.tjenterprise.model.Cart;
import es.egven.tjenterprise.model.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * CHECKOUT CONTROLLER
 * @author Egven
 */
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
        Cart.clearCart();
        return "checkout";
    }

    // TODO: Optional - Find way to show order in checkout without showing all orders to anyone?
    //  User DB would be useful
}
