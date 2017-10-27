package org.school.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.school.model.Book;
import org.school.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller  
@RequestMapping("/book")  
public class BookController {
	@Resource
	private BookService bookService;
	
	@RequestMapping("/allBook")
	public String allBook (HttpServletRequest request){
		String msg = request.getParameter("role");
		List<Book> bookList = bookService.selectAll();
		request.setAttribute("bookList", bookList);
		System.out.println(msg);
		return "showBook";
	}
	
}
