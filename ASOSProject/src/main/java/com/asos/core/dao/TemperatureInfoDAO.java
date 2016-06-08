package com.asos.core.dao;

import com.asos.core.entity.TemperatureInfo;

import java.util.List;

/**
 * Created by Umut on 4.1.2016.
 */
public interface TemperatureInfoDAO {

    public void addTemperatureInfo(TemperatureInfo temperatureInfo);
    public List<TemperatureInfo> getAllTemperatureInfo();
    public void deleteTemperatureInfo(Long temperatureInfoId);
    public List<TemperatureInfo> getTemperatureInfosByGreenHouseId(Long greenHouseId);

}
