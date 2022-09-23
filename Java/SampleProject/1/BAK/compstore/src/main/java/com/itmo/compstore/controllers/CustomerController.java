package com.itmo.compstore.controllers;

import com.itmo.compstore.models.Customer;
import com.itmo.compstore.models.Product;
import com.itmo.compstore.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequiredArgsConstructor
@Controller
@RequestMapping("/sales/customers")
public class CustomerController {

    private final CustomerService customerService;


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "sales/customers/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("customer", customerService.findOne(id));
        return "sales/customers/show";
    }

    @GetMapping("/new")
    public String newCustomer(@ModelAttribute("customer") Customer customer, Model model) {
        return "sales/customers/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("customer") @Valid Customer customer,
                         BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "sales/customers/new";
        }
        customerService.save(customer);
        return "redirect:/sales/customers";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("customer", customerService.findOne(id));
        return "sales/customers/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("customer") @Valid Customer customer, BindingResult bindingResult,
                         @PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            return "sales/customers/edit";
        }
        customerService.update(id, customer);
        return "redirect:/sales/customers";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        try{
            customerService.delete(id);
        } catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
        }

        return "redirect:/sales/customers";
    }
}