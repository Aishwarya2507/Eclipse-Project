package com.productCrudApp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.productCrudApp.model.Product;
import org.springframework.orm.hibernate5.HibernateTemplate;
import java.util.List;
import javax.transaction.Transactional;


@Component
public class ProductDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	// Create OR Save Product:
	@Transactional
	public void createProduct(Product product)
	{
		this.hibernateTemplate.save(product);
	}
	
	
	// Get all Products:
	public List<Product> getProducts()
	{
		List<Product> products = this.hibernateTemplate.loadAll(Product.class);
		return products;
		
	}
	
	// Delete Single Product:
	
	@Transactional
	public void deleteProduct(int pid)
	{
		Product prod = this.hibernateTemplate.load(Product.class, pid);
		this.hibernateTemplate.delete(prod);
	}
	
	// Get Single Product:
	public Product getProduct(int pid)
	{
		return this.hibernateTemplate.get(Product.class, pid);
		}
	
	
	
}
