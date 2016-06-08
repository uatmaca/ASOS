package com.asos.core.beancontroller;

import com.asos.core.bo.ProductBO;
import com.asos.core.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Umut on 18.2.2016.
 */
@Component
public class ProductBeanController {

    @Autowired
    private ProductBO productBO;

    public void saveProduct(Product product){
        productBO.addProduct(product);
    }

    public List<Product> getAllProducts(){
        return productBO.getAllProducts();
    }

    public Product getProductById(Long productId){
        return productBO.getProductById(productId);
    }
}
