package com.asos.core.entity;

import javax.persistence.*;

/**
 * Created by Umut on 16.4.2016.
 */
@Entity
@Table(name = "RASP_PI_SIGNAL")
public class RaspberryPiSignal {

    @Id
    @Column(name = "SIGNAL_ID", unique = true, nullable = false, precision = 5, scale = 0)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long signalId;

    @Column(name = "VENTILATION_SIGNAL", length = 20)
    private String ventilationSignal;

    @Column(name = "ROOF_SIGNAL", length = 20)
    private String roofSignal;

    @Column(name = "WATERING_SIGNAL", length = 20)
    private String wateringSignal;

    @Column(name = "HEATING_SIGNAL", length = 20)
    private String heatingSignal;

    @ManyToOne
    @JoinColumn(name="greenHouseId")
    private GreenHouse greenHouse;

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
}
