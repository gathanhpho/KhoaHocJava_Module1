package com.bookshop.controller.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductControlle {

    @RequestMapping("/production-detail")
    public String productionDetail() {
        return "production-detail";
    }
}
