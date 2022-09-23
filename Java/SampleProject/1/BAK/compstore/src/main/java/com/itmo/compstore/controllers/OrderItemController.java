package com.itmo.compstore.controllers;

import com.itmo.compstore.models.OrderItems;
import com.itmo.compstore.models.Orders;
import com.itmo.compstore.models.ProductGroups;
import com.itmo.compstore.models.SalesView;
import com.itmo.compstore.services.OrderItemService;
import com.itmo.compstore.services.OrderService;
import com.itmo.compstore.services.ProductGroupService;
import com.itmo.compstore.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/sales/orderitems")
public class OrderItemController {

    private final ProductService productService;
    private final OrderItemService orderItemService;

    private final ProductGroupService productGroupService;
    private final OrderService orderService;


    @GetMapping("/new/{id}")
    public String newOrderItems(@PathVariable("id") Long id,
                                @ModelAttribute("orderItm") OrderItems orderItem,
                                @ModelAttribute("productGr") ProductGroups productGroup,
                                Model model) {
        model.addAttribute("order", orderService.findOne(id));
        model.addAttribute("productGroups", productGroupService.findAll());
        model.addAttribute("productsInStock", productService.findProductsInStock());
        model.addAttribute("soldProducts", orderService.findSoldProductsOrder(id));
        model.addAttribute("orderSum", orderService.findOrderSum(id));
        return "sales/orderitems/new";
    }

    @GetMapping("/new/{id}/{pgid}")
    public String newOrderItemsGroup(@PathVariable("id") Long id, @PathVariable("pgid") Long pgid,
                                     @ModelAttribute("orderItm") OrderItems orderItem,
                                     Model model) {
        model.addAttribute("order", orderService.findOne(id));
        model.addAttribute("productGr", productGroupService.findOne(pgid));
        model.addAttribute("productGroups", productGroupService.findAll());
        model.addAttribute("productsInStock", productService.findProductsInStockGroup(pgid));
        model.addAttribute("soldProducts", orderService.findSoldProductsOrder(id));
        model.addAttribute("orderSum", orderService.findOrderSum(id));
        return "sales/orderitems/new";
    }
    @PostMapping("/new/{id}")
    public String addItem(@ModelAttribute("orderItm") OrderItems orderItem, @PathVariable("id") Long id) {
        orderItemService.add(orderItem);
        return "redirect:/sales/orderitems/new/"+id;
    }
    @PostMapping("/remove/{id}/{oiid}")
    public String removeItem(@PathVariable("id") Long id,
                             @PathVariable("oiid") Long oiid){
        orderItemService.remove(orderItemService.findOne(oiid));
        return "redirect:/sales/orderitems/new/"+id;
    }


}
