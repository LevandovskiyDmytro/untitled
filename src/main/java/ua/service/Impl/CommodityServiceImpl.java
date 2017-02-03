package ua.service.Impl;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.multipart.MultipartFile;
import ua.DAO.CommodityRepository;
import ua.entities.Commodity;
import ua.service.CommodityService;
import ua.validator.Validator;

import java.io.File;
import java.io.IOException;
import java.util.List;
@Service
public class CommodityServiceImpl implements CommodityService{

	

		@Autowired
		private CommodityRepository commodityRepository;

		@Qualifier("commodityValidator")
		private Validator validator;

		public void save(Commodity commodity,MultipartFile multipartFile) throws Exception {
			validator.validate(commodity);
			String path = System.getProperty("catalina.home")+"/images/" + commodity.getModel() + "/" + multipartFile.getOriginalFilename();
			commodity.setPathToImage("/images/"+commodity.getModel() + "/" + multipartFile.getOriginalFilename());
			File file = new File(path);
			try {
				file.mkdirs();
				try {
					FileUtils.cleanDirectory
							(new File(System.getProperty("catalina.home")+"/images/" + commodity.getModel() + "/"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				multipartFile.transferTo(file);
			} catch (IOException e) {
				System.out.println("error with file");
			}
			commodityRepository.save(commodity);
		}
		@Transactional
		@Override
		public void delete(int id) {
			commodityRepository.delete(id);
		}
		@Transactional
		@Override
		public List<Commodity> findAll() {
			return commodityRepository.findAll();
		}
		@Transactional
		@Override
		public Commodity findOne(int id) {
				return commodityRepository.findOne(id);
			}

		@Override
		public List<Commodity> AllFetch() {
			return null;
		}
}
