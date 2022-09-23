package com.itmo.compstore.controllers;


import com.itmo.compstore.models.Storage;
import com.itmo.compstore.services.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequiredArgsConstructor
@Controller
@RequestMapping("/directories/storages")
public class StorageController {

    private final StorageService storageService;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("storages", storageService.findAll());
        return "directories/storages/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("storage", storageService.findOne(id));
        return "directories/storages/show";
    }

    @GetMapping("/new")
    public String newStorage(@ModelAttribute("storage") Storage storage) {
        return "directories/storages/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("storage") @Valid Storage storage,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "directories/storages/new";

        storageService.save(storage);
        return "redirect:/directories/storages";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("storage", storageService.findOne(id));
        return "directories/storages/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("storage") @Valid Storage storage, BindingResult bindingResult,
                         @PathVariable("id") Integer id) {
        if (bindingResult.hasErrors()) {
            return "directories/storages/edit";
        }
        storageService.update(id, storage);
        return "redirect:/directories/storages";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Integer id) {
        try {
            storageService.delete(id);
        } catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
        }
        return "redirect:/directories/storages";
    }
}