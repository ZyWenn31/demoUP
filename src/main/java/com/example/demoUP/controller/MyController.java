package com.example.demoUP.controller;

import com.example.demoUP.model.User;
import com.example.demoUP.service.ProductService;
import com.example.demoUP.service.SupplierService;
import com.example.demoUP.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/shoes")
public class MyController {
    private final UserService userService;
    private final ProductService productService;
    private final SupplierService supplierService;

    public MyController(UserService userService, ProductService productService, SupplierService supplierService) {
        this.userService = userService;
        this.productService = productService;
        this.supplierService = supplierService;
    }

    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("user", new User());
        return "loginPage";
    }

    @PostMapping("/login")
    public String loginPageSuccess(@ModelAttribute User user){
        if (userService.userSearched(user.getLogin(), user.getPasswordPlain())){
            return "redirect:/shoes/items/all";
        }
        return "loginPage";
    }

    @GetMapping("/items/{supplier}")
    public String allItemsPage(Model model, @PathVariable("supplier") String suplier){
        if (suplier.equals("all")){
            model.addAttribute("items", productService.getAll());
        } else {
            model.addAttribute("items", productService.getBySupplier(supplierService.getByName(suplier)));
        }

        model.addAttribute("suppliers", supplierService.getAll());
        return "allItems";
    }
}
