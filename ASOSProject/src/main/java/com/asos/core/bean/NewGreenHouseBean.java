package com.asos.core.bean;

import com.asos.core.beancontroller.GreenHouseBeanController;
import com.asos.core.beancontroller.ProductBeanController;
import com.asos.core.beancontroller.UserBeanController;
import com.asos.core.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Umut on 19.2.2016.
 */
@Component
@ManagedBean(name = "newGreenHouseBean")
@ViewScoped
public class NewGreenHouseBean {

    private Long greenHouseId;
    private String greenHouseName;
    private String greenHouseCity;
    private String greenHouseDistrict;
    private Product product;
    private Date setUpSystemDate;
    private User user;
    private Set<DumpInfo> dumpInfos;
    private Set<TemperatureInfo> temperatureInfos;

    private List<Product> products;
    private List<User> users;

    @PostConstruct
    public void init(){
        users = userBeanController.getAllUsers();
        products = productBeanController.getAllProducts();
    }


    @Autowired
    private GreenHouseBeanController greenHouseBeanController;

    @Autowired
    private UserBeanController userBeanController;

    @Autowired
    private ProductBeanController productBeanController;


    public Long getGreenHouseId() {
        return greenHouseId;
    }

    public void setGreenHouseId(Long greenHouseId) {
        this.greenHouseId = greenHouseId;
    }

    public String getGreenHouseName() {
        return greenHouseName;
    }

    public void setGreenHouseName(String greenHouseName) {
        this.greenHouseName = greenHouseName;
    }

    public String getGreenHouseCity() {
        return greenHouseCity;
    }

    public void setGreenHouseCity(String greenHouseCity) {
        this.greenHouseCity = greenHouseCity;
    }

    public String getGreenHouseDistrict() {
        return greenHouseDistrict;
    }

    public void setGreenHouseDistrict(String greenHouseDistrict) {
        this.greenHouseDistrict = greenHouseDistrict;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getSetUpSystemDate() {
        return setUpSystemDate;
    }

    public void setSetUpSystemDate(Date setUpSystemDate) {
        this.setUpSystemDate = setUpSystemDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<DumpInfo> getDumpInfos() {
        return dumpInfos;
    }

    public void setDumpInfos(Set<DumpInfo> dumpInfos) {
        this.dumpInfos = dumpInfos;
    }

    public Set<TemperatureInfo> getTemperatureInfos() {
        return temperatureInfos;
    }

    public void setTemperatureInfos(Set<TemperatureInfo> temperatureInfos) {
        this.temperatureInfos = temperatureInfos;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public GreenHouseBeanController getGreenHouseBeanController() {
        return greenHouseBeanController;
    }

    public void setGreenHouseBeanController(GreenHouseBeanController greenHouseBeanController) {
        this.greenHouseBeanController = greenHouseBeanController;
    }

    public UserBeanController getUserBeanController() {
        return userBeanController;
    }

    public void setUserBeanController(UserBeanController userBeanController) {
        this.userBeanController = userBeanController;
    }

    public ProductBeanController getProductBeanController() {
        return productBeanController;
    }

    public void setProductBeanController(ProductBeanController productBeanController) {
        this.productBeanController = productBeanController;
    }


    public void addGreenHouse(){
        GreenHouse greenHouse = new GreenHouse();

        greenHouse.setGreenHouseId(greenHouseId);
        greenHouse.setGreenHouseName(greenHouseName);
        greenHouse.setGreenHouseCity(greenHouseCity);
        greenHouse.setGreenHouseDistrict(greenHouseDistrict);
        greenHouse.setProduct(product);
        greenHouse.setSetUpSystemDate(setUpSystemDate);
        greenHouse.setUser(user);
        greenHouse.setTemperatureInfos(temperatureInfos);
        greenHouse.setDumpInfos(dumpInfos);

        greenHouseBeanController.addNewGreenHouse(greenHouse);

        greenHouse.setGreenHouseId(null);
        greenHouse.setGreenHouseName(null);
        greenHouse.setGreenHouseCity(null);
        greenHouse.setGreenHouseDistrict(null);
        greenHouse.setProduct(null);
        greenHouse.setSetUpSystemDate(null);
        greenHouse.setUser(null);
        greenHouse.setTemperatureInfos(null);
        greenHouse.setDumpInfos(null);
    }
}
