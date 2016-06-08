package com.asos.core.dao;

import com.asos.core.entity.Product;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Umut on 18.2.2016.
 */
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addProduct(Product product) {
        this.sessionFactory.getCurrentSession().save(product);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> getAllProducts() {
        return this.sessionFactory.getCurrentSession().createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    public Product deleteProduct(Long productId) {
        Product product = (Product) sessionFactory.getCurrentSession().load(
                Product.class, productId);
        if (null != product) {
            this.sessionFactory.getCurrentSession().delete(product);
            return product;
        }
        return null;
    }

    @Override
    public Product getProductById(Long productId) {
        String hql = "from Product p where p.productId= :productId";

        return ((List<Product>) this.sessionFactory.getCurrentSession().createQuery(hql).setParameter("productId", productId).list()).get(0);
    }
}
