package es.egven.tjenterprise.controllers;

import es.egven.tjenterprise.model.Order;
import es.egven.tjenterprise.model.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OrderController {

    @Autowired
    private OrderDAO dao;

    @GetMapping("/order/{cartId}")
    public String createOrder(@PathVariable("cartId")int cartId){
        Order order = new Order();
        // TODO : add logic to add cart to order and save

        return "redirect:checkout?cartId="+ cartId;
    }


}
