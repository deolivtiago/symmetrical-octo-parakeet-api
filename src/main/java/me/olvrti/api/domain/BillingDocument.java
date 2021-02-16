package me.olvrti.api.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import me.olvrti.api.domain.enums.PaymentState;

@Entity
public class BillingDocument extends Payment {
	private static final long serialVersionUID = 1L;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date due;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date paid;

	public BillingDocument() {
	}

	public BillingDocument(Integer id, Double amount, PurchaseOrder purchaseOrder, PaymentState paymentState, Date due,
			Date paid) {
		super(id, amount, purchaseOrder, paymentState);
		this.due = due;
		this.paid = paid;
	}

	public Date getDue() {
		return due;
	}

	public void setDue(Date due) {
		this.due = due;
	}

	public Date getPaid() {
		return paid;
	}

	public void setPaid(Date paid) {
		this.paid = paid;
	}
}
