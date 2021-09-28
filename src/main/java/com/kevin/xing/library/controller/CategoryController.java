package com.kevin.xing.library.controller;

import com.kevin.xing.library.model.Category;
import com.kevin.xing.library.service.CategoryService;
import com.kevin.xing.result.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @RequestMapping(value = "/findList")
    @ResponseBody
    public Result findList(){
        try {
            List<Category> list = categoryService.findList();
            return new Result(true, list);
        } catch (Exception e) {
            return new Result(false, e.getMessage());
        }
    }

    @RequestMapping(value = "/findInfo")
    @ResponseBody
    public Result findInfo(@RequestBody Category category){
        try {
            Category info = categoryService.findInfo(category.getId());
            return new Result(true, info);
        } catch (Exception e) {
            return new Result(false, e.getMessage());
        }
    }
}
