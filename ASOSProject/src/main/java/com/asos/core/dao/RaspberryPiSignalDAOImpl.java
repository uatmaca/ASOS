package com.asos.core.dao;

import com.asos.core.entity.RaspberryPiSignal;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Umut on 16.4.2016.
 */
@Repository("raspberryPiSignalDAO")
public class RaspberryPiSignalDAOImpl implements RaspberryPiSignalDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addSignal(RaspberryPiSignal raspberryPiSignal) {
        this.sessionFactory.getCurrentSession().save(raspberryPiSignal);
    }

    @Override
    public RaspberryPiSignal getLastSignal(Long greenHouseId) {

        String hql = "from RaspberryPiSignal r where r.greenHouse.greenHouseId = :greenHouseId order by SIGNAL_ID desc LIMIT 1";

        return ((List<RaspberryPiSignal>) this.sessionFactory.getCurrentSession().createQuery(hql).setParameter("greenHouseId", greenHouseId).list()).get(0);

        //Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(RaspberryPiSignal.class);
        //criteria.add(Restrictions.eq("greenHouse.greenHouseId", greenHouseId));

        //return ((List<RaspberryPiSignal>) criteria.list()).get(0);
    }
}
