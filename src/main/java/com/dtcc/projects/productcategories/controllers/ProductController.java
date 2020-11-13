package com.dtcc.projects.productcategories.controllers;

import com.dtcc.projects.productcategories.models.Product;
import com.dtcc.projects.productcategories.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/")
    public String getIndexPage(Model model) {

        List<Product> productList=productService.showAll();

        model.addAttribute("products",productList);
        return "products/index";
    }

    @GetMapping(value = "/products/newproduct")
    public String newprod(Model model) {
        model.addAttribute("newproduct", new Product());
        return "products/newproduct";
    }

    @PostMapping(value = "/products/createproduct")
    public String CreateProduct(@ModelAttribute("newproduct") Product item) {
        productService.saveProduct(item);
        return "redirect:/";
    }
}
