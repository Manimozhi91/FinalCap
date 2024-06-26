package com.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Orders;
import com.repository.OrderRepository;
@Service

public class OrderService {
	@Autowired
	OrderRepository orderRepo;

	public List<Orders> viewAllOrders() {
		return orderRepo.findAll();

	}

	public Orders findOrderById(int oid) {
		Optional<Orders> op = orderRepo.findById(oid);
		if(op.isPresent()) {
			Orders orderitem = op.get();
			return orderitem;
		}else {
			return null;
		}
	}

	public String placeOrder(Orders order) {
		Optional<Orders> oder = orderRepo.findById(order.getOid());
		if(oder.isPresent()) {
			return "Food Orders details already exists!";
		}else {
			orderRepo.save(order);
			return "Food ordered successfully!";
		}	
	}

	public String updateOrder(Orders order) {
		Optional<Orders> oder = orderRepo.findById(order.getOid());
		if(oder.isPresent()) {
			Orders ochange = oder.get();
			ochange.setOid(order.getOid());
			ochange.setCname(order.getCname());
			ochange.setLocation(order.getLocation());
			ochange.setContactno(order.getContactno());
			ochange.setQty(order.getQty());
			ochange.setFid(order.getFid());
			ochange.setPrice(order.getPrice());
			ochange.setStatus(order.getStatus());
			orderRepo.saveAndFlush(ochange);
			return "Food Orders updated successfuly!";
			
		}else {
			return "Food Orders details not found!";
		}
	}

	public String deleteOrder(int oid) {
		Optional<Orders> food = orderRepo.findById(oid);
		if(food.isPresent()) {
			orderRepo.deleteById(oid);
			return "Food Order cancelled successfully!";
			
		}else {
			return "Food Order details not found!";
		}

	}

	public List<Object> findByOrder(int oid) {
		return orderRepo.findByOrder(oid);

	}

	public List<Map<String, Object>> findMyOrder(int oid) {
		return orderRepo.findMyOrders(oid);

	}





	public List<Map<String, Object>> findCustomerOrder(Long contactno) {
		return orderRepo.findCustomerOrder(contactno);
	}

	public String cancelCustomerOrder(Long contactno) {
		Optional<Orders> order = orderRepo.cancelCustomerOrder(contactno);
		if(order.isPresent()) {
			orderRepo.deleteById(order.get().getOid());
		
	
		return "Customer Order cancelled successfully!";
	}else {
		return "Customer Order details not found!";
}
	
	}
	
	}
	
