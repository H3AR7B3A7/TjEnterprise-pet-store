package es.egven.tjenterprise.controllers;

import es.egven.tjenterprise.model.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {

    @Autowired
    ProductDAO dao;

    @RequestMapping(value = "/contact")
    public String showContactPage(){
        return "contact";
    }
}
