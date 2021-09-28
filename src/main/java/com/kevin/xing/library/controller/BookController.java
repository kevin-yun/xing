package com.kevin.xing.library.controller;

import com.kevin.xing.configProperties.XingProperties;
import com.kevin.xing.library.model.Book;
import com.kevin.xing.library.service.BookService;
import com.kevin.xing.result.Result;
import com.kevin.xing.utils.DateUtils;
import com.kevin.xing.utils.RandomNumUtils;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Resource
    private BookService bookService;

    @Resource
    private XingProperties xingProperties;

    @RequestMapping(value = "/findList")
    @ResponseBody
    public Result findList(){
        try {
            List<Book> list = bookService.findList();
            return new Result(true, list);
        } catch (Exception e) {
            return new Result(false, e.getMessage());
        }
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public Result addOrUpdateBook(@RequestBody Book book) {
        try {
            bookService.addOrUpdateBook(book);
            return new Result();
        } catch (Exception e) {
            return new Result(false, e.getMessage());
        }
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public Result delete(@RequestBody Book book) {
        try {
            bookService.deleteBook(book.getId());
            return new Result();
        } catch (Exception e) {
            return new Result(false, e.getMessage());
        }
    }

    @RequestMapping("/findListByCategoryId")
    @ResponseBody
    public Result findListByCategoryId(@RequestBody Book book) {
        try {
            List<Book> list = bookService.findListByCategoryId(book.getCategoryId());
            return new Result(true, list);
        } catch (Exception e) {
            return new Result(false, e.getMessage());
        }
    }

    @RequestMapping("/search")
    @ResponseBody
    public Result searchResult(@RequestBody Map<String, String> paramsMap) {
        try {
            String str = paramsMap.get("keywords");
            List<Book> list = bookService.Search(str);
            return new Result(true, list);
        } catch (Exception e) {
            return new Result(false, e.getMessage());
        }
    }

    @RequestMapping("/uploadImg")
    @ResponseBody
    public Result uploadImg(MultipartFile file) {
        String folder = xingProperties.getFileUrl();
        String currMonth = DateUtils.getFormatDate(new Date(), "yyyy-MM");
        File imageFolder = new File(folder + currMonth);
        File f = new File(imageFolder, RandomNumUtils.getUUID() + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8443/api/book/file/" + currMonth + "/" + f.getName();
            return new Result(true, imgURL);
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(false, e.getMessage());
        }
    }
}
