package ua.auto.market.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ua.auto.market.entity.enumeration.Manufacture;
import ua.auto.market.entity.enumeration.TypeProduct;

@Entity
@Table(name = "description_order")
public class DescriptionOrder extends BaseEntity{

	
	@Column(name = "name_product")
	private String nameProduct;
	
	 @Enumerated(EnumType.STRING)
	private TypeProduct typeProduct;
	
	private int quantity;
	
	  @Column(name = "price",columnDefinition = "DECIMAL(5,2)")
		private BigDecimal price;
	  
	
	  @Enumerated(EnumType.STRING)
		 private Manufacture manufacture;
	  
	  @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
	  @JoinColumn(name = "product_on_sell_id", nullable = true)
	 private ProductOnSell productOnSell;
	  
	  @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
	  @JoinColumn(name = "main_order_id", nullable = true)
	  private MainOrder mainOrder;
	  
	  @OneToMany(mappedBy = "descriptionOrder",  cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
		List<CarImage> carImage = new ArrayList<>();

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public TypeProduct getTypeProduct() {
		return typeProduct;
	}

	public void setTypeProduct(TypeProduct typeProduct) {
		this.typeProduct = typeProduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Manufacture getManufacture() {
		return manufacture;
	}

	public void setManufacture(Manufacture manufacture) {
		this.manufacture = manufacture;
	}

	public ProductOnSell getProductOnSell() {
		return productOnSell;
	}

	public void setProductOnSell(ProductOnSell productOnSell) {
		this.productOnSell = productOnSell;
	}

	public MainOrder getMainOrder() {
		return mainOrder;
	}

	public void setMainOrder(MainOrder mainOrder) {
		this.mainOrder = mainOrder;
	}




	public DescriptionOrder(String nameProduct, TypeProduct typeProduct, int quantity, BigDecimal price,
			Manufacture manufacture, ProductOnSell productOnSell, MainOrder mainOrder, List<CarImage> carImage) {
		super();
		this.nameProduct = nameProduct;
		this.typeProduct = typeProduct;
		this.quantity = quantity;
		this.price = price;
		this.manufacture = manufacture;
		this.productOnSell = productOnSell;
		this.mainOrder = mainOrder;
		this.carImage = carImage;
	}

	public List<CarImage> getCarImage() {
		return carImage;
	}

	public void setCarImage(List<CarImage> carImage) {
		this.carImage = carImage;
	}

	public DescriptionOrder() {}

	
	
	
	
	
	  
	/*  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	  @JoinColumn(name = "storage_product_id", nullable = true)
      private StorageProduct storageProduct;*/
	  
	  
}
