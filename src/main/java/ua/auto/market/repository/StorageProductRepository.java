package ua.auto.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.auto.market.entity.StorageProduct;

@Repository
public interface StorageProductRepository extends JpaRepository<StorageProduct, Long> {

}
