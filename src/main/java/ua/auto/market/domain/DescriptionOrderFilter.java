package ua.auto.market.domain;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.criteria.Expression;

import ua.auto.market.entity.enumeration.Manufacture;
import ua.auto.market.entity.enumeration.TypeProduct;

public class DescriptionOrderFilter {

	private String nameProduct;
	//@Enumerated(EnumType.STRING)
		private TypeProduct typeProduct;
	
//	@Enumerated(EnumType.STRING)
		private Manufacture manufacture;
	
	private int year;
	
	private int pricefrom;
	
	private int pricedo;




	public DescriptionOrderFilter(String nameProduct, TypeProduct typeProduct, Manufacture manufacture, int year,
			int pricefrom, int pricedo) {
		super();
		this.nameProduct = nameProduct;
		this.typeProduct = typeProduct;
		this.manufacture = manufacture;
		this.year = year;
		this.pricefrom = pricefrom;
		this.pricedo = pricedo;
	}

	public TypeProduct getTypeProduct() {
		return typeProduct;
	}

	public void setTypeProduct(TypeProduct typeProduct) {
		this.typeProduct = typeProduct;
	}

	public Manufacture getManufacture() {
		return manufacture;
	}

	public void setManufacture(Manufacture manufacture) {
		this.manufacture = manufacture;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getPricefrom() {
		return pricefrom;
	}

	public void setPricefrom(int pricefrom) {
		this.pricefrom = pricefrom;
	}

	public int getPricedo() {
		return pricedo;
	}

	public void setPricedo(int pricedo) {
		this.pricedo = pricedo;
	}

	public DescriptionOrderFilter() { }

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public DescriptionOrderFilter(Manufacture manufacture) {
	
		this.manufacture = manufacture;
	}


	








	
	
}