package com.asos.core.bo;

import com.asos.core.dao.TemperatureInfoDAO;
import com.asos.core.entity.TemperatureInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Umut on 4.1.2016.
 */
@Service("temperatureInfoBO")
public class TemperatureInfoBOImpl implements TemperatureInfoBO {

    @Autowired
    private TemperatureInfoDAO temperatureInfoDAO;

    @Override
    @Transactional
    public void addTemperatureInfo(TemperatureInfo temperatureInfo) {
        temperatureInfoDAO.addTemperatureInfo(temperatureInfo);
    }

    @Override
    @Transactional
    public List<TemperatureInfo> getAllTemperatureInfo() {
        return temperatureInfoDAO.getAllTemperatureInfo();
    }

    @Override
    @Transactional
    public void deleteTemperatureInfo(Long temperatureInfoId) {
        temperatureInfoDAO.deleteTemperatureInfo(temperatureInfoId);
    }

    @Override
    @Transactional
    public List<TemperatureInfo> getTemperatureInfosGreenHouseId(Long greenHouseId) {
        if (greenHouseId == null)
            return null;
        return temperatureInfoDAO.getTemperatureInfosByGreenHouseId(greenHouseId);
    }
}
