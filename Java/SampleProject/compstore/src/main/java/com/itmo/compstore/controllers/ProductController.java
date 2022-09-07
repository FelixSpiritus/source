package com.itmo.compstore.controllers;

import com.itmo.compstore.models.Product;
import com.itmo.compstore.services.ProductGroupService;
import com.itmo.compstore.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/directories/products")
public class ProductController {

    private final ProductService productService;
    private final ProductGroupService productGroupService;


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("products", productService.findAll());
        return "directories/products/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", productService.findOne(id));
        model.addAttribute("productGroup",
                productGroupService.findOne(productService.findOne(id).getProductGroup().getId()));
        return "directories/products/show";
    }

    @GetMapping("/new")
    public String newProduct(@ModelAttribute("product") Product product, Model model) {
        model.addAttribute("productGroups", productGroupService.findAll());
        return "directories/products/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("product") @Valid Product product,
                         BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("productGroups", productGroupService.findAll());
            return "directories/products/new";
        }
        productService.save(product);
        return "redirect:/directories/products";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("product", productService.findOne(id));
        model.addAttribute("productGroups", productGroupService.findAll());
        return "directories/products/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult,
                         @PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("productGroups", productGroupService.findAll());
            return "directories/products/edit";
        }
        productService.update(id, product);
        return "redirect:/directories/products";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        try{
            productService.delete(id);
        } catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
        }

        return "redirect:/directories/products";
    }
}
