package com.niit.musicback.dao;

import java.util.List;
import com.niit.musicback.model.Suppliers;

public interface SupplierDao {

	public boolean addSupplier(Suppliers supplier);
	public boolean updateSupplier(Suppliers supplier);
	public boolean deleteSupplier(Suppliers supplier);
	public Suppliers getSupplier(int supplierid);
	public List<Suppliers> list();
	public List<Suppliers> listSupplierByCategoryId(int categoryid);
}
