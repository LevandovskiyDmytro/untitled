package ua.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.DAO.DiscountRepository;
import ua.entities.Discount;
import ua.service.DiscountService;

import java.util.List;


@Service
public class DiscountServiceImpl implements DiscountService {

	@Autowired
	private DiscountRepository discountRepository;
	
	@Transactional
	@Override
	public void save(Discount discount) {
		discountRepository.save(discount);
	}

	@Transactional
	@Override
	public List<Discount> findAll() {
	return discountRepository.findAll();
	}
	
	@Transactional
	@Override
	public  void deleteById(int id) {
		discountRepository.delete(id);
	}
	@Transactional
	@Override
	public void update(Discount discount) {
		discountRepository.saveAndFlush(discount);
		
	}
	@Override
	public Discount findOne(int id) {
		return discountRepository.findOne(id);
	}


}
