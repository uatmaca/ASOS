package com.asos.core.beancontroller;

import com.asos.core.bo.GreenHouseBO;
import com.asos.core.entity.GreenHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Umut on 13.1.2016.
 */
@Component
public class GreenHouseBeanController {

    @Autowired
    private GreenHouseBO greenHouseBO;

    public List<GreenHouse> getAllGreenHouses() {return greenHouseBO.getAllGreenHouses();}

    public List<GreenHouse> getUserGreenHousesByUserId(Long userId){
        return greenHouseBO.getUserGreenHousesByUserId(userId);
    }

    public GreenHouse getGreenHouseByGreenHouseId(Long greenHouseId){
        return greenHouseBO.getGreenHouseByGreenHouseId(greenHouseId);
    }

    public void addNewGreenHouse(GreenHouse greenHouse){
        greenHouseBO.addGreenHouse(greenHouse);
    }

}
