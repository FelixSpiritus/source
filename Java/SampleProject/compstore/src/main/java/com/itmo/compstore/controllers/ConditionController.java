package com.itmo.compstore.controllers;


import com.itmo.compstore.models.Conditions;
import com.itmo.compstore.services.ConditionService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/directories/conditions")
public class ConditionController {

    private final ConditionService conditionService;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("conditions", conditionService.findAll());
        return "directories/conditions/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("condition", conditionService.findOne(id));
        return "directories/conditions/show";
    }

    @GetMapping("/new")
    public String newCondition(@ModelAttribute("condition") Conditions condition) {
        return "directories/conditions/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("condition") @Valid Conditions condition,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "directories/conditions/new";

        conditionService.save(condition);
        return "redirect:/directories/conditions";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("condition", conditionService.findOne(id));
        return "directories/conditions/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("condition") @Valid Conditions condition, BindingResult bindingResult,
                         @PathVariable("id") Integer id) {
        if (bindingResult.hasErrors()) {
            return "directories/conditions/edit";
        }
        conditionService.update(id, condition);
        return "redirect:/directories/conditions";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Integer id) {
        try {
            conditionService.delete(id);
        } catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
        }
        return "redirect:/directories/conditions";
    }
}
