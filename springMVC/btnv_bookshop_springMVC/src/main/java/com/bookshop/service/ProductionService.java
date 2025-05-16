package com.bookshop.service;

import com.bookshop.model.ProductionModel;

import java.util.List;

public interface ProductionService {
    public List<ProductionModel> getProductions();

    ProductionModel findById(Integer id);
}
