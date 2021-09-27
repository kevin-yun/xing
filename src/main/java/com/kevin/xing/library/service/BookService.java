package com.kevin.xing.library.service;

import com.kevin.xing.library.dao.BookDao;
import com.kevin.xing.library.model.Book;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Resource
    private BookDao bookDao;

    @Resource
    private CategoryService categoryService;

    public List<Book> findList() {
        List<Sort.Order> orders = new ArrayList<>();
        orders.add(Sort.Order.desc("id"));
        return bookDao.findAll(Sort.by(orders));
    }

    public void addOrUpdateBook(Book book) {
        // 当主键存在时更新数据，当主键不存在时插入数据
        bookDao.save(book);
    }

    public void deleteBook(int id) {
        bookDao.deleteById(id);
    }

    public List<Book> findListByCategoryId(int categoryId) {
        List<Book> list = null;
        if (categoryId == 0) {
            list = bookDao.findAll();
        } else {
            list = bookDao.findListByCategoryId(categoryId);
        }
        return list;
    }

    public List<Book> Search(String keywords) {
        List<Book> list = null;
        if (StringUtils.isEmpty(keywords)) {
            list = bookDao.findAll();
        } else {
            list = bookDao.findAllByTitleLikeOrAuthorLike('%' + keywords + '%', '%' + keywords + '%');
        }
        return list;
    }
}
