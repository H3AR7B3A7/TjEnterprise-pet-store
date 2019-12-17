package es.egven.tjenterprise.controllers;

import es.egven.tjenterprise.model.Product;
import es.egven.tjenterprise.model.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class IndexController {

    @Autowired
    ProductDAO dao;

    @ModelAttribute("allProducts")
    public Iterable<Product> showAllProducts(){
        return dao.findAll();
    }

    @RequestMapping(value = {"","/","/index"}, method = RequestMethod.GET)
    public String showIndex(ModelMap map){
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

