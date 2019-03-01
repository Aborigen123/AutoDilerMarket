package ua.auto.market.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="main_order")
public class MainOrder extends BaseEntity {

    @Column(name = "data_today", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date dataToday;
    
    @OneToOne(mappedBy = "mainOrder")
    private DescriptionOrder descriptionOrder;
    
    
    @ManyToOne( fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "customer_id", nullable = true)
    private Customer customer;



	public MainOrder(Date dataToday, DescriptionOrder descriptionOrder, Customer customer) {
		
		this.dataToday = dataToday;
		this.descriptionOrder = descriptionOrder;
		this.customer = customer;
	}


	public Date getDataToday() {
		return dataToday;
	}


	public void setDataToday(Date dataToday) {
		this.dataToday = dataToday;
	}


	public DescriptionOrder getDescriptionOrder() {
		return descriptionOrder;
	}


	public void setDescriptionOrder(DescriptionOrder descriptionOrder) {
		this.descriptionOrder = descriptionOrder;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
public MainOrder() {}


public MainOrder(Customer customer) {
	this.customer = customer;
}


public MainOrder(DescriptionOrder descriptionOrder, Customer customer) {
	super();
	this.descriptionOrder = descriptionOrder;
	this.customer = customer;
};


    
}
