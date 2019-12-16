package es.egven.tjenterprise.controllers;

import es.egven.tjenterprise.model.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CartController {

    @Autowired
    ProductDAO dao;
}
