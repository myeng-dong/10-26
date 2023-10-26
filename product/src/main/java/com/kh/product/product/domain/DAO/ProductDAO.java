package com.kh.product.product.domain.DAO;

import com.kh.product.product.domain.DAO.Entity.Product;
import com.kh.product.product.web.form.ProductForm;

import java.util.List;

public interface ProductDAO {
  Boolean insert(Product product);

  List<Product> findALl();

  Product findById(Long pid);

  Boolean delete(Long pid);

  Boolean update(ProductForm productForm);
}
