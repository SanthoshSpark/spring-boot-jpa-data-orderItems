package com.spring.boot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.demo.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

	public Order findByOrderTrackingNumber(String orderTrackingNumber);
}
