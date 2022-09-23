package com.itmo.compstore.controllers;

import com.itmo.compstore.models.StorageItems;
import com.itmo.compstore.models.Supply;
import com.itmo.compstore.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequiredArgsConstructor
@Controller
@RequestMapping("/stock/supplies")
public class SupplyController {

    private final SupplyService supplyService;
    private final ProductService productService;

    private final SupplierService supplierService;

    private final RegistrationService registrationService;
    private final StorageService storageService;
    private final StorageItemService storageItemService;




    @GetMapping()
    public String index(Model model) {
        model.addAttribute("supplies", supplyService.findAll());
        return "stock/supplies/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("supply", supplyService.findOne(id));
        return "stock/supplies/show";
    }

    @GetMapping("/new")
    public String newSupply(@ModelAttribute("supply") Supply supply,
                            @ModelAttribute("storageItem") StorageItems storageItem,
                            Model model) {
        model.addAttribute("products", productService.findAll());
        model.addAttribute("suppliers", supplierService.findAll());
        model.addAttribute("people", registrationService.findAll());
        model.addAttribute("storages", storageService.findAll());
        return "stock/supplies/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("supply") @Valid Supply supply,
                         BindingResult bindingResult,
                         @ModelAttribute("storageItem") @Valid StorageItems storageItem,
                         BindingResult bindingResult2,
                         Model model) {
        if (bindingResult.hasErrors()||bindingResult2.hasFieldErrors("storage")) {
            model.addAttribute("products", productService.findAll());
            model.addAttribute("suppliers", supplierService.findAll());
            model.addAttribute("people", registrationService.findAll());
            model.addAttribute("storages", storageService.findAll());
            return "stock/supplies/new";
        }
        storageItem.setSupply(supply);
        storageItem.setQtyinstorage(supply.getQuantity());
        supplyService.save(supply);
        storageItemService.save(storageItem);
        return "redirect:/stock/supplies";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("supply", supplyService.findOne(id));
        model.addAttribute("products", productService.findAll());
        model.addAttribute("suppliers", supplierService.findAll());
        model.addAttribute("people", registrationService.findAll());
        return "stock/supplies/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("supply") @Valid Supply supply,
                         BindingResult bindingResult,
                         @PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("products", productService.findAll());
            model.addAttribute("suppliers", supplierService.findAll());
            model.addAttribute("people", registrationService.findAll());
            return "stock/supplies/edit";
        }
        supplyService.update(id, supply);
        return "redirect:/stock/supplies";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        try{
            supplyService.delete(id);
        } catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
        }

        return "redirect:/stock/supplies";
    }
}