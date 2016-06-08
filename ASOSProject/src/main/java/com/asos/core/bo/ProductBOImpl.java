package com.asos.core.bo;

import com.asos.core.dao.ProductDAO;
import com.asos.core.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Umut on 18.2.2016.
 */
@Service("productBO")
public class ProductBOImpl implements ProductBO {

    @Autowired
    private ProductDAO productDAO;

    @Override
    @Transactional
    public void addProduct(Product product) {
        productDAO.addProduct(product);
    }

    @Override
    @Transactional
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Override
    @Transactional
    public Product deleteProduct(Long productId) {
        return productDAO.deleteProduct(productId);
    }

    @Override
    @Transactional
    public Product getProductById(Long productId) {
        return productDAO.getProductById(productId);
    }
}
