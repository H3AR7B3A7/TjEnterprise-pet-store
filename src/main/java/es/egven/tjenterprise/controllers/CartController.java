package es.egven.tjenterprise.controllers;

import es.egven.tjenterprise.model.CartDAO;
import es.egven.tjenterprise.model.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CartController {

    @Autowired
    CartDAO dao;
}
