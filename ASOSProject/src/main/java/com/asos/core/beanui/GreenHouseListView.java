package com.asos.core.beanui;

import com.asos.core.beancontroller.GreenHouseBeanController;
import com.asos.core.entity.GreenHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * Created by Umut on 13.1.2016.
 */
@Component
@ManagedBean(name = "greenHouseListView")
@ViewScoped
public class GreenHouseListView {

    List<GreenHouse> greenHouses;

    @Autowired
    private GreenHouseBeanController greenHouseBeanController;

    @PostConstruct
    public void init(){ greenHouses = greenHouseBeanController.getAllGreenHouses();}

    public List<GreenHouse> getGreenHouses() {
        return greenHouses;
    }

    public void setGreenHouses(List<GreenHouse> greenHouses) {
        this.greenHouses = greenHouses;
    }
}
