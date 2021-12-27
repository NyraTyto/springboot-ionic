package com.nyratyto.cursomc.domain.enums;

public enum CustomerType {

	NATURALPERSON(1, "Pessoa Física"), 
	LEGALPERSON(2, "Pessoa Jurídica");
	
	private int id;
	private String description;
	
	private CustomerType(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}
	
	public static CustomerType toEnum(Integer id) {
		if (id == null) return null;
		
		for (CustomerType ct : CustomerType.values()) {
			if (id.equals(ct.getId())) return ct;
		}
		
		throw new IllegalArgumentException("Id inválido: " + id);
	}
}
