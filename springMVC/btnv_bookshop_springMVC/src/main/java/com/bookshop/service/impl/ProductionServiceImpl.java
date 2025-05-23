package com.bookshop.service.impl;

import com.bookshop.dao.ProductionDao;
import com.bookshop.model.ProductionModel;
import com.bookshop.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductionServiceImpl implements ProductionService {

    @Autowired
    private ProductionDao productionDao;


    @Override
    public List<ProductionModel> getProductions() {
        return productionDao.getProduction();
    }

    @Override
    public ProductionModel findById(Integer id) {
        return productionDao.findById(id);
    }

    public static void main(String[] args) {

        List<ProductionModel> models = new ArrayList<ProductionModel>();
        for (ProductionModel product: models) {
            System.out.printf(product.getTitle());
            System.out.println(product.getPrice());
            System.out.println(product.getId());
        }

    }
}
