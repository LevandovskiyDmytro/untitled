package ua.service;

import ua.entities.Category;

import java.util.List;

public interface CategoryService {

	void save(Category category);
	
	void updateByName(String name, String name2);
	
	public List<Category> findAll();
	
	public void deleteById(int id);
	
	Category findOne(int id);
	
	List<Category> findCategoryWithCommodities();
	
	void deleteCommodityFromCategory(String idCommodity);
	
	














}
