package es.egven.tjenterprise.controllers;

import es.egven.tjenterprise.model.Product;
import es.egven.tjenterprise.model.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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
     * @return All products
     */
    @ModelAttribute("allProducts")
    public Iterable<Product> showAllProducts(){
        return dao.findAll();
    }

    /**
     * Mapping for home page
     * @return home page
     * ps: removed 'ModelMap map' as parameter...
     */
    @GetMapping(value = {"","/","/index"})
    public String showIndex(){
        return "index";
    }

    @ModelAttribute("productFilerDier")
    public Iterable<Product> showProductCategorieDier(){
        return dao.findByCategorieDier("Dier");
    }
    @ModelAttribute("productFilterToy")
    public Iterable<Product> showProductCategorieToy(){
        return dao.findByCategorieDier("Toy");
    }
    @ModelAttribute("productFilterFood")
    public Iterable<Product> showProductCategorieFood(){
        return dao.findByCategorieDier("Food");
    }
    @ModelAttribute("productFilterHabitat")
    public Iterable<Product> showProductCategorieHabitat(){
        return dao.findByCategorieDier("Habitat");
    }

}

