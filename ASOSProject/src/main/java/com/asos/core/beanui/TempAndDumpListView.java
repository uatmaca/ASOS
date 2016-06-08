package com.asos.core.beanui;

import com.asos.core.beancontroller.GreenHouseBeanController;
import com.asos.core.beancontroller.UserBeanController;
import com.asos.core.entity.DumpInfo;
import com.asos.core.entity.GreenHouse;
import com.asos.core.entity.TemperatureInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Umut on 6.5.2016.
 */
@Component
@ManagedBean(name = "tempAndDumpListView")
@ViewScoped
public class TempAndDumpListView {

    private List<DumpInfo> dumpInfos;
    private List<TemperatureInfo> temperatureInfos;

    @Autowired
    private UserBeanController userBeanController;

    public void init(){

        Set<GreenHouse> greenHouses = userBeanController.getSessionUser().getGreenHouses();
        Iterator iter = greenHouses.iterator();

        dumpInfos = new ArrayList<DumpInfo>();
        temperatureInfos = new ArrayList<TemperatureInfo>();

        GreenHouse greenHouse;

        while(iter.hasNext()){
            greenHouse = (GreenHouse) iter.next();
            dumpInfos.addAll(greenHouse.getDumpInfos());
            temperatureInfos.addAll(greenHouse.getTemperatureInfos());
        }
    }

    public List<DumpInfo> getDumpInfos() {
        return dumpInfos;
    }

    public void setDumpInfos(List<DumpInfo> dumpInfos) {
        this.dumpInfos = dumpInfos;
    }

    public List<TemperatureInfo> getTemperatureInfos() {
        return temperatureInfos;
    }

    public void setTemperatureInfos(List<TemperatureInfo> temperatureInfos) {
        this.temperatureInfos = temperatureInfos;
    }
}
