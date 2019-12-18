package es.egven.tjenterprise.controllers;

import es.egven.tjenterprise.exceptions.ResourceNotFoundException;
import es.egven.tjenterprise.model.Cart;
import es.egven.tjenterprise.model.Product;
import es.egven.tjenterprise.model.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
        Optional<Product> optional = dao.findById(id);
        if(optional.isPresent()){
            Cart.addItemToCart(optional.get());
            return "redirect:/index";
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @GetMapping(value = "/del{id}")
    public String removeProductFromCart(@PathVariable(value = "id") int id){
        // TODO : Find a specific product in list to delete it
        return "redirect:/index";
    }

    @GetMapping(value = "/del")
    public String clearCart(){
        // TODO : Find a way to clear list
        return "redirect:/index";
    }
}
