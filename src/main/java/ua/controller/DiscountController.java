package ua.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.entities.Discount;
import ua.service.DiscountService;

@Controller
public class DiscountController {

    @Autowired
    DiscountService discountService;

    @RequestMapping(value ="/newDiscount",method = RequestMethod.GET)
    public String newDiscount(Model model){
        model.addAttribute("discounts",discountService.findAll());
        return "newDiscount";
    }

    @RequestMapping(value = "/saveDiscount", method = RequestMethod.POST)
    public String saveDiscount(@RequestParam String discountName) {
        Discount discount = new Discount(discountName);
        discountService.save(discount);
        return "redirect:/newDiscount";
    }


    @RequestMapping(value = "/deleteDiscount/{id}", method = RequestMethod.GET)
    public String deleteDiscount(@PathVariable String id) {
    	discountService.deleteById(Integer.parseInt(id));
        return "redirect:/newDiscount";
    }
}
