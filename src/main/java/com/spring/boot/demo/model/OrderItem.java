package com.spring.boot.demo.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_items")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "quantity")
	private int quantity;

	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItem(long id, String imageUrl, BigDecimal price, int quantity) {
		super();
		this.id = id;
		this.imageUrl = imageUrl;
		this.price = price;
		this.quantity = quantity;
	}

	public OrderItem(String imageUrl, BigDecimal price, int quantity) {
		super();
		this.imageUrl = imageUrl;
		this.price = price;
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", imageUrl=" + imageUrl + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	
}
