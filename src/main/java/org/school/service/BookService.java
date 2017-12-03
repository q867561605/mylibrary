package org.school.service;

import java.util.List;

import org.school.model.Book;

public interface BookService {
	int delete(String isbn);

	int insert(Book record);

	Book select(String isbn);
	
	List<Book> selectAll();

	int update(Book record);
	
	List<Book> selectSome(String some);
}
