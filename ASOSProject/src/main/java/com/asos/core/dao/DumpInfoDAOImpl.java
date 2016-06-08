package com.asos.core.dao;

import com.asos.core.entity.DumpInfo;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Umut on 3.1.2016.
 */
@Repository("dumpInfoDAO")
public class DumpInfoDAOImpl implements DumpInfoDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addDumpInfo(DumpInfo dumpInfo) {
        this.sessionFactory.getCurrentSession().save(dumpInfo);
    }

    @Override
    public void deleteDumpInfo(Long dumpInfoId) {
        DumpInfo dumpInfo = (DumpInfo) sessionFactory.getCurrentSession().load(
                DumpInfo.class, dumpInfoId);
        if (null != dumpInfo) {
            this.sessionFactory.getCurrentSession().delete(dumpInfo);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DumpInfo> getAllDumpInfo() {
        return this.sessionFactory.getCurrentSession().createCriteria(DumpInfo.class).list();
    }

    @Override
    public List<DumpInfo> getDumpInfosByGreenHouseId(Long greenHouseId) {
        return (List<DumpInfo>) this.sessionFactory.getCurrentSession().createCriteria(DumpInfo.class).createAlias("greenHouse", "g")
                .add(Restrictions.eq("g.greenHouseId", greenHouseId)).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }
}
