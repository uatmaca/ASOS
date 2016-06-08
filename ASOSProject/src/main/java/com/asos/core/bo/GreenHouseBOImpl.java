package com.asos.core.bo;

import com.asos.core.dao.GreenHouseDAO;
import com.asos.core.entity.GreenHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

/**
 * Created by Umut on 28.12.2015.
 */
@Service("greenHouseBO")
public class GreenHouseBOImpl implements GreenHouseBO {

    @Autowired
    private GreenHouseDAO greenHouseDAO;

    @Override
    @Transactional
    public void addGreenHouse(GreenHouse greenHouse) {
        greenHouseDAO.addGreenHouse(greenHouse);
    }

    @Override
    @Transactional
    public List<GreenHouse> getAllGreenHouses() {
        return greenHouseDAO.getAllGreenHouses();
    }

    @Override
    @Transactional
    public void deleteGreenHouse(Long greenHouseId){
        greenHouseDAO.deleteGreenHouse(greenHouseId);
    }

    @Override
    @Transactional
    public List<GreenHouse> getUserGreenHousesByUserId(Long userId) {
        return greenHouseDAO.getUserGreenHousesByUserId(userId);
    }

    @Override
    @Transactional
    public GreenHouse getGreenHouseByGreenHouseId(Long greenHouseId) {
        return greenHouseDAO.getGreenHouseByGreenHouseId(greenHouseId);
    }
}
