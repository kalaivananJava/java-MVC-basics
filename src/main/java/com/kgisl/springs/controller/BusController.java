package com.kgisl.springs.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.kgisl.springs.entity.*;
import com.kgisl.springs.service.BusService;

@Controller
@RequestMapping("/customer")
public class BusController{
    
    @Autowired
    private BusService busService;
    
    @GetMapping("/list")
    public String listCustomers(Model model){
        List<Bus> list=busService.getBus();
        model.addAttribute("customers", list);
        return "display";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        Bus theCustomer = new Bus();
        theModel.addAttribute("customer", theCustomer);
        return "index";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Bus theCustomer) {
        System.out.println(theCustomer);
        if (theCustomer.getId()==0){
        busService.saveBus(theCustomer);}
        else{
            busService.updateBus(theCustomer);
        }
        return "redirect:/customer/list";
    }

    

}