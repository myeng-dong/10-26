package com.kh.product.product.domain.SVC;


import com.kh.product.product.domain.DAO.Entity.Product;
import com.kh.product.product.domain.DAO.ProductDAO;
import com.kh.product.product.web.form.ProductForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductSVCIM implements ProductSVC{
  private final ProductDAO productDAO;

  @Override
  public Boolean insert(Product product) {
    return productDAO.insert(product);
  }

  @Override
  public List<Product> findALl() {
    return productDAO.findALl();
  }

  @Override
  public Product findById(Long pid) {
    return productDAO.findById(pid);
  }

  @Override
  public Boolean delete(Long pid) {
    return productDAO.delete(pid);
  }

  @Override
  public Boolean update(ProductForm productForm) {
    return productDAO.update(productForm);
  }
}
