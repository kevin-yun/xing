package com.kevin.xing.library.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kevin.xing.library.model.Book;
import com.kevin.xing.library.service.BookService;
import com.kevin.xing.result.Result;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Resource
    private BookService bookService;

    @RequestMapping(value = "/findList")
    @ResponseBody
    public Result findList(){
        try {
            List<Book> list = bookService.findList();
            return new Result(list);
        } catch (Exception e) {
            return new Result(e.getMessage());
        }
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public Result addOrUpdateBook(@RequestBody Book book) {
        try {
            bookService.addOrUpdateBook(book);
            return new Result();
        } catch (Exception e) {
            return new Result(e.getMessage());
        }
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public Result delete(@RequestBody Book book) {
        try {
            bookService.deleteBook(book.getId());
            return new Result();
        } catch (Exception e) {
            return new Result(e.getMessage());
        }
    }

    @RequestMapping("/findListByCategoryId")
    @ResponseBody
    public Result findListByCategoryId(@RequestBody Book book) {
        try {
            List<Book> list = bookService.findListByCategoryId(book.getCategoryId());
            return new Result(list);
        } catch (Exception e) {
            return new Result(e.getMessage());
        }
    }

    @RequestMapping("/search")
    @ResponseBody
    public Result searchResult(@RequestBody Map<String, String> paramsMap) {
        try {
            String str = paramsMap.get("keywords");
            List<Book> list = bookService.Search(str);
            return new Result(list);
        } catch (Exception e) {
            return new Result(e.getMessage());
        }
    }
}
