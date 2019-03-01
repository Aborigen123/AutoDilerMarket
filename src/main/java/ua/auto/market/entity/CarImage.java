package ua.auto.market.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "car_image")
public class CarImage extends BaseEntity {

	@Column(name = "car_image1")
	private String stickerImage1;
	
	@Column(name = "car_image2")
	private String stickerImage2;
	
	@Column(name = "car_image3")
	private String stickerImage3;
	
	@Column(name = "car_image4")
	private String stickerImage4;
	
	@Column(name = "car_image5")
	private String stickerImage5;
	
	@Column(name = "car_image6")
	private String stickerImage6;
	
	 @ManyToOne( fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	    @JoinColumn(name = "description_order_id", nullable = true)
	    private DescriptionOrder descriptionOrder;

	public String getStickerImage1() {
		return stickerImage1;
	}

	public void setStickerImage1(String stickerImage1) {
		this.stickerImage1 = stickerImage1;
	}

	public String getStickerImage2() {
		return stickerImage2;
	}

	public void setStickerImage2(String stickerImage2) {
		this.stickerImage2 = stickerImage2;
	}

	public String getStickerImage3() {
		return stickerImage3;
	}

	public void setStickerImage3(String stickerImage3) {
		this.stickerImage3 = stickerImage3;
	}

	public String getStickerImage4() {
		return stickerImage4;
	}

	public void setStickerImage4(String stickerImage4) {
		this.stickerImage4 = stickerImage4;
	}

	public String getStickerImage5() {
		return stickerImage5;
	}

	public void setStickerImage5(String stickerImage5) {
		this.stickerImage5 = stickerImage5;
	}

	public String getStickerImage6() {
		return stickerImage6;
	}

	public void setStickerImage6(String stickerImage6) {
		this.stickerImage6 = stickerImage6;
	}

	public DescriptionOrder getDescriptionOrder() {
		return descriptionOrder;
	}

	public void setDescriptionOrder(DescriptionOrder descriptionOrder) {
		this.descriptionOrder = descriptionOrder;
	}

	public CarImage(String stickerImage1, String stickerImage2, String stickerImage3, String stickerImage4,
			String stickerImage5, String stickerImage6, DescriptionOrder descriptionOrder) {
		super();
		this.stickerImage1 = stickerImage1;
		this.stickerImage2 = stickerImage2;
		this.stickerImage3 = stickerImage3;
		this.stickerImage4 = stickerImage4;
		this.stickerImage5 = stickerImage5;
		this.stickerImage6 = stickerImage6;
		this.descriptionOrder = descriptionOrder;
	}
	 public CarImage() {};
	 
}
