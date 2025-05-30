package com.bookshop.dao;

import com.bookshop.entity.ProductionEntity;

import java.util.List;

public interface ProductionDao {
    public List<ProductionEntity> getProduction();

    ProductionEntity findById(Integer id);

    public List<ProductionEntity> findProductionPaging(Long limit, Long offset,
                                                       String title,String author,Integer publicYear,String categoryName);
    public Long countProduction(String title,String author,Integer publicYear,String categoryName);
}
