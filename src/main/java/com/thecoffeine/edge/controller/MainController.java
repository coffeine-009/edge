package com.thecoffeine.edge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Main controller.
 *
 * @version 1.0
 */
@Controller
@RequestMapping( "/" )
public class MainController {

    @RequestMapping( method = RequestMethod.GET )
    public String indexAction() {
        return "index";
    }

    @RequestMapping( value = "**", method = RequestMethod.GET )
    public String homeAction() {
        return "home";
    }
}
