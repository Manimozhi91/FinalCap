package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.entity.Orders;
import com.service.OrderService;
import jakarta.ws.rs.core.MediaType;

@RestController
@RequestMapping("orders")
@CrossOrigin
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping(value="viewallorders")
	public List<Orders> viewAllOrderDetails(){
		return orderService.viewAllOrders();
	}
	
	@GetMapping(value="findorderinfo/{oid}")
	public Orders findOrderInfo(@PathVariable("oid") int oid) {
		return orderService.findOrderById(oid);
	}
	
	@PostMapping(value="placeorder",consumes= MediaType.APPLICATION_JSON)
	public String placeOrder(@RequestBody Orders order) {
		return orderService.placeOrder(order);
	}
	
	@PatchMapping(value="updateorder",consumes= MediaType.APPLICATION_JSON)
	public String updateOrder(@RequestBody Orders order) {
		return orderService.updateOrder(order);
		
	}
	
	@DeleteMapping(value="deleteorder/{oid}")
	public String deleteOrder(@PathVariable int oid) {
		return orderService.deleteOrder(oid);
	}
	
	
	@GetMapping(value="findorders/{oid}")
	public List<Object> findByOrder(@PathVariable int oid){
		return orderService.findByOrder(oid);
	}
	
	@GetMapping(value="viewmyorder/{oid}")
	public List<java.util.Map<String, Object>> findMyOrder(@PathVariable int oid){
		return orderService.findMyOrder(oid);
	}
	
	@GetMapping(value="findcustomerorder/{contactno}")
	public List<java.util.Map<String, Object>> findCustomerOrder(@PathVariable Long contactno){
		return orderService.findCustomerOrder(contactno);
	}
	
	@DeleteMapping(value="cancelcustomerorder/{contactno}")
	public String CancelCustomerOrder(@PathVariable Long contactno) {
		return orderService.cancelCustomerOrder(contactno);
	}

}
