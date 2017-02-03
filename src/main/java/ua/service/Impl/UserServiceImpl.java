package ua.service.Impl;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.multipart.MultipartFile;
import ua.DAO.CommodityRepository;
import ua.DAO.UserRepository;
import ua.entities.Commodity;
import ua.entities.Role;
import ua.entities.User;
import ua.service.UserService;
import ua.validator.Validator;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	@Qualifier("userValidator")
	private Validator validator;
	@Autowired
	private CommodityRepository commodityRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;


	public void save(User user) throws Exception {
		validator.validate(user);
		user.setRole(Role.ROLE_USER);
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
	}
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
	@Override
	public User findById(int id) {
		return userRepository.findOne(id);
	}
	@Override
	public void delete(int id) {
		userRepository.delete(id);
	}
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

		return userRepository.findByName(name);
	}
	@Transactional
	public void saveImage(Principal principal, MultipartFile multipartFile) {
		User user = userRepository.findOne(Integer.parseInt(principal.getName()));
		String path = System.getProperty("catalina.home") + "/images/"
				+ user.getName() + "/" + multipartFile.getOriginalFilename();

		user.setPathImage("images/" + user.getName() + "/" + multipartFile.getOriginalFilename());
		File file = new File(path);
		try {
			file.mkdirs();
			try {
				FileUtils.cleanDirectory
						(new File(System.getProperty("catalina.home") + "/images/" + user.getName() + "/"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			multipartFile.transferTo(file);
		} catch (IOException e) {
			System.out.println("error with file");
		}
		userRepository.save(user);
	}

	@Override
	public User findByUUID(String uuid) {
		return userRepository.findByUUID(uuid);
	}

	@Override
	public User findByPhone(String phone) {
		return userRepository.findByPhone(phone);
	}

	@Override
	public void update(User user) {
		userRepository.save(user);
	}

	@Override
	public void getOrder(Principal principal, String id) {
		User user = userRepository.findUserByFetch(Integer.parseInt(principal.getName()));
		Commodity commodity = commodityRepository.findOne(Integer.parseInt(id));
		user.getCommodities().add(commodity);
		userRepository.save(user);
	}

	@Override
	public User findFetchUser(int id) {
		return userRepository.findUserByFetch(id);
	}
    @Transactional
    @Override
    public void deleteCommodityFromUser(Principal principal, String id) {
        User user = userRepository.findUserByFetch(Integer.parseInt(principal.getName()));
        Commodity commodity = commodityRepository.findOne(Integer.parseInt(id));
        user.getCommodities().remove(commodity);
        userRepository.save(user);
    }

}
