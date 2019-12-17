package es.egven.tjenterprise.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * CONTACT CONTROLLER
 * @author Egven
 */
@Controller
public class ContactController {

    /**
     * Mapping for contact page
     * @return contact page
     */
    @GetMapping(value = "/contact")
    public String showContactPage(){
        return "contact";
    }
}
