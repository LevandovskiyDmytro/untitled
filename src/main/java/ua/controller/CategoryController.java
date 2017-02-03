package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.editor.CategoryEditor;
import ua.entities.Category;
import ua.service.CategoryService;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    
    @InitBinder("category")  
    protected void initBinder(WebDataBinder binder){
    binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
    }

    
    
    @RequestMapping(value ="/admin/adminCategory",method = RequestMethod.GET)
    public String newCategory(Model model){
        model.addAttribute("categories",categoryService.findCategoryWithCommodities());
        model.addAttribute("category", new Category());
        return "adminCategory";
    }
    

    @RequestMapping(value = "/admin/saveCategory", method = RequestMethod.POST)
    public String saveCategory(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/admin/adminCategory";
    }


    @RequestMapping(value = "/deleteCategory/{id}", method = RequestMethod.GET)
    public String deleteCategory(@PathVariable String id) {
        categoryService.deleteById(Integer.parseInt(id));
        return "redirect:/admin/adminCategory";
    }
    
    @RequestMapping(value="/deleteCommodityFromCategory/{idCommodity}")
    public String deleteCommodityFromCategory(@PathVariable String idCommodity){
    	
    	categoryService.deleteCommodityFromCategory(idCommodity);
    	
    	return "redirect:/admin/adminCategory";
    }

   	


}
