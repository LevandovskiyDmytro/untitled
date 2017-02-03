	package ua.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import ua.entities.Commodity;

public interface CommodityService {
	
	void save(Commodity commodity,MultipartFile multipartFile) throws Exception;
	void delete(int id);
	public List<Commodity> findAll();
	Commodity findOne(int id);
	List<Commodity> AllFetch();

}
