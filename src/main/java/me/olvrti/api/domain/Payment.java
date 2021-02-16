package me.olvrti.api.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import me.olvrti.api.domain.enums.PaymentState;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private Double amount;
	private Integer paymentState;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "purchase_order_id")
	@MapsId
	private PurchaseOrder purchaseOrder;

	public Payment() {
	}

	public Payment(Integer id, Double amount, PurchaseOrder purchaseOrder, PaymentState paymentState) {
		this.id = id;
		this.amount = amount;
		this.purchaseOrder = purchaseOrder;
		this.paymentState = paymentState.getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PaymentState getPaymentState() {
		return PaymentState.toEnum(paymentState);
	}

	public void setPaymentState(PaymentState paymentState) {
		this.paymentState = paymentState.getId();
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@JsonIgnore
	public PurchaseOrder getOrder() {
		return purchaseOrder;
	}

	public void setOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
