package es.egven.tjenterprise.controllers;

import es.egven.tjenterprise.model.Cart;
import es.egven.tjenterprise.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * CART CONTROLLER
 * @author d.Dog
 */
@Controller
public class CartController {

    @ModelAttribute("nCart")
    public Cart winkelKarAanmaken() {
        return new Cart();
    }

    @GetMapping(value = "/cart")
    public String showCart(ModelMap map){
        return "cart";
    }

    @ModelAttribute("nProduct")
    public Product productToAdd(){
        return new Product();
    }

    @RequestMapping(value = "/cart", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("nProduct") @Valid Product nProduct, BindingResult bindingResult,
                             @ModelAttribute("nCart") Cart nCart){
        if(bindingResult.hasErrors()){
            return "contact";
        }
        Cart.addItemToCart(nProduct);
        return "cart";
    }

    @RequestMapping(method = RequestMethod.GET, value="/cart/list")
    @ResponseBody
    public ArrayList<Product> toonWinkelKar(){return Cart.cartContent;}

    @PostMapping(value = "/cart/add")
    public ResponseEntity addProductToCart(@RequestParam(value="naam") String naam,
                                            @RequestParam(value ="prijs") BigDecimal prijs){
        Product nProduct = new Product();
        nProduct.setNaam(naam);
        nProduct.setPrijs(prijs);
        Cart.addItemToCart(nProduct);

        return new ResponseEntity(HttpStatus.OK);
    }



    /*@GetMapping
    public Cart getCart(){
        nCart.getCartContent();
        nCart.getTotalPrice();
    }*/


}
