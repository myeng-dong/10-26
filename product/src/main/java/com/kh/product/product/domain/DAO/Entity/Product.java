package com.kh.product.product.domain.DAO.Entity;

import lombok.Data;

@Data
public class Product {
  private Long product_id;
  private String pname;
  private Long quantity;
  private Long price;
}
