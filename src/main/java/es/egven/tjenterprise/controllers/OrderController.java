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
 * @author Egven
 */
@Controller
public class OrderController {

    @Autowired
    private OrderDAO dao;

    /**
     * Model attribute for Cart
     * @return Cart()
     */
    @ModelAttribute("nCart")
    public Cart createNewCart() {
        return new Cart();
    }

    /**
     * Model attribute for Order
     * @return Order()
     */
    @ModelAttribute(value = "nOrder")
    public Order OrderToSave(){
        return new Order();
    }

    /**
     * Add values to newly created Order
     * @param nOrder
     * @param bindingResult
     * @return cart again, or checkout page
     */
    @PostMapping(value = "/cart")
    public String saveOrder(@ModelAttribute("nOrder") @Valid Order nOrder, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "cart";
        dao.save(nOrder);
        return "redirect:/cart/checkout";
    }

    /**
     * Mapping for cart page
     * @return cart page
     */
    @GetMapping(value = "/cart")
    public String showCart(){
        return "cart";
    }
}
