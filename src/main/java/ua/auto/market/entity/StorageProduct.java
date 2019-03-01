package ua.auto.market.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ua.auto.market.entity.enumeration.Manufacture;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Entity
@Table(name = "storage_product")
public class StorageProduct extends BaseEntity {

	@Column(name = "name_product")
	private String nameProduct;
	
	@Column(name = "quantity")
	private int quantity;
	
    @Column(name = "price",columnDefinition = "DECIMAL(5,2)")
	private BigDecimal price;
	
	@Enumerated(EnumType.STRING)
	 private Manufacture manufacture;
    
    @Column(name = "data_on_storage", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date dataOnStorage;
	
    @OneToMany(mappedBy = "storageProduct", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
List<Operation> operation = new ArrayList<>();

	public StorageProduct(String nameProduct, int quantity, BigDecimal price, Manufacture manufacture,
			Date dataOnStorage, List<Operation> operation) {
		super();
		this.nameProduct = nameProduct;
		this.quantity = quantity;
		this.price = price;
		this.manufacture = manufacture;
		this.dataOnStorage = dataOnStorage;
		this.operation = operation;
	}
	public StorageProduct() {}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
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

	public Date getDataOnStorage() {
		return dataOnStorage;
	}

	public void setDataOnStorage(Date dataOnStorage) {
		this.dataOnStorage = dataOnStorage;
	}

	public List<Operation> getOperation() {
		return operation;
	}

	public void setOperation(List<Operation> operation) {
		this.operation = operation;
	}

	@Override
	public String toString() {
		return "StorageProduct [nameProduct=" + nameProduct + ", quantity=" + quantity + ", price=" + price
				+ ", manufacture=" + manufacture + ", dataOnStorage=" + dataOnStorage + ", getId()=" + getId() + "]";
	}

 /*   @OneToOne(mappedBy = "storageProduct")
    private DescriptionOrder description;*/
    


    
}
