package com.niit.musicback.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Suppliers {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int supplierid;
	@NotNull
	private String suppliername;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(referencedColumnName="categoryid")
	private Category category;
	private int supplierstock;
	public int getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getSupplierstock() {
		return supplierstock;
	}
	public void setSupplierstock(int supplierstock) {
		this.supplierstock = supplierstock;
	}
	
}	