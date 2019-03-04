package ua.auto.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.auto.market.entity.DescriptionOrder;


@Repository
public interface DescriptionOrderRepository extends JpaRepository<DescriptionOrder, Long>,JpaSpecificationExecutor<DescriptionOrder>{
	
	/*@Query("SELECT d FROM DescriptionOrder d left join CarImage c ON d.id = c.id  WHERE d.id = :id")
	DescriptionOrder findDuscriptionOrderImageById(@Param("id") long id);*/
}
