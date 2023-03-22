package ru.gb.perov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")

public class ProductController {

    @Autowired
    private ProductRepositiry productRepositiry;

    @GetMapping("/all")
    public String getProducts(Model model) {
        List<Product> products = productRepositiry.findAll();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/{id}")
    public String getProduct(@PathVariable Long id, Model model) {
        List<Product> products = new ArrayList<>();
        products.add(productRepositiry.findById(id));
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/add")
    public String addProductGet(Model model) {
        Product newProduct = new Product();
        model.addAttribute("productForm", newProduct);
        return "addNewProduct";
    }

    @PostMapping("/add")
    public String addProductsPost(@ModelAttribute("productForm") Product newProduct, Model model) {
        productRepositiry.addProduct(newProduct.getTitle(), newProduct.getCost());
        List<Product> products = productRepositiry.findAll();
        model.addAttribute("products", products);
        return "products";
    }
}