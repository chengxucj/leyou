package com.leyou.item.controller;

import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    //@RequestMapping(value ="list",method = RequestMethod.GET)
    @GetMapping("list") //根据分类的父id查询分类对象
    public ResponseEntity<List<Category>> queryByParentId(@RequestParam("pid")Long id){

        List<Category> categories = this.categoryService.queryByParentId(id);
        if (categories != null && 0!=categories.size()) {
            return ResponseEntity.ok(categories);//返回list集合同时返回状态码200
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
