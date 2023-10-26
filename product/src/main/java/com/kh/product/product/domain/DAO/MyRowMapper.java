package com.kh.product.product.domain.DAO;

import com.kh.product.product.domain.DAO.Entity.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyRowMapper implements RowMapper<Product> {

  @Override
  public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
    Product product = new Product();
    product.setProduct_id(rs.getLong("product_id"));
    product.setPname(rs.getString("pname"));
    product.setQuantity(rs.getLong("quantity"));
    product.setPrice(rs.getLong("price"));

    return product;
  }
}
