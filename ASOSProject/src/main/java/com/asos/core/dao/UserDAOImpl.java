package com.asos.core.dao;

import com.asos.core.entity.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Umut on 22.11.2015.
 */
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        this.sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = (User) sessionFactory.getCurrentSession().load(
                User.class, userId);
        if (null != user) {
            this.sessionFactory.getCurrentSession().delete(user);
        }
    }

    /*Hibernate duplicate sonuç döndüğü için setResultTransformer methodu ile sonuçlar unique oldu*/
    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAllUsers() {
        return this.sessionFactory.getCurrentSession().createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    public List<User> getUserByUserName(String userName) {
        String hql = "from User u where u.userName = :userName";


        return (List<User>)this.sessionFactory.getCurrentSession().createQuery(hql).setParameter("userName", userName).list();
    }

    @Override
    public User getUserByUserId(Long userId) {
        String hql = "from User u where u.userId = :userId";

        return ((List<User>) this.sessionFactory.getCurrentSession().createQuery(hql).setParameter("userId", userId).list()).get(0);
    }

    @Override
    public void saveChange(User user) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(user);
    }
}
