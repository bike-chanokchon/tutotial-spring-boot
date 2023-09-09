package com.luv2code.springdemo.mvc;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // add an initBinder ... to convert trim input strings
    // remove leading and traling whitespace
    // resolve issue for our validation
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(false);

        dataBinder.registerCustomEditor(String.class, "lastName", stringTrimmerEditor);
    }


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
    public String proceString(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
        
        System.out.println("First name: |" + customer.getFirstName() + "|");
        System.out.println("Last name: |" + customer.getLastName() + "|");
        System.out.println("Binding result: " + bindingResult.toString());
    
        if (bindingResult.hasErrors()) {
            return "customer-form";
        }

        return "customer-confirmation";
    }
}
