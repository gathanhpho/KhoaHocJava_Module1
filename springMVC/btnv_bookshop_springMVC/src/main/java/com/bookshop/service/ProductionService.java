package com.bookshop.service;

import com.bookshop.entity.ProductionEntity;
import com.bookshop.model.response.PageResponse;
import com.bookshop.model.response.ProductionResponse;

import java.util.List;

public interface ProductionService {
    public List<ProductionEntity> getProductions();

    ProductionEntity findById(Integer id);

    public PageResponse<List<ProductionEntity>>  getProductionPaging(Long pageIndex, Long pageSize,
                                                                      String title, String author, Integer publicYear, String categoryName);

}
