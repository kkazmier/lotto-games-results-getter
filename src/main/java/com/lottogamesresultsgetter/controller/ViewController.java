package com.lottogamesresultsgetter.controller;

import com.lottogamesresultsgetter.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    private final Logger logger = LoggerFactory.getLogger(ViewController.class);

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("Lotto", new Result());
        model.addAttribute("MiniLotto", new Result());
        model.addAttribute("MultiMulti", new Result());
        model.addAttribute("Kaskada", new Result());
        model.addAttribute("Eurojackpot", new Result());
        //model.addAttribute("Lotto", "Lotto");
        logger.info("Attr: " + model.getAttribute("Lotto").toString());
        return "home";
    }


}
