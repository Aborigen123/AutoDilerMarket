package ua.auto.market.service.impl;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ua.auto.market.domain.DescriptionOrderFilter;
import ua.auto.market.domain.ProductNameFilter;
import ua.auto.market.entity.CarImage;
import ua.auto.market.entity.DescriptionOrder;
import ua.auto.market.entity.ProductOnSell;
import ua.auto.market.entity.enumeration.Manufacture;
import ua.auto.market.entity.enumeration.TypeProduct;
import ua.auto.market.repository.CarImageRepository;
import ua.auto.market.repository.DescriptionOrderRepository;
import ua.auto.market.service.DescriptionOrderService;

@Service
@Slf4j
public class DescriptionOrderServiceImpl implements DescriptionOrderService{

	@Autowired private DescriptionOrderRepository descriptionOrderRepository;
@Autowired private CarImageRepository carImageRepository;

	@Override
	public void saveDescriptionOrder(DescriptionOrder descriptionOrder, CarImage carImage) {
		
		 descriptionOrderRepository.save(descriptionOrder);
		 carImageRepository.save(carImage);
		
	}

	@Override
	public List<DescriptionOrder> findAllDescriptionOrder() {
	
		return descriptionOrderRepository.findAll();
	}

	@Override
	public Page<DescriptionOrder> findDescriptionOrderBy(Pageable pageable, DescriptionOrderFilter filter) {
		
		return descriptionOrderRepository.findAll(getSpecification(filter), pageable);
	}
	
	private Specification<DescriptionOrder> getSpecification(DescriptionOrderFilter filter){
		return new Specification<DescriptionOrder>() {

			@Override
			public Predicate toPredicate(Root<DescriptionOrder> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
			//	if(filter.getNameProduct().isEmpty()) return null;
		//	if(String.valueOf(filter.getManufacture()).isEmpty()) return null;
				/*		if(String.valueOf(filter.getPricefrom()).isEmpty()) return null;
				if(String.valueOf(filter.getPricedo()).isEmpty()) return null;
				if(String.valueOf(filter.getTypeProduct()).isEmpty()) return null;
				if(String.valueOf(filter.getYear()).isEmpty()) return null;*/
				
			//	Predicate predicateName = cb.like(root.get("nameProduct"), "%" + filter.getNameProduct() + "%");
			//		Predicate predicateManufacture = cb.like(root.get("manufacturer"), String.valueOf(filter.getManufacture()) );
					/*	Predicate predicateBetweenPrice = cb.between(root.get("pricefrom,pricedo"), filter.getPricefrom(), filter.getPricedo());
				Predicate predicateTypeProduct = cb.like(root.get("typeProduct"), String.valueOf(filter.getTypeProduct()) );*/
				
				
			//	Predicate allPredicate = cb.and(predicateName, predicateManufacture);//,predicateManufacture,predicateBetweenPrice,predicateTypeProduct
		
			//cb.like(root.get("manufacture"),  "%" + filter.getManufacture() + "%" )
	
				//Predicate manufacturePredicate = cb.(manufactureExpression, filter.getManufacture());
			//query.select(root).where(
				String manufactureString = (filter.getManufacture()).toString();
				Manufacture manufactureEnumConvert = Manufacture.valueOf(manufactureString);
				Manufacture manufactureEnum = filter.getManufacture();
				log.debug("------------------------------------------------------------------");
				log.debug("manufactureString = " + manufactureString);
			//	Path<Object> path = root.get("manufacture");
			//	if( (Manufacture.Lexus.toString()).equals(manufactureString)) {};
				//TEST2 cb.like(root.get("manufacture"), filter.getManufacture());
				
		//	Expression<String> manufactureExpression = root.get("manufacture");
		//	Predicate manufacturePredicate = cb.like(manufactureExpression, "%"+filter.getManufacture()+"%");
		
				
		
			return cb.like(root.get("manufacture"), "%" + manufactureEnum );
			//cb.like(root.get("manufacture"), manufactureString+ "%");
			}
		
		
		};
		
		
	}

	@Override
	public DescriptionOrder findDescriptionOrderById(Long id) {
		
		return descriptionOrderRepository.findOne(id);
	}


}
