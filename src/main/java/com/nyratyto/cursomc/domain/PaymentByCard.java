package com.nyratyto.cursomc.domain;

import javax.persistence.Entity;

import com.nyratyto.cursomc.domain.enums.PaymentStatus;

@Entity
public class PaymentByCard extends Payment {
	
	private static final long serialVersionUID = 1L;

	private Integer installmentsNumber;

	public PaymentByCard() {}

	public PaymentByCard(Integer id, PaymentStatus status, PurchaseOrder order, Integer installmentsNumber) {
		super(id, status, order);
		this.installmentsNumber = installmentsNumber;
	}
	
	public Integer getInstallmentsNumber() {
		return installmentsNumber;
	}
	
	public void setInstallmentsNumber(Integer installmentsNumber) {
		this.installmentsNumber = installmentsNumber;
	}
	
}
