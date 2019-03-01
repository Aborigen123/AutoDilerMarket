package ua.auto.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.auto.market.entity.CarImage;

@Repository
public interface CarImageRepository extends JpaRepository<CarImage, Long>{

}
