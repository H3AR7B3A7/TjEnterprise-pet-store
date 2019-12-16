package es.egven.tjenterprise.controllers;

import es.egven.tjenterprise.model.Cart;
import es.egven.tjenterprise.model.Order;
import es.egven.tjenterprise.model.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class OrderController {

    @Autowired
    private OrderDAO dao;

    @GetMapping("/cart/order")
    public String createOrder(){
        Order order = new Order();
        // TODO : add logic to add cart to order and save
            order.getOrderContent(Cart.toString());
        return "redirect:checkout";
    }

}
