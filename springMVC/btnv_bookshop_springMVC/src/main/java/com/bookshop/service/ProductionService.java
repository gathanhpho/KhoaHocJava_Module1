package com.bookshop.service;

import com.bookshop.entity.ProductionEntity;
import com.bookshop.model.ProductionModel;

import java.util.List;

public interface ProductionService {
    public List<ProductionEntity> getProductions();

    ProductionEntity findById(Integer id);
}
