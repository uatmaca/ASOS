package com.asos.core.entity;

import org.hibernate.annotations.Type;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by Umut on 3.1.2016.
 */
@Entity
@Table(name = "DUMP_INFO")
public class DumpInfo {

    @Id
    @Column(name = "DUMP_INFO_ID", unique = true, nullable = false, precision = 5, scale = 0)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dumpInfoId;

    @Column(name = "DUMP_RATE")
    private Double dumpRate;

    @Column(name = "DUMP_MEASUREMENT_DATE")
    @Type(type = "date")
    private Date dumpMeasurementDate;

    @ManyToOne
    @JoinColumn(name="greenHouseId")
    private GreenHouse greenHouse;

    public Long getDumpInfoId() {
        return dumpInfoId;
    }

    public void setDumpInfoId(Long dumpInfoId) {
        this.dumpInfoId = dumpInfoId;
    }

    public Double getDumpRate() {
        return dumpRate;
    }

    public void setDumpRate(Double dumpRate) {
        this.dumpRate = dumpRate;
    }

    public Date getDumpMeasurementDate() {
        return dumpMeasurementDate;
    }

    public void setDumpMeasurementDate(Date dumpMeasurementDate) {
        this.dumpMeasurementDate = dumpMeasurementDate;
    }

    public GreenHouse getGreenHouse() {
        return greenHouse;
    }

    public void setGreenHouse(GreenHouse greenHouse) {
        this.greenHouse = greenHouse;
    }
}
