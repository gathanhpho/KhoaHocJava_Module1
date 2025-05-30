package com.bookshop.controller.resources;

import com.bookshop.entity.ProductionEntity;
import com.bookshop.model.response.PageResponse;
import com.bookshop.model.response.ProductionResponse;
import com.bookshop.service.ProductionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductionResource {
    private ProductionService productionService;

    public ProductionResource(ProductionService productionService) {
        this.productionService = productionService;
    }

    @GetMapping(value = "/production", produces = "application/json")
    public ResponseEntity<PageResponse<List<ProductionEntity>>> getAll(@RequestParam(name = "pageSize") Long pageSize,
                                                                         @RequestParam(name = "pageIndex") Long pageIndex,
                                                                         @RequestParam(name = "title", required = false) String title,
                                                                         @RequestParam(name = "author", required = false) String author,
                                                                         @RequestParam(name = "publicationYear", required = false) Integer publicationYear,
                                                                         @RequestParam(name = "categoryName", required = false) String categoryName) {
        PageResponse<List<ProductionEntity>> productionModels = productionService.getProductionPaging(pageIndex, pageSize, title, author, publicationYear, categoryName);
        ResponseEntity<PageResponse<List<ProductionEntity>>> response = new ResponseEntity<>(productionModels, HttpStatus.OK);
        return response;
    }

    @PostMapping("/production")
    public ResponseEntity<ProductionEntity> add(@RequestBody ProductionEntity productionModel) {
        return ResponseEntity.ok(null);
    }
}
