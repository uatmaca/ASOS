package com.asos.core.dao;

import com.asos.core.entity.RaspberryPiSignal;

/**
 * Created by Umut on 16.4.2016.
 */
public interface RaspberryPiSignalDAO {

    public void addSignal(RaspberryPiSignal raspberryPiSignal);
    public RaspberryPiSignal getLastSignal(Long greenHouseId);
}
