package com.asos.core.entity;

import org.hibernate.annotations.Type;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by Umut on 4.1.2016.
 */
@Entity
@Table(name = "TEMPERATURE_INFO")
public class TemperatureInfo {

    @Id
    @Column(name = "TEMPERATURE_INFO_ID", unique = true, nullable = false, precision = 5, scale = 0)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tempInfoId;

    @Column(name = "TEMPERATURE_VALUE")
    private Double tempValue;

    @Column(name = "TEMPERATURE_MEASUREMENT_DATE")
    @Type(type = "date")
    private Date tempMeasurementDate;

    @ManyToOne
    @JoinColumn(name="greenHouseId")
    private GreenHouse greenHouse;

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
