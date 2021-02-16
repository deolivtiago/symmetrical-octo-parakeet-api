package me.olvrti.api.domain.enums;

public enum PaymentState {

	CREATED(1, "Created"), HOLDING(2, "Holding"), PAID(3, "Paid"), SHIPPED(4, "Shipped"), DELIVERED(5, "Delivered"),
	CLOSED(6, "Closed"), CANCELED(7, "Canceled");

	private Integer id;
	private String description;

	private PaymentState(Integer id, String description) {
		this.id = id;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static PaymentState toEnum(Integer id) {
		if (id == null) {
			return null;
		}

		for (PaymentState value : PaymentState.values()) {
			if (value.id == id) {
				return value;
			}
		}

		throw new IllegalArgumentException("Invalid Option" + id);
	}
}
