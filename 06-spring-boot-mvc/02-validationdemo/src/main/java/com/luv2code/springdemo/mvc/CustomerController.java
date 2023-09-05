package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer()); // (name ที่จะให้ view เรียกใช้, value)

        return "customer-form";
    }
}
