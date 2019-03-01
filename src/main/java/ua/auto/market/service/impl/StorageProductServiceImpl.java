package ua.auto.market.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.auto.market.entity.StorageProduct;
import ua.auto.market.repository.StorageProductRepository;
import ua.auto.market.service.StorageProductService;

@Service
public class StorageProductServiceImpl implements StorageProductService{

	@Autowired private StorageProductRepository storageProductRepository;
	@Override
	public void saveStorageProduct(StorageProduct storageProduct) {
	  storageProductRepository.save(storageProduct);
		
	}

	@Override
	public List<StorageProduct> findAllStorageProduct() {
		
		return storageProductRepository.findAll();
	}

}
