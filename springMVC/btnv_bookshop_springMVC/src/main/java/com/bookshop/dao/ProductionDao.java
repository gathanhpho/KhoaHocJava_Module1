package com.bookshop.dao;

import com.bookshop.model.ProductionModel;

import java.util.List;

public interface ProductionDao {
    public List<ProductionModel> getProduction();

    ProductionModel findById(Integer id);
}
