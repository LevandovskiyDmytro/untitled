package ua.service;

import java.util.List;

import ua.entities.Discount;

public interface DiscountService {
	
	void save(Discount discount);
	void update(Discount discount);
	public List<Discount> findAll();
	public void deleteById(int id);
	Discount findOne(int id);

}
