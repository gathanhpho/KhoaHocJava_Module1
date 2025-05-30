package com.bookshop.service.impl;

import com.bookshop.dao.ProductionDao;
import com.bookshop.entity.ProductionEntity;
import com.bookshop.model.ProductionModel;
import com.bookshop.model.response.CategoryResponse;
import com.bookshop.model.response.PageResponse;
import com.bookshop.model.response.ProductionResponse;
import com.bookshop.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductionServiceImpl implements ProductionService {

    @Autowired
    @Qualifier("productionHibernateDaoImpl")
    private ProductionDao productionDao;


    @Override
    public List<ProductionEntity> getProductions() {
        return productionDao.getProduction();
    }

    @Override
    public ProductionEntity findById(Integer id) {
        return productionDao.findById(id);
    }

    @Override
    public PageResponse<List<ProductionEntity>> getProductionPaging(Long pageIndex, Long pageSize,
                                                                      String title, String author, Integer publicYear, String categoryName) {

        // query lấy ra tổng số phần tử
        Long totalProduction = productionDao.countProduction(title,author,publicYear,categoryName);
        // tính tổng số page
        Long totalPage = totalProduction / pageSize;
        if (totalProduction % pageSize > 0) {
            totalPage++;
        }
        // tính offset
        Long offset = (pageIndex - 1) * pageSize;

        // query lấy ra data trong page
        List<ProductionEntity> productionEntities = productionDao.findProductionPaging(pageSize, offset,title,author,publicYear,categoryName);

        List<ProductionResponse> productionResponses = productionEntities.stream()
                .map(data -> {
                    ProductionResponse productionResponse = new ProductionResponse();
                    productionResponse.setId(data.getId());
                    productionResponse.setTitle(data.getTitle());
                    productionResponse.setAuthor(data.getAuthor());
                    productionResponse.setDescription(data.getDescription());
                    productionResponse.setGenre(data.getGenre());
                    productionResponse.setPublisher(data.getPublisher());
                    productionResponse.setPublicationYear(data.getPublicationYear());
                    productionResponse.setPageCount(data.getPageCount());
                    productionResponse.setPrice(data.getPrice());
                    productionResponse.setDiscountPercent(data.getDiscountPercent());
                    productionResponse.setStockQuantity(data.getStockQuantity());
                    CategoryResponse categoryResponse = new CategoryResponse();
                    categoryResponse.setId(data.getCategory().getId());
                    categoryResponse.setCategoryName(data.getCategory().getCategoryName());
                    categoryResponse.setDescription(data.getCategory().getDescription());
                    productionResponse.setCategory(categoryResponse);
                    return productionResponse;
                })
                .collect(Collectors.toList());
        PageResponse<List<ProductionEntity>> pageResponse = new PageResponse<>();
        pageResponse.setMessage("Success");
        pageResponse.setCode(HttpStatus.OK.name());
        pageResponse.setData(productionEntities);
        pageResponse.setPageIndex(pageIndex);
        pageResponse.setPageSize(pageSize);
        pageResponse.setTotalPages(totalPage);
        pageResponse.setTotalElements(totalProduction);
        return pageResponse;
    }

    public static void main(String[] args) {

        List<ProductionModel> models = new ArrayList<ProductionModel>();
        for (ProductionModel product : models) {
            System.out.printf(product.getTitle());
            System.out.println(product.getPrice());
            System.out.println(product.getId());
        }

    }
}
