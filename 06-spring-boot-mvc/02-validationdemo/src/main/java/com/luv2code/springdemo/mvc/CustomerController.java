package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer()); // (name ที่จะให้ view เรียกใช้, value)

        return "customer-form";
    }

    // @Valid ทำให้ spring mvc ตรวจสอบความถูกต้องของข้อมูล
    // @ModelAttribute อ่านข้อมูลแบบฟอร์มจาก th:object
    // BindingResult เก็บผลลัพธ์จากการทำ validation,
    // ถ้าหากทุกอย่างถูกต้องจะมีข้อมูลนั้น
    @PostMapping("/processForm")
    public String proceString(
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "customer-form";
        }

        return "customer-confirmation";
    }
}
