package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.entities.Commodity;
import ua.service.CategoryService;
import ua.service.CommodityService;

@Controller
public class HomeController {

    @Autowired
    CommodityService commodityService;

    @Autowired
    CategoryService categoryService;

	@RequestMapping(value={ "/", "/home" }, method=RequestMethod.GET)
	public String home(Model model){
        model.addAttribute("commodities", commodityService.findAll());
        model.addAttribute("categories", categoryService.findAll());
		return "home";
	}
	
    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String loginprocesing(){
        return "redirect:/home";
    }

    @RequestMapping("/successOrder")
    public String showOrder() {
        return "successOrder";
    }

    @RequestMapping("/loginpage")
    public String login(){
    	return "loginpage";
    }
    
    @RequestMapping(value = "/logout" , method = RequestMethod.POST)
    public String logout(){
    	
    	return "redirect:/";
    }

    @RequestMapping(value = "/contactPage" , method = RequestMethod.GET)
    public String contactPage(){

        return "contactPage";
    }

    @RequestMapping(value = "/blog" , method = RequestMethod.GET)
    public String blog(){
        return "blog";
    }

    @PostMapping("/loginprocesing")
    public String log(@RequestParam String username){
        System.out.println(username);

        return null;
    }
    @RequestMapping(value={"/single{id}",}, method=RequestMethod.GET)
    public String single(Model model, @PathVariable int id){
        Commodity commodity = commodityService.findOne(id);
        model.addAttribute("commodity", commodity);
        return "single";
    }

}
