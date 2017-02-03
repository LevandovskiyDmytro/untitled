package ua.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import ua.editor.CategoryEditor;
import ua.entities.Category;
import ua.entities.Commodity;
import ua.service.CategoryService;
import ua.service.CommodityService;
import ua.validator.adminValidator.AdminValidationMessages;

@Controller
public class CommodityController {

    @Autowired
    CommodityService commodityService;
    
    @Autowired
    CategoryService categoryService;
    
    @RequestMapping(value ="/admin/adminCommodity",method = RequestMethod.GET)
    public String newCommodity(Model model){
        model.addAttribute("commodities", commodityService.findAll());
        model.addAttribute("commodity",new Commodity());
        model.addAttribute("categories", categoryService.findAll());
        return "adminCommodity";
    }

    @RequestMapping(value = "/admin/saveCommodity", method = RequestMethod.POST)
    public String saveCommodity(@ModelAttribute Commodity commodity, @RequestParam MultipartFile commodityImage,Model model ) throws Exception {
//        try {
//            commodityService.save(commodity, commodityImage);
//        }catch (Exception e){
//            if(e.getMessage().equals(AdminValidationMessages.EMPTY_MODEL_FIELD)||
//                    e.getMessage().equals(AdminValidationMessages.EMPTY_PRICE_FIELD)){
//                model.addAttribute("commodityException", e.getMessage());
//
//            }
//        }
        commodityService.save(commodity, commodityImage);

        return "redirect:/admin/adminCommodity";
    }


    @RequestMapping(value = "/deleteCommodity/{id}", method = RequestMethod.GET)
    public String deleteByCommodityId(@PathVariable String id) {
    	commodityService.delete(Integer.parseInt(id));
        return "redirect:/admin/adminCommodity";
    }
}
