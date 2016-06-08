package com.asos.core.beanui;

import com.asos.core.beancontroller.ProductBeanController;
import com.asos.core.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * Created by Umut on 18.2.2016.
 */
@Component
@ManagedBean(name = "productListView")
@ViewScoped
public class ProductListView {

    List<Product> products;

    @Autowired
    private ProductBeanController productBeanController;

    @PostConstruct
    public void init(){ products = productBeanController.getAllProducts();}

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> productList) {
        this.products = productList;
    }
}
