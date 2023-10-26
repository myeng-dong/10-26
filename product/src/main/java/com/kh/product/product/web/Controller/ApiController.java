package com.kh.product.product.web.Controller;

import com.kh.product.product.domain.DAO.Entity.Product;
import com.kh.product.product.domain.SVC.ProductSVC;
import com.kh.product.product.web.form.ProductForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ApiController {
  private final ProductSVC productSVC;

  @GetMapping
  public ModelAndView start(){
    ModelAndView mv = new ModelAndView();
    mv.setViewName("/product/product");
    return  mv;
  }

  @PostMapping("/add")
  @ResponseBody
  public Boolean insert (
      @RequestBody ProductForm productForm
  ){
    Product product = new Product();
    BeanUtils.copyProperties(productForm,product);
    log.info("product={}", product);
    Boolean insert = productSVC.insert(product);

    return insert;
  }
  @GetMapping("/all")
  @ResponseBody
  public List<Product> findAll(){
    Product product = new Product();
    List<Product> aLl = productSVC.findALl();
    return aLl;
  }

  @GetMapping("/{pid}")
  @ResponseBody
  public Product findById(
      @PathVariable("pid") Long pid
  ){
    Product byId = productSVC.findById(pid);
    return byId;
  }

  @DeleteMapping("/{pid}")
  @ResponseBody
  public Boolean deleteById(
      @PathVariable("pid") Long pid
  ){
    Boolean delete = productSVC.delete(pid);
    return delete;
  }

  @GetMapping("/update")
  public String updateForm(){
    return "product/update";
  }

  @PatchMapping("/update/go")
  @ResponseBody
  public Boolean update(
      @RequestBody ProductForm productForm
  ){
    log.info("productForm={}",productForm);
    Boolean update = productSVC.update(productForm);
    return update;
  }
}
