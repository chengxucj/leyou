package com.leyou.item.controller;

import com.leyou.common.po.PageResult;
import com.leyou.item.pojo.Brand;
import com.leyou.item.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("page")
    public ResponseEntity<PageResult<Brand>> pageQuery(
        @RequestParam(value = "page",defaultValue = "1")Integer page,
        @RequestParam(value = "rows",defaultValue = "10")Integer rows,
        @RequestParam(value = "sortBy",required = false)String sortBy,
        @RequestParam(value = "desc",required = false)Boolean desc,
        @RequestParam(value = "key",required = false)String key){
        PageResult<Brand> brandPageResult = this.brandService.pageQuery(page,rows,sortBy,desc,key);
        //判断分页数据不为空
        if (brandPageResult != null && null!=brandPageResult.getItems() && 0!=brandPageResult.getItems().size()) {
            return ResponseEntity.ok(brandPageResult);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
