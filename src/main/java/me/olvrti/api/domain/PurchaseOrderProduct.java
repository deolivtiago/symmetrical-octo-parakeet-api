package me.olvrti.api.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PurchaseOrderProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private PurchaseOrderProductPK id = new PurchaseOrderProductPK();

	private Double discount;
	private Integer quantity;

	public PurchaseOrderProduct() {
	}

	public PurchaseOrderProduct(PurchaseOrder purchaseOrder, Product product, Double discount, Integer quantity) {
		this.id.setPurchaseOrder(purchaseOrder);
		this.id.setProduct(product);
		this.discount = discount;
		this.quantity = quantity;
	}

	public PurchaseOrderProductPK getId() {
		return id;
	}

	public void setId(PurchaseOrderProductPK id) {
		this.id = id;
	}

	@JsonIgnore
	public PurchaseOrder getPurchaseOrder() {
		return this.id.getPurchaseOrder();
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.id.setPurchaseOrder(purchaseOrder);
	}

	public Product getProduct() {
		return this.id.getProduct();
	}

	public void setProduct(Product product) {
		this.id.setProduct(product);
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
		PurchaseOrderProduct other = (PurchaseOrderProduct) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
