package ua.auto.market.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.auto.market.entity.CarImage;
import ua.auto.market.repository.CarImageRepository;
import ua.auto.market.service.CarImageService;

@Service
public class CarImageServiceImpl implements CarImageService{

	
	@Autowired private CarImageRepository carImageRepository;
	
	@Override
	public void saveCarImage(CarImage carImage) {
	 carImageRepository.save(carImage);
		
	}

	@Override
	public List<CarImage> findAllCarImage() {
		
		return carImageRepository.findAll();
	}

	@Override
	public CarImage findImageById(Long id) {
		
		return carImageRepository.findOne(id);
	}

}
