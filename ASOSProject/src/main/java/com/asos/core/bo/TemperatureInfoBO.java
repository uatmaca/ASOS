package com.asos.core.bo;

import com.asos.core.entity.TemperatureInfo;

import java.util.List;

/**
 * Created by Umut on 4.1.2016.
 */
public interface TemperatureInfoBO {

    public void addTemperatureInfo(TemperatureInfo temperatureInfo);
    public List<TemperatureInfo> getAllTemperatureInfo();
    public void deleteTemperatureInfo(Long temperatureInfoId);
    public List<TemperatureInfo> getTemperatureInfosGreenHouseId(Long greenHouseId);
}
