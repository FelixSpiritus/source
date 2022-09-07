package com.itmo.compstore.controllers;

import com.itmo.compstore.models.ProductGroups;
import com.itmo.compstore.services.ProductGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequiredArgsConstructor
@Controller
@RequestMapping("/directories/productgroups")
public class ProductGroupController {


    private final ProductGroupService productGroupService;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("productGroups", productGroupService.findAll());
        return "directories/productgroups/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("productGroup", productGroupService.findOne(id));
        return "directories/productgroups/show";
    }

    @GetMapping("/new")
    public String newProductGroup(@ModelAttribute("productGroup") ProductGroups productGroup) {
                return "directories/productgroups/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("productGroup") @Valid ProductGroups productGroup,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "directories/productgroups/new";

        productGroupService.save(productGroup);
        return "redirect:/directories/productgroups";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("productGroup", productGroupService.findOne(id));
        return "directories/productgroups/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("productGroup") @Valid ProductGroups productGroup, BindingResult bindingResult,
                         @PathVariable("id") Long id) {
        if (bindingResult.hasErrors()) {
            return "directories/productgroups/edit";
        }
        productGroupService.update(id, productGroup);
        return "redirect:/directories/productgroups";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        try {
            productGroupService.delete(id);
        } catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
        }
        return "redirect:/directories/productgroups";
    }

}
