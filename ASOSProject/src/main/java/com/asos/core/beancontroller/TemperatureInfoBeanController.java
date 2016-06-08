package com.asos.core.beancontroller;

import com.asos.core.bo.TemperatureInfoBO;
import com.asos.core.entity.TemperatureInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Umut on 27.2.2016.
 */
@Component
public class TemperatureInfoBeanController {

    @Autowired
    private TemperatureInfoBO temperatureInfoBO;


    public List<TemperatureInfo> getAllTemperatureInfos() {
        return temperatureInfoBO.getAllTemperatureInfo();
    }

    public List<TemperatureInfo> getTemperatureInfosByGreenHouseId(Long greenHouseId) {
        return temperatureInfoBO.getTemperatureInfosGreenHouseId(greenHouseId);
    }

}
