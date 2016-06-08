package com.asos.core.dao;

import com.asos.core.entity.TemperatureInfo;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Umut on 4.1.2016.
 */
@Repository("temperatureInfoDAO")
public class TemperatureInfoDAOImpl implements TemperatureInfoDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addTemperatureInfo(TemperatureInfo temperatureInfo) {
        this.sessionFactory.getCurrentSession().save(temperatureInfo);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TemperatureInfo> getAllTemperatureInfo() {
        return this.sessionFactory.getCurrentSession().createCriteria(TemperatureInfo.class).list();
    }

    @Override
    public void deleteTemperatureInfo(Long temperatureInfoId) {
        TemperatureInfo temperatureInfo = (TemperatureInfo) sessionFactory.getCurrentSession().load(
                TemperatureInfo.class, temperatureInfoId);
        if (null != temperatureInfo) {
            this.sessionFactory.getCurrentSession().delete(temperatureInfo);
        }
    }

    @Override
    public List<TemperatureInfo> getTemperatureInfosByGreenHouseId(Long greenHouseId) {
        return (List<TemperatureInfo>) this.sessionFactory.getCurrentSession().createCriteria(TemperatureInfo.class).createAlias("greenHouse", "g")
                .add(Restrictions.eq("g.greenHouseId", greenHouseId)).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

    }
}
