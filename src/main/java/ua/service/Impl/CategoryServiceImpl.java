package ua.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.DAO.CategoryRepository;
import ua.DAO.CommodityRepository;
import ua.entities.Category;
import ua.entities.Commodity;
import ua.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CommodityRepository commodityRepository;

	
	public void save(Category category) {
		categoryRepository.save(category);
	}

	
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Transactional
	public void deleteById(int id) {
		Category category = categoryRepository.findCategoryWithCommodity(id);
		
		for (Commodity commodity : category.getCommodities()) {
			commodity.setCategory(null);
			commodityRepository.save(commodity);
			
		}
		
		categoryRepository.delete(category);
	}

	@Transactional
	@Override
	public void updateByName(String name, String name2) {
		Category category = categoryRepository.findByName(name);
		category.setName(name2);
		categoryRepository.save(category);
	}

	@Override
	public Category findOne(int id) {
		return categoryRepository.findOne(id);
	}

	
	public List<Category> findCategoryWithCommodities() {
		return categoryRepository.findCategoryWithCommodity();
	}
	@Transactional
	@Override
	public void deleteCommodityFromCategory(String idCommodity) {
		Commodity commodity = commodityRepository.findOne(Integer
				.parseInt(idCommodity));

		commodity.setCategory(null);

		commodityRepository.save(commodity);

	}

}