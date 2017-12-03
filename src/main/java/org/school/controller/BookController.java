package org.school.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.school.model.Book;
import org.school.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {
	@Resource
	private BookService bookService;
	private String Role;

	@RequestMapping("/allBook")
	public String allBook(HttpServletRequest request) {
		String msg = (String) request.getSession().getAttribute("tag");
		if(msg==null){
			msg = Role;
		}else if(msg.hashCode()<=50&&msg.hashCode()>=48) {
			Role = msg;
		}
		List<Book> bookList = bookService.selectAll();
		request.setAttribute("bookList", bookList);
		switch (msg.hashCode()) {
		case 48:
			request.setAttribute("role", 0);
			break;
		case 49:
			request.setAttribute("role", 1);
			break;
		case 50:
			request.setAttribute("role", 2);
			break;
		case 51:
			request.setAttribute("role", 0);
			request.setAttribute("msg", "new");
			break;
		}
		return "showBook";
	}

	@RequestMapping("/deleteBook")
	public String deleteBook(HttpServletRequest request) {
		String ISBN = request.getParameter("ISBN");
		@SuppressWarnings("unused")
		String role = request.getParameter("role");
		Book book = bookService.select(ISBN);
		if (book == null) {

		} else {
			bookService.delete(ISBN);
		}
		return "redirect:/book/allBook";
	}

	@RequestMapping("/toReviseBook")
	public String toReviseBook(HttpServletRequest request) {
		String ISBN = request.getParameter("ISBN");
		String role = request.getParameter("role");
		Book book = bookService.select(ISBN);
		request.setAttribute("book", book);
		Role=role;
		if (book == null) {
			
		}
		return "reviseBook";
	}
	
	@RequestMapping("/reviseBook")
	public String reviseBook(HttpServletRequest request,@Param("book")Book book){
		bookService.update(book);
		return "redirect:/book/allBook";
	}
	
	@RequestMapping("/toAddBook")
	public String toAddBook(HttpServletRequest request){
		return "addBook";
	}
	
	@RequestMapping("/addBook")
	public String addBook(HttpServletRequest request,@Param("book")Book book){
		
		bookService.insert(book);
		return "redirect:/book/allBook";
	}
	
	@RequestMapping("/findBook")
	public String findBook(HttpServletRequest request){
		String some = request.getParameter("search");
		List<Book> bookList = bookService.selectSome(some);
		request.setAttribute("bookList", bookList);
		request.setAttribute("role", Role);
		return "showBook";
	}
}
