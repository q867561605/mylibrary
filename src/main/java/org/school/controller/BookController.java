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
		String msg = (String) request.getSession().getAttribute("tag");
		List<Book> bookList = bookService.selectAll();
		request.setAttribute("bookList", bookList);
		switch(msg.hashCode()){
		case 48:request.setAttribute("role",0);break;
		case 49:request.setAttribute("role",1);break;
		case 50:request.setAttribute("role",2);break;
		case 51:request.setAttribute("role",0);request.setAttribute("msg", "new");break;
		}
		return "showBook";
	}
	
}
