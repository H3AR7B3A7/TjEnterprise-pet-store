package es.egven.tjenterprise.controllers;

import es.egven.tjenterprise.model.Cart;
import es.egven.tjenterprise.model.CartDAO;
import es.egven.tjenterprise.model.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * PRODUCT CONTROLLER
 *
 * @author d.Dog
 */
@Controller
public class CartController {

    /**
     * Made dao private
     */
    @Autowired
    private CartDAO dao;

    /**
     * Call dao to get public data
     * @return Dao for Cart
     */
    public CartDAO getDao(){
        return dao;
    }

    /**
     * Add attribute cartId to map
     * @param model
     * @return cart
     */
    @RequestMapping("cart/getCartById")
    public String getCartId(Model model){
        model.addAttribute("cartId");
        return "cart";
    }

    /**
     * Fetch CartItems
     * @param cartId
     * @return Gets CartItems in cart by cartId
     */
    @RequestMapping("cart/{cartId}")
    public @ResponseBody
    Cart getCartItems(@PathVariable(value = "cartId")String cartId){
        return getCartItems(cartId);
    }

}
