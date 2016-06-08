package com.asos.core.beancontroller;

import com.asos.core.bo.RaspberryPiSignalBO;
import com.asos.core.entity.RaspberryPiSignal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Umut on 17.4.2016.
 */
@Component
public class RaspberryPiSignalBeanController {

    @Autowired
    private RaspberryPiSignalBO raspberryPiSignalBO;

    public void addSignal(RaspberryPiSignal raspberryPiSignal){
        raspberryPiSignalBO.addSignal(raspberryPiSignal);
    }

    public RaspberryPiSignal getLastSignal(Long greenHouseId){
        return raspberryPiSignalBO.getLastSignal(greenHouseId);
    }


}
