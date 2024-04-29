package com.spring.boot.demo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.boot.demo.model.Order;
import com.spring.boot.demo.model.OrderItem;
import com.spring.boot.demo.repository.OrderRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private OrderRepository orderRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	/*	System.out.println("\n\n1. Inser the row.....\n");
		
		Order order = new Order();
		
		OrderItem orderItem1 = new OrderItem("image_url1.png",new BigDecimal(100),17);
		OrderItem orderItem2 = new OrderItem("image_url2.png",new BigDecimal(400),27);
		OrderItem orderItem3 = new OrderItem("image_url3.png",new BigDecimal(200),10);
		
		order.add(orderItem1);
		order.add(orderItem2);
		order.add(orderItem3);
		
		order.setOrderTrackingNumber("1000");
		order.setStatus("In Progress");
		order.setTotalPrice(order.getTotalAmount());
		order.setTotalQuantity(3);
		
		orderRepository.save(order);
		
		*/
		
	/*	System.out.println("\n\n2. Update the row.....\n");

		Order order = orderRepository.findById(1L).get();
		System.out.println(order);
		order.setStatus("Delivered");
		
		orderRepository.save(order);
		
		System.out.println(order);
		
		
		
		System.out.println("\n\n3. List the order .....\n");
		
		List<Order> orders = orderRepository.findAll();
		
		for(Order ord :orders ) {
			System.out.println(order);
		}
        */
		
		System.out.println("\n\n4. Find By Tracking Id .....\n");
		
		Order order = orderRepository.findByOrderTrackingNumber("1000");
		
		System.out.println(order);
		
	}

}
