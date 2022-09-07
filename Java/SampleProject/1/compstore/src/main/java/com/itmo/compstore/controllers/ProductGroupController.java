package com.itmo.compstore.controllers;

import com.itmo.compstore.models.ProductGroups;
import com.itmo.compstore.repositories.ProductGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductGroupController {

    @Autowired
    private ProductGroupRepository productGroupRepository;

    @GetMapping("/productGroups")
    public String productGroup(Model model) {
        Iterable<ProductGroups> productGroups = productGroupRepository.findAll();
        model.addAttribute("productGroups", productGroups);
        return "productGroups";
    }

    @PostMapping("/productGroups")
    public String productGroupAdd(@RequestParam String title, @RequestParam String desc, Model model) {
        ProductGroups pg = new ProductGroups(title,desc);
        productGroupRepository.save(pg);
        Iterable<ProductGroups> productGroups = productGroupRepository.findAll();
        model.addAttribute("productGroups", productGroups);
        return "redirect:/productGroups";
    }
}
