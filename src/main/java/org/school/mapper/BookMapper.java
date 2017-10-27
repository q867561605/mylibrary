package org.school.mapper;


import java.util.List;

import org.school.model.Book;

public interface BookMapper {
    int delete(String isbn);

    int insert(Book record);

    Book select(String isbn);

    List<Book> selectAll();
    
    int update(Book record);
}