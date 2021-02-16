package me.olvrti.api.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import me.olvrti.api.domain.enums.PaymentState;

@Entity
public class CreditCard extends Payment {
	private static final long serialVersionUID = 1L;

	private String cardNumber;

	@JsonFormat(pattern = "MM/yy")
	private Date expirationDate;

	public CreditCard() {
	}

	public CreditCard(Integer id, Double amount, PurchaseOrder purchaseOrder, PaymentState paymentState,
			String cardNumber, Date expirationDate) {
		super(id, amount, purchaseOrder, paymentState);
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
}
