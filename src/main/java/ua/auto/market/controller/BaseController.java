package ua.auto.market.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.criteria.Expression;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.auto.market.domain.CustomerRegistrationRequest;
import ua.auto.market.domain.DescriptionOrderFilter;
import ua.auto.market.domain.LoginRequest;
import ua.auto.market.domain.ProductNameFilter;
import ua.auto.market.entity.CarImage;
import ua.auto.market.entity.Customer;
import ua.auto.market.entity.DescriptionOrder;
import ua.auto.market.entity.ProductOnSell;
import ua.auto.market.entity.enumeration.Manufacture;
import ua.auto.market.entity.enumeration.TypeProduct;
import ua.auto.market.mapper.CustomerMapper;
import ua.auto.market.service.CarImageService;
import ua.auto.market.service.CustomerService;
import ua.auto.market.service.DescriptionOrderService;
import ua.auto.market.service.ProductOnSellService;
import ua.auto.market.service.util.CustomFileUtils;








@Controller
@SessionAttributes({"manufactures", "typeProducts"})
public class BaseController {

	@Autowired private CustomerService customerService;
	@Autowired private ProductOnSellService productOnSellService;
	@Autowired private DescriptionOrderService descriptionOrderService;
	@Autowired private CarImageService carImageService;
	
	@GetMapping({"/", "/home"})
	public String showHome(
		Model model
			) throws IOException {

		//List<DescriptionOrder> descriptionOrder = descriptionOrderService.findAllDescriptionOrder();
		List<CarImage> carImage = carImageService.findAllCarImage();
		
	
		
		
		for(int i = 0; i < carImage.size(); i++) {
			String image = carImage.get(i).getStickerImage1();
			carImage.get(i).setStickerImage1(
					CustomFileUtils.getImage(
							"product_" + carImage.get(i).getId(), 
							image));
			
		}

		model.addAttribute("manufactures", Manufacture.values());
		model.addAttribute("typeProducts", TypeProduct.values());
		model.addAttribute("descriptionOrderList", descriptionOrderService.findAllDescriptionOrder());
        model.addAttribute("carImageList", carImage);	
	
		return "home";
	}
/*	ProductOnSell productOnSell;
@ModelAttribute("manufactures")
public List<Manufacture>  manufactureTupe(){
	return productOnSellService.findAllProductOnSell()
			.stream().map(productOnSell -> ((productOnSell) productOnSell).getManufacture()).collect(Collectors.toList());
}*/
	
	@GetMapping("/404")
	public String show404() {
		return "404";
	}
	
	@GetMapping("/login")
	public String showLogin(Model model) {
		model.addAttribute("loginModel", new LoginRequest());
		return "login";
	}
	
	@GetMapping("/registration")
	public String showRegistration(Model model) {
		model.addAttribute("registerModel", new CustomerRegistrationRequest());
		return "register";
	}
	
	@PostMapping("/registration")
	public String createCustomer(Model model, 
			@ModelAttribute("registerModel") @Valid CustomerRegistrationRequest customerRegistrationRequest,
			BindingResult result) {
		
		if(result.hasErrors()) {
		return "register";
		}
		
		customerService.saveCustomer(CustomerMapper.registerToCustomer(customerRegistrationRequest));
		return "redirect:/login";
	}
	
	@GetMapping("/search")
	public String search( Model model, @PageableDefault Pageable pageable, @RequestParam("search") String search) {
		Page<ProductOnSell> page = productOnSellService.findProductByName(pageable, new ProductNameFilter(search));//search
		
		model.addAttribute("productOnSellList", page.getContent());
		return "search";
	}
	
/*	@ModelAttribute("manufactures")
    public List<Manufacture> stickerTypes()
    {
        return Arrays.asList(Manufacture.values());
    }*/
	
	@GetMapping("/searches")//,typeProduct,manufacturer,year,pricefrom,pricedo
	public String searches( Model model, @PageableDefault Pageable pageable,	//	BindingResult result,
		//	@RequestParam("nameProduct") String nameProduct
			//@RequestParam("typeProduct") TypeProduct typeProduct,
			@RequestParam("manufacture") Manufacture manufacture
			/*	@RequestParam("year") int year,
			@RequestParam("pricefrom") int pricefrom,
			@RequestParam("pricedo") int pricedo*/
			
			) {
		

		
		Page<DescriptionOrder> page = descriptionOrderService.findDescriptionOrderBy(pageable, new DescriptionOrderFilter(manufacture)); //   ,typeProduct,manufacturer,year,pricefrom,pricedo
		model.addAttribute("descriptionOrderList", descriptionOrderService.findAllDescriptionOrder());
		model.addAttribute("descriptionOrderList", page.getContent());
		return "searches";
		//BindingResult result,
	}
	


}
