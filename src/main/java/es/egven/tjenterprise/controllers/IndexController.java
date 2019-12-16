package es.egven.tjenterprise.controllers;

import es.egven.tjenterprise.model.Product;
import es.egven.tjenterprise.model.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
