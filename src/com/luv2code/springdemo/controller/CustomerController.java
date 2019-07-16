package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// transfered to customer service 
//	// need to inject the DAO to controller
//	@Autowired
//	private CustomerDAO customerDAO;
	
	// customer service injection
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customers form dao
		List<Customer> theCustomers = customerService.getCustomers();
		
		// add customers to model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	 // handler 
	@GetMapping("/showFromForAdd")
	public String showFromForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		// save the customer// sent data to service
		customerService.saveCustomer(theCustomer);
		
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		
		// get cutomers
		Customer theCustomer = customerService.getCustomer(theId);
		
		// set customer to model
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("id") int theId) {
		
		// pass the data to service
		customerService.deleteCustomer(theId);
		
		
		return "redirect:/customer/list";
	}
}
