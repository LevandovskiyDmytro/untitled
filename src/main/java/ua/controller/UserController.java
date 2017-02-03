package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.Dto.CommodityDTO;
import ua.Dto.DtoUtilMapper;
import ua.entities.User;
import ua.service.CommodityService;
import ua.service.MailSenderService;
import ua.service.UserService;
import ua.validator.userValidatorImpl.UserValidationMessagess;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@Controller
public class UserController {

	@Autowired
	private MailSenderService mailSenderService;

	@Autowired
	private UserService userService;

	@Autowired
	private CommodityService commodityService;
	
	@RequestMapping(value = "/registration")
	public String newUser(Model model) {
		model.addAttribute("userDTOs", DtoUtilMapper.usersToUsersDTO(userService.findAll()));
		model.addAttribute("user", new User());
		return "registration";
	}
	@RequestMapping(value ="/admin/adminUser", method = RequestMethod.GET)
	public String adminUser(Model model){
		model.addAttribute("userDTOs", DtoUtilMapper.usersToUsersDTO(userService.findAll()));
		return "adminUser";
	}

	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute User user,Model model) {
		String uuid = UUID.randomUUID().toString();

		user.setUuid(uuid);

		try {
			userService.save(user);
		} catch (Exception e) {
			if(e.getMessage().equals(UserValidationMessagess.EMPTY_USERNAME_FIELD)||
					e.getMessage().equals(UserValidationMessagess.NAME_ALREADY_EXISTS)||
					e.getMessage().equals(UserValidationMessagess.NAME_CONTAINS_SYMBOLS)){
				model.addAttribute("usernameException", e.getMessage());
			}else if(e.getMessage().equals(UserValidationMessagess.EMPTY_EMAIl_FIELD)||
					e.getMessage().equals(UserValidationMessagess.EMAIL_ALREADY_EXIST)||
					e.getMessage().equals(UserValidationMessagess.BAD_EMAIL)){
				model.addAttribute("emailException", e.getMessage());
			}else if(e.getMessage().equals(UserValidationMessagess.EMPTY_PASSWORD_FIELD)||
					e.getMessage().equals(UserValidationMessagess.BAD_PASSWORD)) {
				model.addAttribute("passwordException", e.getMessage());
			}/*else if(e.getMessage().equals(UserValidationMessagess.BAD_PHONE_NUMBER)||
					e.getMessage().equals(UserValidationMessagess.PHONE_ALREADY_EXIST)||
					e.getMessage().equals(UserValidationMessagess.EMPTY_PHONE_FIELD)){
				model.addAttribute("phoneException", e.getMessage());
			}*/
			return "registration";
		}

		String theme = "thanks for reg";
		String mailBody = "gl*hf http://localhost:8080/confirm/" + uuid;
		mailSenderService.sendMail(theme,mailBody, user.getEmail());

		return "redirect:/";
	}

	@RequestMapping(value = "/confirm/{uuid}", method = RequestMethod.GET)
	public String confirm(@PathVariable String uuid){
		User user = userService.findByUUID(uuid);
		user.setEnabled(true);
		userService.update(user);
		return "redirect:/";
	}
	@RequestMapping(value = "admin/deleteUser/{id}", method = RequestMethod.GET)
	public String newUser(@PathVariable String id) {
		userService.delete(Integer.parseInt(id));
		return "redirect:/admin/adminUser";
	}
	@RequestMapping(value = "/admin/updateUser/{id}", method = RequestMethod.GET)
	public String updateCustomer(@PathVariable String id, Model model){
		User user = userService.findById(Integer.parseInt(id));
		model.addAttribute("userForUpdate", user);

		return "updateUser";
	}
	@RequestMapping(value = "/admin/updateUser/saveUpdatedUser/{id}", method = RequestMethod.POST)
	public String update(@PathVariable String id, @RequestParam String newName, @RequestParam String newPhone, @RequestParam String newEmail, @RequestParam String newPassword) throws Exception {
		User user = userService.findById(Integer.parseInt(id));
		user.setName(newName);
		user.setEmail(newEmail);
		user.setPhone(newPhone);
		user.setPassword(newPassword);
		userService.save(user);
		return "redirect:/admin/adminUser";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(Principal principal, Model model) {
		User user = userService.findById(Integer.parseInt(principal.getName()));
		model.addAttribute("user", user);
		return "profile";
	}

//	@RequestMapping(value = "/saveImage", method =  RequestMethod.POST)
//	public String saveImage(Principal principal,@RequestParam MultipartFile image){
//		userService.saveImage(principal,image);
//		return "redirect:/profile";
//	}

	@RequestMapping(value = "/admin/orders", method = RequestMethod.GET)
	public String ordersPage(Model model){
		model.addAttribute("users", userService.findAll());
		model.addAttribute("commodities",commodityService.findAll());
		return "orders";
	}
	@RequestMapping(value = "/buyCommodity", method = RequestMethod.POST)
	public String getOrder(Principal principal, @RequestParam String commodityId){
		userService.getOrder(principal, commodityId);
		return "redirect:/home";
	}
//	@RequestMapping(value = "/buyCommodity", method = RequestMethod.POST)
//	public @ResponseBody List<CommodityDTO> buyCommodity(@RequestBody String commodityId, Principal principal){
//
//		User user = userService.findById(Integer.parseInt(principal.getName()));
//		Commodity commodity = commodityService.findOne(Integer.parseInt(commodityId));
//		List <Commodity> commodities = user.getCommodities();
//		commodities.add(commodity);
//		user.setCommodities(commodities);
//
//		return DtoUtilMapper.commoditiesToCommoditiesDTO(commodityService.findAll());
//	}

	@RequestMapping(value = "/loadCommodity", method = RequestMethod.POST)
	public @ResponseBody List<CommodityDTO> loadCommodity(){

		return DtoUtilMapper.commoditiesToCommoditiesDTO(commodityService.findAll());
	}




	@RequestMapping(value = "/deleteCommodityFromUser/{id}", method = RequestMethod.GET)
	public String deleteCommodityFromCustomer(Principal principal, @PathVariable String id){
		userService.deleteCommodityFromUser(principal, id);
		return "redirect:/profile";
	}

	@Transactional
	@RequestMapping(value = "/admin/delOrder/{id}", method = RequestMethod.GET)
	public String deleteOrder(@PathVariable String id){
		userService.findById(Integer.parseInt(id)).getCommodities().clear();
		return "redirect:/admin/orders";
	}
	



}
