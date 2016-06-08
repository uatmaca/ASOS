package com.asos.core.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Umut on 27.12.2015.
 */

@Entity
@Table(name = "GREEN_HOUSES")
public class GreenHouse {

    @Id
    @Column(name = "GREEN_HOUSE_ID", unique = true, nullable = false, precision = 5, scale = 0)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long greenHouseId;

    @Column(name = "GREEN_HOUSE_NAME", length = 20)
    private String greenHouseName;

    @Column(name = "GREEN_HOUSE_CITY", length = 20)
    private String greenHouseCity;

    @Column(name = "GREEN_HOUSE_DISTRICT", length = 20)
    private String greenHouseDistrict;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @Column(name = "SET_UP_SYSTEM_DATE")
    @Type(type = "date")
    private Date setUpSystemDate;

    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="greenHouse")
    private Set<TemperatureInfo> temperatureInfos;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="greenHouse")
    private Set<DumpInfo> dumpInfos;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="greenHouse")
    private Set<RaspberryPiSignal> raspberryPiSignals;

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

    public Set<TemperatureInfo> getTemperatureInfos() {
        return temperatureInfos;
    }

    public void setTemperatureInfos(Set<TemperatureInfo> temperatureInfos) {
        this.temperatureInfos = temperatureInfos;
    }

    public Set<DumpInfo> getDumpInfos() {
        return dumpInfos;
    }

    public void setDumpInfos(Set<DumpInfo> dumpInfos) {
        this.dumpInfos = dumpInfos;
    }

    public Set<RaspberryPiSignal> getRaspberryPiSignals() {
        return raspberryPiSignals;
    }

    public void setRaspberryPiSignals(Set<RaspberryPiSignal> raspberryPiSignals) {
        this.raspberryPiSignals = raspberryPiSignals;
    }
}
