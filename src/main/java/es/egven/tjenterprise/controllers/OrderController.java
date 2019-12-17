package es.egven.tjenterprise.controllers;

import es.egven.tjenterprise.model.Cart;
import es.egven.tjenterprise.model.Order;
import es.egven.tjenterprise.model.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * ORDER CONTROLLER
 * @author dog.D
 */
@Controller
public class OrderController {

    @Autowired
    private OrderDAO dao;


    /**
     * Create a NEW order
     * @return new Order
     */
    @ModelAttribute(value = "nOrder")
    public Order OrderToSave(){
        return new Order();
    }

    /**
     * Add values to newly created Order
     */
    @PostMapping(value = "/cart")
    public String saveOrder(@ModelAttribute("nOrder") @Valid Order nOrder, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "cart";
        dao.save(nOrder);
        return "redirect:/checkout";
    }



}
