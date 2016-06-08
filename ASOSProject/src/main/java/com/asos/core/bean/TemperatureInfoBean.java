package com.asos.core.bean;

import com.asos.core.beancontroller.TemperatureInfoBeanController;
import com.asos.core.entity.GreenHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Date;

/**
 * Created by Umut on 27.2.2016.
 */
@Component
@ManagedBean(name = "temperatureInfoBean")
@SessionScoped
public class TemperatureInfoBean {

    private Long tempInfoId;
    private Double tempValue;
    private Date tempMeasurementDate;
    private GreenHouse greenHouse;


    @Autowired
    private TemperatureInfoBeanController temperatureInfoBeanController;

    public Long getTempInfoId() {
        return tempInfoId;
    }

    public void setTempInfoId(Long tempInfoId) {
        this.tempInfoId = tempInfoId;
    }

    public Double getTempValue() {
        return tempValue;
    }

    public void setTempValue(Double tempValue) {
        this.tempValue = tempValue;
    }

    public Date getTempMeasurementDate() {
        return tempMeasurementDate;
    }

    public void setTempMeasurementDate(Date tempMeasurementDate) {
        this.tempMeasurementDate = tempMeasurementDate;
    }

    public GreenHouse getGreenHouse() {
        return greenHouse;
    }

    public void setGreenHouse(GreenHouse greenHouse) {
        this.greenHouse = greenHouse;
    }
}
