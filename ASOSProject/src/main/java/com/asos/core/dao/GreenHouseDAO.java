package com.asos.core.dao;

import com.asos.core.entity.DumpInfo;
import com.asos.core.entity.GreenHouse;

import java.util.List;

/**
 * Created by Umut on 28.12.2015.
 */
public interface GreenHouseDAO {

    public void addGreenHouse(GreenHouse greenHouse);
    public List<GreenHouse> getAllGreenHouses();
    public void deleteGreenHouse(Long greenHouseId);
    public List<GreenHouse> getUserGreenHousesByUserId(Long userId);
    public GreenHouse getGreenHouseByGreenHouseId(Long greenHouseId);
}
