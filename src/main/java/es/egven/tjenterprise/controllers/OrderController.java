package es.egven.tjenterprise.controllers;

import es.egven.tjenterprise.model.Cart;
import es.egven.tjenterprise.model.Order;
import es.egven.tjenterprise.model.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ORDER CONTROLLER
 * @author dog.D
 */
@Controller
public class OrderController {

    @Autowired
    private OrderDAO dao;

    /**
     * Create NEW order with cart content
     * @param cart
     * @return checkout page
     */
    @GetMapping("/cart/order")
    public String createOrder(Cart cart){
        String orderContent = cart.toString();
        getOrderContent(orderContent);
        // TODO : figure out logic (need to save?)
        return "redirect:checkout";
    }

}
