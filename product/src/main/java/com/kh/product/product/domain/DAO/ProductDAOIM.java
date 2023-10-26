package com.kh.product.product.domain.DAO;

import com.kh.product.product.domain.DAO.Entity.Product;
import com.kh.product.product.web.form.ProductForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ProductDAOIM implements ProductDAO{

  private final NamedParameterJdbcTemplate template;

  @Override
  public Boolean insert(Product product) {
    StringBuffer sql = new StringBuffer();
    sql.append("insert into product (product_id,pname,quantity,price) ");
    sql.append("values (product_product_id_seq.nextval, :pname, :quantity, :price)");

    SqlParameterSource param = new BeanPropertySqlParameterSource(product);
    int update = template.update(sql.toString(), param);
    boolean flag = false;
    if (update == 1){
      flag = true;
    } else {
      flag = false;
    }
    return flag;
  }

  @Override
  public List<Product> findALl() {
    String sql = ("select product_id, pname, quantity, price from product");
    List<Product> query = template.query(sql, BeanPropertyRowMapper.newInstance(Product.class));
    return query;
  }

  @Override
  public Product findById(Long pid) {
    String sql = ("select product_Id, pname, quantity, price from product where product_id = :id ");

    MyRowMapper rowMapper = new MyRowMapper();
    log.info("DAOIMPL_pid={}",pid);
    Map<String,Long> param = Map.of("id",pid);
    Product product = template.queryForObject(sql.toString(), param, rowMapper);

    return product;
  }


//  delete from product where product_id = 1;
  @Override
  public Boolean delete(Long pid) {
    String sql = ("delete from product where product_id = :id ");
    Map<String, Long> param = Map.of("id",pid);

    int update = template.update(sql, param);
    boolean flag = false;
    if (update == 1){
      flag = true;
    } else {
      flag = false;
    }
    return flag;
  }

  @Override
  public Boolean update(ProductForm productForm) {
    StringBuffer sql = new StringBuffer();
    sql.append("update product set pname = :pname, quantity = :quantity, price = :price where product_id = :product_id ");

    SqlParameterSource param = new BeanPropertySqlParameterSource(productForm);
    int update = template.update(sql.toString(), param);
    boolean flag = false;
    if (update == 1){
      flag = true;
    } else {
      flag = false;
    }
    return flag;
  }
}
