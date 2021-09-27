package com.kevin.xing.library.dao;

import com.kevin.xing.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Integer> {

    List<Book> findListByCategoryId(Integer categoryId);

    List<Book> findAllByTitleLikeOrAuthorLike(String keyword1, String keyword2);
}
