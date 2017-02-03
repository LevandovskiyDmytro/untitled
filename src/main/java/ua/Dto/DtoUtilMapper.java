package ua.Dto;

import java.util.ArrayList;
import java.util.List;

import ua.entities.Commodity;
import ua.entities.User;

public class DtoUtilMapper {
	
	public static List<UserDTO> usersToUsersDTO(List<User> users) {

		List<UserDTO> userDTOs = new ArrayList<UserDTO>();

		for (User user : users) {

			UserDTO userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setName(user.getName());
			userDTO.setEmail(user.getEmail());
			userDTO.setPhone(user.getPhone());

			userDTOs.add(userDTO);

		}

		return userDTOs;

	}

	public static List<CommodityDTO> commoditiesToCommoditiesDTO(List<Commodity> commodities){

		List<CommodityDTO> commodityDTOs = new ArrayList<CommodityDTO>();

		for (Commodity commodity: commodities) {
			CommodityDTO commodityDTO = new CommodityDTO();
			commodityDTO.setId(commodity.getId());
			commodityDTO.setModel(commodity.getModel());
			commodityDTO.setPathToImage(commodity.getPathToImage());
			commodityDTO.setPrice(commodity.getPrice());

			commodityDTOs.add(commodityDTO);
			
		}
		return commodityDTOs;
	}

}
