package com.asos.core.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Umut on 3.2.2016.
 */
@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @Column(name = "PRODUCT_ID", unique = true, nullable = false, precision = 5, scale = 0)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "PRODUCT_NAME", length = 20)
    private String productName;

    @Column(name = "MIN_PRODUCT_TEMPERATURE")
    private double minProductTemp;

    @Column(name = "MAX_PRODUCT_TEMPERATURE")
    private double maxProductTemp;

    @Column(name = "MIN_PRODUCT_DUMP")
    private int minProductDump;

    @Column(name = "MAX_PRODUCT_DUMP")
    private int maxProductDump;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    private Set<GreenHouse> greenHouses;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
}
