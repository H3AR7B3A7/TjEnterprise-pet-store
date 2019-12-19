package es.egven.tjenterprise.controllers;

import es.egven.tjenterprise.model.Product;
import es.egven.tjenterprise.model.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * INDEX / MAIN CONTROLLER
 * @author Egven
 */
@Controller
public class IndexController {

    @Autowired
    ProductDAO dao;

    /**
     * Fetch an iterable list of all products
     *
     * @return All products
     */
    @ModelAttribute("allProducts")
    public Iterable<Product> showAllProducts() {
        return dao.findAll();
    }

    /**
     * Mapping for home page
     *
     * @return home page
     * ps: removed 'ModelMap map' as parameter...
     */
    @GetMapping(value = {"", "/", "/index"})
    public String showIndex() {
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/index/{productCategorie}")
    public String showFilteredProducts(ModelMap map, @PathVariable(value = "productCategorie") String productCategorie) {
        map.addAttribute("allProducts", dao.findByCategorie(productCategorie));
        return "index";
    }
}

