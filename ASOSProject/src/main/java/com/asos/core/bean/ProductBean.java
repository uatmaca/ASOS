package com.asos.core.bean;

import com.asos.core.beancontroller.ProductBeanController;
import com.asos.core.entity.GreenHouse;
import com.asos.core.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.util.Set;

/**
 * Created by Umut on 18.2.2016.
 */
@Component
@ManagedBean(name = "productBean")
@RequestScoped
public class ProductBean {

    private Long productId;

    private String productName;

    private double minProductTemp;

    private double maxProductTemp;

    private int minProductDump;

    private int maxProductDump;

    private Set<GreenHouse> greenHouses;


    @Autowired
    private ProductBeanController productBeanController;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public double getMinProductTemp() {
        return minProductTemp;
    }

    public void setMinProductTemp(double minProductTemp) {
        this.minProductTemp = minProductTemp;
    }

    public double getMaxProductTemp() {
        return maxProductTemp;
    }

    public void setMaxProductTemp(double maxProductTemp) {
        this.maxProductTemp = maxProductTemp;
    }

    public int getMinProductDump() {
        return minProductDump;
    }

    public void setMinProductDump(int minProductDump) {
        this.minProductDump = minProductDump;
    }

    public int getMaxProductDump() {
        return maxProductDump;
    }

    public void setMaxProductDump(int maxProductDump) {
        this.maxProductDump = maxProductDump;
    }

    public Set<GreenHouse> getGreenHouses() {
        return greenHouses;
    }

    public void setGreenHouses(Set<GreenHouse> greenHouses) {
        this.greenHouses = greenHouses;
    }

    public void addProductBean(){
        Product product = new Product();

        product.setProductName(productName);
        product.setMinProductTemp(minProductTemp);
        product.setMaxProductTemp(maxProductTemp);
        product.setMinProductDump(minProductDump);
        product.setMaxProductDump(maxProductDump);

        productBeanController.saveProduct(product);
    }
}
