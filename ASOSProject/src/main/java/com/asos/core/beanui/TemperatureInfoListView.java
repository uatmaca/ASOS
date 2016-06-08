package com.asos.core.beanui;

import com.asos.core.beancontroller.TemperatureInfoBeanController;
import com.asos.core.entity.TemperatureInfo;
import com.asos.core.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;
import java.util.Map;

/**
 * Created by Umut on 27.2.2016.
 */
@Component
@ManagedBean(name = "temperatureInfoListView")
@ViewScoped
public class TemperatureInfoListView {

    List<TemperatureInfo> temperatureInfos;

    @Autowired
    private TemperatureInfoBeanController temperatureInfoBeanController;

    @PostConstruct
    public void init() {
        temperatureInfos = temperatureInfoBeanController.getTemperatureInfosByGreenHouseId(null);
    }

    public List<TemperatureInfo> getTemperatureInfos() {

        Map<String,String> params = HttpUtil.getExternalContext().getRequestParameterMap();
        String paramGreenHouseId = params.get("paramGreenHouseId");

        Long greenHouseId = Long.parseLong(paramGreenHouseId);

        temperatureInfos = temperatureInfoBeanController.getTemperatureInfosByGreenHouseId(greenHouseId);

        return temperatureInfos;
    }

    public void setTemperatureInfos(List<TemperatureInfo> temperatureInfos) {
        this.temperatureInfos = temperatureInfos;
    }
}
