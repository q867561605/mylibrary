package org.school.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.school.mapper.BookMapper;
import org.school.model.Book;
import org.school.service.BookService;
import org.springframework.stereotype.Service;

@Service("BookService") 
public class BookServiceImpl implements BookService{
	@Resource
	private BookMapper bookMapper;

	@Override
	public int delete(String isbn) {
		int result = bookMapper.delete(isbn);
		return result;
	}

	@Override
	public int insert(Book record) {
		int result = bookMapper.insert(record);
		return result;
	}

	@Override
	public Book select(String isbn) {
		Book book = select(isbn);
		return book;
	}

	@Override
	public int update(Book record) {
		int result = bookMapper.update(record);
		return result;
	}

	@Override
	public List<Book> selectAll() {
		List<Book> bookList = bookMapper.selectAll();
		return bookList;
	}

}
