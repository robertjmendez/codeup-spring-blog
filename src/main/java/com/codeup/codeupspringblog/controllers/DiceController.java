package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String showDicePage() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String rollDice(@PathVariable int n, Model model) {
        int diceRoll = (int) (Math.random() * 6) + 1;
        boolean isCorrect = n == diceRoll;

        model.addAttribute("diceRoll", diceRoll);
        model.addAttribute("guess", n);
        model.addAttribute("isCorrect", isCorrect);

        return "roll-result";
    }
}
