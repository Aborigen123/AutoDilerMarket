package ua.auto.market.domain;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import ua.auto.market.entity.MainOrder;
import ua.auto.market.entity.enumeration.Manufacture;
import ua.auto.market.entity.enumeration.TypeProduct;

public class CreateProduct {
private String nameProduct;
private TypeProduct typeProduct;
private int quantity;
private BigDecimal price;
private Manufacture manufacture;
private MainOrder mainOrder;
private MultipartFile carImage1;
private MultipartFile carImage2;
private MultipartFile carImage3;
private MultipartFile carImage4;
private MultipartFile carImage5;
private MultipartFile carImage6;









public CreateProduct(String nameProduct, TypeProduct typeProduct, int quantity, BigDecimal price,
		Manufacture manufacture, MainOrder mainOrder, MultipartFile carImage1, MultipartFile carImage2,
		MultipartFile carImage3, MultipartFile carImage4, MultipartFile carImage5, MultipartFile carImage6) {
	this.nameProduct = nameProduct;
	this.typeProduct = typeProduct;
	this.quantity = quantity;
	this.price = price;
	this.manufacture = manufacture;
	this.mainOrder = mainOrder;
	this.carImage1 = carImage1;
	this.carImage2 = carImage2;
	this.carImage3 = carImage3;
	this.carImage4 = carImage4;
	this.carImage5 = carImage5;
	this.carImage6 = carImage6;
}









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









public MainOrder getMainOrder() {
	return mainOrder;
}









public void setMainOrder(MainOrder mainOrder) {
	this.mainOrder = mainOrder;
}









public MultipartFile getCarImage1() {
	return carImage1;
}









public void setCarImage1(MultipartFile carImage1) {
	this.carImage1 = carImage1;
}









public MultipartFile getCarImage2() {
	return carImage2;
}









public void setCarImage2(MultipartFile carImage2) {
	this.carImage2 = carImage2;
}









public MultipartFile getCarImage3() {
	return carImage3;
}









public void setCarImage3(MultipartFile carImage3) {
	this.carImage3 = carImage3;
}









public MultipartFile getCarImage4() {
	return carImage4;
}









public void setCarImage4(MultipartFile carImage4) {
	this.carImage4 = carImage4;
}









public MultipartFile getCarImage5() {
	return carImage5;
}









public void setCarImage5(MultipartFile carImage5) {
	this.carImage5 = carImage5;
}









public MultipartFile getCarImage6() {
	return carImage6;
}









public void setCarImage6(MultipartFile carImage6) {
	this.carImage6 = carImage6;
}









public CreateProduct() {};
}
