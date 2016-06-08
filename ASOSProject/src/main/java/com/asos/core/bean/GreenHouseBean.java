package com.asos.core.bean;

import com.asos.core.beancontroller.GreenHouseBeanController;
import com.asos.core.entity.*;
import com.asos.core.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.*;

/**
 * Created by Umut on 21.1.2016.
 */
@Component
@ManagedBean(name = "greenHouseBean")
@SessionScoped
public class GreenHouseBean {


    private Long greenHouseId;
    private String greenHouseName;
    private String greenHouseCity;
    private String greenHouseDistrict;
    private Product product;
    private Date setUpSystemDate;
    private User user;
    private Set<TemperatureInfo> temperatureInfos;
    private Set<DumpInfo> dumpInfos;

    @Autowired
    private GreenHouseBeanController greenHouseBeanController;

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

    public String goGreenHouseInfo() {

        Map<String,String> params = HttpUtil.getExternalContext().getRequestParameterMap();
        String paramGreenHouseId = params.get("paramGreenHouseId");

        Long greenHouseId = Long.parseLong(paramGreenHouseId);

        GreenHouse greenHouse = greenHouseBeanController.getGreenHouseByGreenHouseId(greenHouseId);

        if (greenHouse == null)
            return "user_green_house_list";

        this.greenHouseId = greenHouse.getGreenHouseId();
        this.greenHouseName = greenHouse.getGreenHouseName();
        this.greenHouseCity = greenHouse.getGreenHouseCity();
        this.greenHouseDistrict = greenHouse.getGreenHouseDistrict();
        this.product = greenHouse.getProduct();
        this.setUpSystemDate = greenHouse.getSetUpSystemDate();
        this.user = greenHouse.getUser();
        this.dumpInfos = greenHouse.getDumpInfos();
        this.temperatureInfos = greenHouse.getTemperatureInfos();

        return "user_green_house_info";
    }
}
