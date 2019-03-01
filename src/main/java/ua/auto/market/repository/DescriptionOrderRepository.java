package ua.auto.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import ua.auto.market.entity.DescriptionOrder;

@Repository
public interface DescriptionOrderRepository extends JpaRepository<DescriptionOrder, Long>,JpaSpecificationExecutor<DescriptionOrder>{
	
}
