package ru.gb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gb.source.Product;
import ru.gb.source.ProductRepository;

@Controller
@RequestMapping("/")
public class HelloController {
    private final ProductRepository products;



    public HelloController(ProductRepository repository) {
        this.products = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        model.addAttribute("message", "Spring 3 MVC - Hello World");
        return "index";

    }
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("products", products.findAll());
        return "products";
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("product", new Product());
        return "products-add";
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.POST)
    public String add(@ModelAttribute ("product") Product product) {

        products.add(product);
        return "products";
    }
}