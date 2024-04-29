package com.spring.boot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.demo.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
