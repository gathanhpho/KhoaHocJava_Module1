package com.bookshop.dao;

import com.bookshop.entity.ProductionEntity;

import java.util.List;

public interface ProductionDao {
    public List<ProductionEntity> getProduction();

    ProductionEntity findById(Integer id);
}
