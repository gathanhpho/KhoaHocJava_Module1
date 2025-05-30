package com.bookshop.dao.impl;

import com.bookshop.dao.UserDao;
import com.bookshop.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository("userHibernateDaoImpl")
public class UserHibernateDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    public UserHibernateDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long coutUserRole(String userName, String roleName) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "select distinct count(distinct u) from UserEntity u join u.roles r where 1 = 1";
            if (StringUtils.hasLength(userName)) {
                hql += " and u.username like :userName";
            }
            if (StringUtils.hasLength(roleName)) {
                hql += " and r.name like :roleName";
            }
            Query query = session.createQuery(hql);
            return (Long) query.uniqueResult();
        }
    }

    @Override
    public List<UserEntity> searchUserPaging(Long limit, Long offset, String userName, String roleName) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "select u from UserEntity u left join u.roles r where 1 = 1";
            if (StringUtils.hasLength(userName)) {
                hql += " and u.username like :userName";
            }
            if (StringUtils.hasLength(roleName)) {
                hql += " and r.name like :roleName";
            }
            Query query = session.createQuery(hql, UserEntity.class);
            query.setFirstResult(Integer.parseInt(String.valueOf(offset)));
            query.setMaxResults(Integer.parseInt(String.valueOf(limit)));
            return query.getResultList();
        }
    }
}
