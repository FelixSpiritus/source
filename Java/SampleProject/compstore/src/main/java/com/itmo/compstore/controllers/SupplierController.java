package com.itmo.compstore.controllers;

import com.itmo.compstore.models.Supplier;
import com.itmo.compstore.services.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@RequiredArgsConstructor
@Controller
@RequestMapping("/stock/suppliers")
public class SupplierController {

    private final SupplierService supplierService;


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("suppliers", supplierService.findAll());
        return "stock/suppliers/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("supplier", supplierService.findOne(id));
        return "stock/suppliers/show";
    }

    @GetMapping("/new")
    public String newSupplier(@ModelAttribute("supplier") Supplier supplier) {
        return "stock/suppliers/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("supplier") @Valid Supplier supplier,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "stock/suppliers/new";
        }
        supplierService.save(supplier);
        return "redirect:/stock/suppliers";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("supplier", supplierService.findOne(id));
        return "stock/suppliers/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("supplier") @Valid Supplier supplier, BindingResult bindingResult,
                         @PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            return "stock/suppliers/edit";
        }
        supplierService.update(id, supplier);
        return "redirect:/stock/suppliers";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        try{
            supplierService.delete(id);
        } catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
        }

        return "redirect:/stock/suppliers";
    }
}