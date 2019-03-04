package ua.auto.market.service;

import java.util.List;

import ua.auto.market.entity.CarImage;

public interface CarImageService {

	void saveCarImage(CarImage carImage);
	
	List<CarImage> findAllCarImage();
	
	CarImage findImageById(Long id);
	
	CarImage findCarImageById(long id);
}
