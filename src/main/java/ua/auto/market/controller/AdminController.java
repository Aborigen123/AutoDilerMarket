package ua.auto.market.controller;

import java.io.IOException;
import java.security.Principal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import ua.auto.market.domain.CreateProduct;
import ua.auto.market.entity.CarImage;
import ua.auto.market.entity.Customer;
import ua.auto.market.entity.DescriptionOrder;
import ua.auto.market.entity.MainOrder;
import ua.auto.market.entity.enumeration.Manufacture;
import ua.auto.market.entity.enumeration.TypeProduct;
import ua.auto.market.mapper.CreateProductMapper;
import ua.auto.market.service.CarImageService;
import ua.auto.market.service.CustomerService;
import ua.auto.market.service.DescriptionOrderService;
import ua.auto.market.service.util.CustomFileUtils;



@Controller
@RequestMapping("/admin")
public class AdminController {

@Autowired private CustomerService customerService;
@Autowired private DescriptionOrderService descriptionOrderService;

	@GetMapping
	public String addPage(Model model, Principal principal) {
		Customer customer = customerService.findUserByNameCustomer(principal.getName());
		
		model.addAttribute("Customer", customer);
		return "admin/pagecontrole";
	}
	

	
@GetMapping("/{nameCustomer}/add")
public String addProduct(Model model, Principal principal, @PathVariable ("nameCustomer")String nameCustomer) {

	CreateProduct createProduct = new CreateProduct();

	model.addAttribute("createProduct", createProduct);
	model.addAttribute("manufactures", Manufacture.values());
	model.addAttribute("typeProducts", TypeProduct.values());
	model.addAttribute("nameCustomer", nameCustomer);
	return "admin/add";
}

@PostMapping("/{nameCustomer}/add")
public String addProductPost(Model model,Principal principal,  @PathVariable ("nameCustomer")String nameCustomer, @ModelAttribute("createProduct") CreateProduct createProduct) throws IOException {
	Customer customer = customerService.findUserByNameCustomer(principal.getName());
	DescriptionOrder descr = CreateProductMapper.createProductToDescriptionOrder(createProduct);
   CarImage carImageSave =  CreateProductMapper.createProductToDescriptionOrder2(createProduct);

   
   MainOrder mainOrder = new MainOrder(descr, customer);
	descr.setMainOrder(mainOrder);
    carImageSave.setDescriptionOrder(descr);
	
	descriptionOrderService.saveDescriptionOrder(descr, carImageSave);

	
//	CustomFileUtils.createFolder("admin_product_"+ customer.getId());
	CustomFileUtils.createImageInUpload("admin_product_" + customer.getId(), createProduct.getCarImage1(),createProduct.getCarImage2(),createProduct.getCarImage3(),createProduct.getCarImage4(),createProduct.getCarImage5(),createProduct.getCarImage6());
	return "redirect:/admin/"+ nameCustomer+"/add";
}

}
