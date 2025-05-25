package com.bookshop.dao.impl;

import com.bookshop.dao.ProductionDao;
import com.bookshop.entity.ProductionEntity;
import com.bookshop.model.ProductionModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("productionHibernateDaoImpl")
public class ProductionHibernateDaoImpl implements ProductionDao {

    private SessionFactory sessionFactory;

    public ProductionHibernateDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<ProductionEntity> getProduction() {
        List<ProductionEntity> productionEntities = new ArrayList<ProductionEntity>();
        try(Session session = sessionFactory.openSession()) {
            String hql = "from ProductionEntity";
            Query query = session.createQuery(hql, ProductionEntity.class);
            productionEntities = query.getResultList();
        }
        return productionEntities;
    }

    @Override
    public ProductionEntity findById(Integer id) {
        ProductionEntity productionEntity = null;
        try(Session session = sessionFactory.openSession()) {
            String hql = "from ProductionEntity where id = :id";
            Query query = session.createQuery(hql,ProductionEntity.class);
            query.setParameter("id", id);
            productionEntity = (ProductionEntity) query.uniqueResult();
        }
        return productionEntity;
    }
}
