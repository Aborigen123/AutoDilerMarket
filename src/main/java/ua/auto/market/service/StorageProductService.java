package ua.auto.market.service;

import java.util.List;

import ua.auto.market.entity.StorageProduct;

public interface StorageProductService {

	void saveStorageProduct(StorageProduct storageProduct);
	List<StorageProduct> findAllStorageProduct();
	
}
