package com.asos.core.bo;

import com.asos.core.entity.RaspberryPiSignal;

/**
 * Created by Umut on 16.4.2016.
 */
public interface RaspberryPiSignalBO {

    public void addSignal(RaspberryPiSignal raspberryPiSignal);
    public RaspberryPiSignal getLastSignal(Long greenHouseId);
}
