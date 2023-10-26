package com.kh.product.product.web.form;

import lombok.Data;

@Data
public class ProductForm {
  private Long product_id;
  private String pname;
  private Long quantity;
  private Long price;
}
