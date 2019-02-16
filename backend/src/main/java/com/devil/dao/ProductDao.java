package com.devil.dao;

import java.util.List;

import com.devil.models.Category;
import com.devil.models.Product;

public interface ProductDao {
	void addProduct(Product product);
	Product getProduct(int id);
	void deleteProduct(int id);
	void update(Product product);
	List<Product> getAllProducts();
	List<Product> getCategoryProducts(String category);
	void saveOrUpdate(Product product);
	List<Category> getAllCategories();
}
