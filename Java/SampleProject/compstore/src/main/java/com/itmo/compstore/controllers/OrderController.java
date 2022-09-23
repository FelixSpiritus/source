package com.itmo.compstore.controllers;

import com.itmo.compstore.models.*;
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
@RequestMapping("/sales/orders")
public class OrderController {

    private final RegistrationService registrationService;

    private final CustomerService customerService;
    private final OrderService orderService;
    private final ConditionService conditionService;
    private final ProductGroupService productGroupService;
    private final ProductService productService;

    private void createOrderModels(Model model) {
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("people", registrationService.findAll());
        model.addAttribute("conditions", conditionService.findAll());
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("orders", orderService.findAll());
        return "sales/orders/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("order", orderService.findOne(id));
        return "sales/orders/show";
    }

    @GetMapping("/new")
    public String newOrder(@ModelAttribute("order") Orders order, Model model) {
        createOrderModels(model);
        return "sales/orders/new";
    }


//
//    @GetMapping("/new/{id}")
//    public String newOrderGroupId(@PathVariable("id") Long id, @ModelAttribute("order") Orders order,
//                             @ModelAttribute("orderItem") OrderItems orderItem,
//                             @ModelAttribute("productGroup") ProductGroups productGroup,
//                             Model model) {
//        createOrderModels(model);
//        model.addAttribute("productsInStock", productService.findProductsInStockGroup(id));
//
//        return "sales/orders/new";
//    }
//
//    @GetMapping("/new/product/{id}")
//    public String newOrderProductId(@PathVariable("id") Long id, @ModelAttribute("order") Orders order,
//                             @ModelAttribute("orderItem") OrderItems orderItem,
//                             @ModelAttribute("productGroup") ProductGroups productGroup,
//                             Model model) {
//        createOrderModels(model);
//        model.addAttribute("productsInStock", productService.findProductsInStockProduct(id));
//
//        return "sales/orders/new";
//    }
    @PostMapping()
    public String create(@ModelAttribute("order") @Valid Orders order,
                         BindingResult bindingResult,
                         Model model) {
        if (bindingResult.hasErrors()){
            createOrderModels(model);
            return "sales/orders/new";
        }
        orderService.save(order);
        return "redirect:/sales/orderitems/new/"+order.getId();
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id,
                       @ModelAttribute("productGr") ProductGroups productGroup,
                        Model model) {
        model.addAttribute("order", orderService.findOne(id));
//        model.addAttribute("productGr", productGroupService.findAll());
        model.addAttribute("productGroups", productGroupService.findAll());
        model.addAttribute("productsInStock", productService.findProductsInStock());
        createOrderModels(model);
        return "sales/orders/edit";
    }
    @GetMapping("/{id}/edit/{pgid}")
    public String editF(@PathVariable("id") Long id, @PathVariable("pgid") Long pgid,
                       Model model) {
        model.addAttribute("order", orderService.findOne(id));
        model.addAttribute("productGr", productGroupService.findOne(pgid));
        model.addAttribute("productGroups", productGroupService.findAll());
        model.addAttribute("productsInStock", productService.findProductsInStockGroup(pgid));
        createOrderModels(model);
        return "sales/orders/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("order") @Valid Orders order, BindingResult bindingResult,
                         @PathVariable("id") Long id,
                         Model model) {
        if (bindingResult.hasErrors()) {
            createOrderModels(model);
            return "sales/orders/edit";
        }
        orderService.update(id, order);
        return "redirect:/sales/orderitems/new/"+order.getId();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        try{
            orderService.delete(id);
        } catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
        }

        return "redirect:/sales/orders";
    }
}
