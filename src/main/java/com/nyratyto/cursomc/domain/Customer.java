package com.nyratyto.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nyratyto.cursomc.domain.enums.CustomerType;

@Entity
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;
	private String idOrEin; // ID (equivalente = RG) or EIN (equivalente = CNPJ)
	private Integer type;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "customer")
	private List<Address> addresses = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name="PHONE")
	private Set<String> phones = new HashSet<>();
	
	@OneToMany(mappedBy = "customer")
	private List<PurchaseOrder> purchaseOrders = new ArrayList<>();
	
	public Customer() {}

	public Customer(Integer id, String name, String email, String idOrEin, CustomerType type) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.idOrEin = idOrEin;
		this.type = type.getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdOrEin() {
		return idOrEin;
	}

	public void setIdOrEin(String idOrEin) {
		this.idOrEin = idOrEin;
	}

	public CustomerType getType() {
		return CustomerType.toEnum(type);
	}

	public void setType(CustomerType type) {
		this.type = type.getId();
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public Set<String> getPhones() {
		return phones;
	}

	public List<PurchaseOrder> getOrders() {
		return purchaseOrders;
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
		Customer other = (Customer) obj;
		return Objects.equals(id, other.id);
	}
	
}
