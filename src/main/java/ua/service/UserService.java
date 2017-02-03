package ua.service;

import org.springframework.web.multipart.MultipartFile;
import ua.entities.User;

import java.security.Principal;
import java.util.List;

public interface UserService {
	
	void save(User user) throws Exception;
	List<User> findAll();
	User findById(int id);
	void delete(int id);
	void deleteCommodityFromUser(Principal principal, String id);
	void saveImage(Principal principal, MultipartFile multipartFile);
	void getOrder(Principal principal, String id);
	User findFetchUser(int id);
	User findByUUID(String uuid);
	void update(User user);
	User findByPhone(String phone);

}
