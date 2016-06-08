package com.asos.core.dao;

import com.asos.core.entity.GreenHouse;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Umut on 28.12.2015.
 */
@Repository("greenHouseDAO")
public class GreenHouseDAOImpl implements GreenHouseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addGreenHouse(GreenHouse greenHouse) {
        this.sessionFactory.getCurrentSession().save(greenHouse);
    }

    @Override
    public void deleteGreenHouse(Long greenHouseId) {
        GreenHouse greenHouse = (GreenHouse) sessionFactory.getCurrentSession().load(
                GreenHouse.class, greenHouseId);
        if (null != greenHouse) {
            this.sessionFactory.getCurrentSession().delete(greenHouse);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<GreenHouse> getAllGreenHouses() {
        return this.sessionFactory.getCurrentSession().createCriteria(GreenHouse.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    public List<GreenHouse> getUserGreenHousesByUserId(Long userId) {
        String hql = "from GreenHouse g where g.userId = :userId";

        return ((List<GreenHouse>) this.sessionFactory.getCurrentSession().createQuery(hql).setParameter("userId", userId).list());
    }

    @Override
    public GreenHouse getGreenHouseByGreenHouseId(Long greenHouseId) {
        String hql = "from GreenHouse g where g.greenHouseId = :greenHouseId";

        return (GreenHouse)this.sessionFactory.getCurrentSession().createQuery(hql).setParameter("greenHouseId", greenHouseId).list().get(0);
    }
}
