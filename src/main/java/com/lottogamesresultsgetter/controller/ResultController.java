package com.lottogamesresultsgetter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lottogamesresultsgetter.client.LottoClient;
import com.lottogamesresultsgetter.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ResultController {
    private final Logger logger = LoggerFactory.getLogger(ResultController.class);

    private LottoClient lottoClient;

    @Autowired
    public ResultController(LottoClient lottoClient) {
        this.lottoClient = lottoClient;
    }

    @GetMapping("getLastResult/{gameType}")
    public String getLastResult(@PathVariable("gameType") String gameType, Model model) throws JsonProcessingException {
        logger.info("getLastResult");
        Result result = lottoClient.getLastResult(gameType);
        logger.info(result.toString());
        model.addAttribute("Lotto", new Result());
        model.addAttribute("MiniLotto", new Result());
        model.addAttribute("MultiMulti", new Result());
        model.addAttribute("Kaskada", new Result());
        model.addAttribute("Eurojackpot", new Result());
        model.addAttribute(gameType, result);

//        switch (gameType) {
//            case "Lotto": return "Lotto";
//            default: return "home";
//        }
        return "home";
    }
}
