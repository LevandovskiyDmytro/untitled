package ua.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.DAO.DeliveryReposiotry;
import ua.entities.Delivery;
import ua.service.DeliveryService;

import java.util.List;


@Service
public class DeliveryServiceImpl implements DeliveryService {

	@Autowired
	private DeliveryReposiotry deliveryReposiotry;

	@Transactional
	@Override
	public void save(Delivery delivery) {
		deliveryReposiotry.save(delivery);
	}

	@Transactional
	@Override
	public Delivery findOne(int id) {
		return deliveryReposiotry.findOne(id);
	}

	@Transactional
	@Override
	public List<Delivery> findAll() {
		return deliveryReposiotry.findAll();
	}
	@Transactional
	@Override
	public Delivery findByName(String name) {
		return deliveryReposiotry.findByName(name);
	}

	@Transactional
	@Override
	public void deleteById(int id) {
		deliveryReposiotry.deleteById(id);
	}



	

}
