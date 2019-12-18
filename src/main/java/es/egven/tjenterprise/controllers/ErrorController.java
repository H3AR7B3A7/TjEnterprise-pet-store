package es.egven.tjenterprise.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ERROR CONTROLLER
 *
 * @author Egven
 */
@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    /**
     * @return Get 404 page
     */
    @GetMapping({"products/error", "/error"})
    public String handleError() {
        return "404";
    }

    /**
     * @return Catch error with override
     */
    @Override
    public String getErrorPath() {
        return "error";
    }
}
