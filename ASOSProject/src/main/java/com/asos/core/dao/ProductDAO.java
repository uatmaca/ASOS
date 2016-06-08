package com.asos.core.dao;

import com.asos.core.entity.Product;

import java.util.List;

/**
 * Created by Umut on 18.2.2016.
 */
public interface ProductDAO {

    public void addProduct(Product product);
    public List<Product> getAllProducts();
    public Product deleteProduct(Long productId);
    public Product getProductById(Long productId);
}
