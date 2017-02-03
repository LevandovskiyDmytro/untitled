package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.entities.Delivery;
import ua.service.DeliveryService;

@Controller
public class DeliveryController {

    @Autowired
    DeliveryService deliveryService;

    @RequestMapping(value ="/admin/adminDelivery",method = RequestMethod.GET)
    public String newCategory(Model model){
        model.addAttribute("deliveries",deliveryService.findAll());
        return "adminDelivery";
    }

    @RequestMapping(value = "/admin/saveDelivery", method = RequestMethod.POST)
    public String saveDelivery(@RequestParam String deliveryName) {
        Delivery delivery = new Delivery(deliveryName);
        deliveryService.save(delivery);
        return "redirect:/admin/adminDelivery";
    }


    @RequestMapping(value = "/admin/deleteDelivery/{id}", method = RequestMethod.GET)
    public String deleteDelivery(@PathVariable String id) {
        deliveryService.deleteById(Integer.parseInt(id));
        return "redirect:/admin/adminDelivery";
    }
}
