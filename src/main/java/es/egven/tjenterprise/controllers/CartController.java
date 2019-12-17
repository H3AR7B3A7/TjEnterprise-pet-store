package es.egven.tjenterprise.controllers;

import es.egven.tjenterprise.model.Cart;
import es.egven.tjenterprise.model.Product;
import es.egven.tjenterprise.model.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * CART CONTROLLER
 * @author Egven
 */
@Controller
public class CartController {

    @Autowired
    ProductDAO dao;

    /**
     * Model attribute for Product
     * @return Product()
     */
    @ModelAttribute("nProduct")
    public Product productToAdd(){
        return new Product();
    }

    /**
     * Add a product to cart
     * @param id
     * @return Home page, to keep adding to cart
     */
    @GetMapping(value = "/{id}")
    public String addProductToCart(@PathVariable(value = "id") int id){
        Product nProduct = dao.findById(id).get();
        Cart.addItemToCart(nProduct);
        return "redirect:/index";
    }
}
