package me.olvrti.api.domain.enums;

public enum CustomerType {

	NATURALPERSON(1, "Natural Person"), JURIDICALPERSON(2, "Juridical Person");

	private Integer id;
	private String description;

	private CustomerType(Integer id, String description) {
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

	public static CustomerType toEnum(Integer id) {
		if (id == null) {
			return null;
		}

		for (CustomerType c : CustomerType.values()) {
			if (c.id == id) {
				return c;
			}
		}

		throw new IllegalArgumentException("Invalid Option" + id);
	}
}
