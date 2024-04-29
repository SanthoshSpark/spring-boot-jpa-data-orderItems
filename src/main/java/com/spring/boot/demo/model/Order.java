package com.spring.boot.demo.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "order_tracking_number", nullable = false)
	private String orderTrackingNumber;
	
	@Column(name ="total_quantity", nullable = false)
	private int totalQuantity;
	
	@Column(name ="total_price", nullable = false)
	private BigDecimal totalPrice;
	
	@Column(name ="status", nullable = false)
	private String status;
	
	@Column(name ="date_created", nullable = false)
	@CreationTimestamp
	private Date dateCreated;
	
	@Column(name ="last_updated", nullable = false)
	@UpdateTimestamp
	private Date lastUpdated;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id", referencedColumnName = "id")
	private Set<OrderItem> orderItems = new HashSet<>();

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(long id, String orderTrackingNumber, int totalQuantity, BigDecimal totalPrice, String status,
			Date dateCreated, Date lastUpdated, Set<OrderItem> orderItems) {
		super();
		this.id = id;
		this.orderTrackingNumber = orderTrackingNumber;
		this.totalQuantity = totalQuantity;
		this.totalPrice = totalPrice;
		this.status = status;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
		this.orderItems = orderItems;
	}

	public Order(String orderTrackingNumber, int totalQuantity, BigDecimal totalPrice, String status, Date dateCreated,
			Date lastUpdated, Set<OrderItem> orderItems) {
		super();
		this.orderTrackingNumber = orderTrackingNumber;
		this.totalQuantity = totalQuantity;
		this.totalPrice = totalPrice;
		this.status = status;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
		this.orderItems = orderItems;
	}

	public Order(String orderTrackingNumber, int totalQuantity, BigDecimal totalPrice, String status,
			Set<OrderItem> orderItems) {
		super();
		this.orderTrackingNumber = orderTrackingNumber;
		this.totalQuantity = totalQuantity;
		this.totalPrice = totalPrice;
		this.status = status;
		this.orderItems = orderItems;
	}

	public Order(String orderTrackingNumber, int totalQuantity, BigDecimal totalPrice, String status) {
		super();
		this.orderTrackingNumber = orderTrackingNumber;
		this.totalQuantity = totalQuantity;
		this.totalPrice = totalPrice;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrderTrackingNumber() {
		return orderTrackingNumber;
	}

	public void setOrderTrackingNumber(String orderTrackingNumber) {
		this.orderTrackingNumber = orderTrackingNumber;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	 public void add(OrderItem item) {

	        if (item != null) {
	            if (orderItems == null) {
	                orderItems = new HashSet<>();
	            }

	            orderItems.add(item);
	           // item.setOrder(this);
	        }
	    }
	 
	 public BigDecimal getTotalAmount()
		{
			BigDecimal amount = new BigDecimal("0.0");
			for (OrderItem item : this.orderItems)
			{
				amount = amount.add(item.getPrice());
			}
			return amount;
		}


	@Override
	public String toString() {
		return "Order [id=" + id + ", orderTrackingNumber=" + orderTrackingNumber + ", totalQuantity=" + totalQuantity
				+ ", totalPrice=" + totalPrice + ", status=" + status + ", dateCreated=" + dateCreated
				+ ", lastUpdated=" + lastUpdated + ", orderItems=" + orderItems + "]";
	}
	
	
	
}
