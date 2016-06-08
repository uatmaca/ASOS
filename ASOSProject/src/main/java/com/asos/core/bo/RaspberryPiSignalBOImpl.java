package com.asos.core.bo;

import com.asos.core.dao.RaspberryPiSignalDAO;
import com.asos.core.entity.RaspberryPiSignal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Umut on 16.4.2016.
 */
@Service("raspberryPiSignalBO")
public class RaspberryPiSignalBOImpl implements RaspberryPiSignalBO{

    @Autowired
    private RaspberryPiSignalDAO raspberryPiSignalDAO;


    @Override
    @Transactional
    public void addSignal(RaspberryPiSignal raspberryPiSignal) {
        raspberryPiSignalDAO.addSignal(raspberryPiSignal);
    }

    @Override
    @Transactional
    public RaspberryPiSignal getLastSignal(Long greenHouseId) {
        return raspberryPiSignalDAO.getLastSignal(greenHouseId);
    }


}
