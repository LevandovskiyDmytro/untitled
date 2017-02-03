package ua.service;

import ua.entities.Delivery;

import java.util.List;

public interface DeliveryService {
	
	void save(Delivery delivery);
	public void deleteById(int id);
	public Delivery findOne(int id);
	public List<Delivery> findAll();
	public Delivery findByName(String name);




















}
