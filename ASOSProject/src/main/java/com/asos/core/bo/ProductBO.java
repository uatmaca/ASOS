package com.asos.core.bo;

import com.asos.core.entity.Product;

import java.util.List;

/**
 * Created by Umut on 18.2.2016.
 */
public interface ProductBO {

    public void addProduct(Product product);
    public List<Product> getAllProducts();
    public Product deleteProduct(Long productId);
    public Product getProductById(Long productId);
}
