package com.nyratyto.cursomc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class PurchaseOrder implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date instant;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "purchaseOrder")
	private Payment payment;
	
	@ManyToOne
	@JoinColumn(name="delivery_address_id")
	private Address deliveyAddress;
	
	@OneToMany(mappedBy = "id.purchaseOrder")
	private Set<OrderItem> items = new HashSet<>();
	
	public PurchaseOrder() {}

	public PurchaseOrder(Integer id, Date instant, Customer customer, Address deliveyAddress) {
		super();
		this.id = id;
		this.instant = instant;
		this.customer = customer;
		this.deliveyAddress = deliveyAddress;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInstant() {
		return instant;
	}

	public void setInstant(Date instant) {
		this.instant = instant;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Address getDeliveyAddress() {
		return deliveyAddress;
	}

	public void setDeliveyAddress(Address deliveyAddress) {
		this.deliveyAddress = deliveyAddress;
	}

	public Set<OrderItem> getItems() {
		return items;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PurchaseOrder other = (PurchaseOrder) obj;
		return Objects.equals(id, other.id);
	}
	
}
