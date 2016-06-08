package com.asos.core.bean;

import com.asos.core.beancontroller.RaspberryPiSignalBeanController;
import com.asos.core.entity.GreenHouse;
import com.asos.core.entity.RaspberryPiSignal;
import com.asos.core.util.GeneralUtil;
import com.asos.core.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Map;

/**
 * Created by Umut on 17.4.2016.
 */
@Component
@ManagedBean(name = "raspberryPiSignalBean")
@SessionScoped
public class RaspberryPiSignalBean {

    private Long signalId;

    private String ventilationSignal;
    private String roofSignal;
    private String wateringSignal;
    private String heatingSignal;
    private GreenHouse greenHouse;

    private Long greenHouseId;

    private boolean booleanRoofSignal;
    private boolean booleanVentilationSignal;
    private boolean booleanWateringSignal;
    private boolean booleanHeatingSignal;

    @Autowired
    private RaspberryPiSignalBeanController raspberryPiSignalBeanController;

    public Long getSignalId() {
        return signalId;
    }

    public void setSignalId(Long signalId) {
        this.signalId = signalId;
    }

    public String getVentilationSignal() {
        return ventilationSignal;
    }

    public void setVentilationSignal(String ventilationSignal) {
        this.ventilationSignal = ventilationSignal;
    }

    public String getRoofSignal() {
        return roofSignal;
    }

    public void setRoofSignal(String roofSignal) {
        this.roofSignal = roofSignal;
    }

    public String getWateringSignal() {
        return wateringSignal;
    }

    public void setWateringSignal(String wateringSignal) {
        this.wateringSignal = wateringSignal;
    }

    public String getHeatingSignal() {
        return heatingSignal;
    }

    public void setHeatingSignal(String heatingSignal) {
        this.heatingSignal = heatingSignal;
    }

    public GreenHouse getGreenHouse() {
        return greenHouse;
    }

    public void setGreenHouse(GreenHouse greenHouse) {
        this.greenHouse = greenHouse;
    }

    public boolean isBooleanRoofSignal() {
        return booleanRoofSignal;
    }

    public void setBooleanRoofSignal(boolean booleanRoofSignal) {
        this.booleanRoofSignal = booleanRoofSignal;
    }

    public boolean isBooleanVentilationSignal() {
        return booleanVentilationSignal;
    }

    public void setBooleanVentilationSignal(boolean booleanVentilationSignal) {
        this.booleanVentilationSignal = booleanVentilationSignal;
    }

    public boolean isBooleanWateringSignal() {
        return booleanWateringSignal;
    }

    public void setBooleanWateringSignal(boolean booleanWateringSignal) {
        this.booleanWateringSignal = booleanWateringSignal;
    }

    public boolean isBooleanHeatingSignal() {
        return booleanHeatingSignal;
    }

    public void setBooleanHeatingSignal(boolean booleanHeatingSignal) {
        this.booleanHeatingSignal = booleanHeatingSignal;
    }

    public RaspberryPiSignalBeanController getRaspberryPiSignalBeanController() {
        return raspberryPiSignalBeanController;
    }

    public void setRaspberryPiSignalBeanController(RaspberryPiSignalBeanController raspberryPiSignalBeanController) {
        this.raspberryPiSignalBeanController = raspberryPiSignalBeanController;
    }

    public Long getGreenHouseId() {
        return greenHouseId;
    }

    public void setGreenHouseId(Long greenHouseId) {
        this.greenHouseId = greenHouseId;
    }

    public void setSignals(){
        RaspberryPiSignal raspberryPiSignal = new RaspberryPiSignal();

        Map<String,String> params = HttpUtil.getExternalContext().getRequestParameterMap();
        String paramGreenHouseId = params.get("paramGreenHouseId");

        Long greenHouseId = Long.parseLong(paramGreenHouseId);

        raspberryPiSignal = raspberryPiSignalBeanController.getLastSignal(greenHouseId);

        this.ventilationSignal = raspberryPiSignal.getVentilationSignal();
        this.roofSignal = raspberryPiSignal.getRoofSignal();
        this.wateringSignal = raspberryPiSignal.getWateringSignal();
        this.heatingSignal = raspberryPiSignal.getHeatingSignal();
        this.greenHouseId = greenHouseId;

        this.booleanVentilationSignal = GeneralUtil.stringToBoolean(this.ventilationSignal);
        this.booleanRoofSignal = GeneralUtil.stringToBoolean(this.roofSignal);
        this.booleanWateringSignal = GeneralUtil.stringToBoolean(this.wateringSignal);
        this.booleanHeatingSignal = GeneralUtil.stringToBoolean(this.heatingSignal);
    }

    public void toggleVentilation(){
        RaspberryPiSignal raspberryPiSignal;

        raspberryPiSignal = raspberryPiSignalBeanController.getLastSignal(this.greenHouseId);


        String value = raspberryPiSignal.getVentilationSignal();

        if (value.equals("1"))
            value = "0";
        else
            value = "1";

        raspberryPiSignal.setVentilationSignal(value);
        this.ventilationSignal = value;
        this.booleanVentilationSignal = Boolean.getBoolean(this.ventilationSignal);

        raspberryPiSignalBeanController.addSignal(raspberryPiSignal);


    }

    public void toggleWatering(){
        RaspberryPiSignal raspberryPiSignal;

        raspberryPiSignal = raspberryPiSignalBeanController.getLastSignal(this.greenHouseId);


        String value = raspberryPiSignal.getWateringSignal();

        if (value.equals("1"))
            value = "0";
        else
            value = "1";

        raspberryPiSignal.setWateringSignal(value);
        this.wateringSignal = value;
        this.booleanWateringSignal = Boolean.getBoolean(this.wateringSignal);

        raspberryPiSignalBeanController.addSignal(raspberryPiSignal);


    }

    public void toggleHeating(){
        RaspberryPiSignal raspberryPiSignal;

        raspberryPiSignal = raspberryPiSignalBeanController.getLastSignal(this.greenHouseId);


        String value = raspberryPiSignal.getHeatingSignal();

        if (value.equals("1"))
            value = "0";
        else
            value = "1";

        raspberryPiSignal.setHeatingSignal(value);
        this.heatingSignal = value;
        this.booleanHeatingSignal = Boolean.getBoolean(this.heatingSignal);

        raspberryPiSignalBeanController.addSignal(raspberryPiSignal);


    }

    public void toggleRoof(){
        RaspberryPiSignal raspberryPiSignal;

        raspberryPiSignal = raspberryPiSignalBeanController.getLastSignal(this.greenHouseId);


        String value = raspberryPiSignal.getRoofSignal();

        if (value.equals("1"))
            value = "0";
        else
            value = "1";

        raspberryPiSignal.setRoofSignal(value);
        this.roofSignal = value;
        this.booleanRoofSignal = Boolean.getBoolean(this.roofSignal);

        raspberryPiSignalBeanController.addSignal(raspberryPiSignal);


    }

}
