package org.school.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.school.model.User;
import org.school.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SuppressWarnings("serial")
@Controller
@RequestMapping("/user")
public class UserController extends HttpServlet {
	@Resource
	private UserService userService;
	
	
	@RequestMapping("/GoRegister")
	public String GoRegister(HttpServletRequest request) {
		return "register";
	}

	@RequestMapping("/registeruser")
	public String registeruser(HttpServletRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		User resultUser = userService.select(username);
		if (resultUser != null) {
			request.setAttribute("msg", "用户已存在");
			return "register";
		} else {
			user.setRole(0);
			userService.insert(user);
			request.setAttribute("msg", "新用户");
			return "redirect:/book/allBook?tag=3";
		}
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User resultUser = userService.select(username);
		if (resultUser == null) {
			request.setAttribute("msg", "用户不存在");
			return "login";
		} else if (!resultUser.getPassword().equalsIgnoreCase(password)) {
			request.setAttribute("msg", "密码错误");
			return "login";
		} else {
			int role = resultUser.getRole();
			switch(role){
			case 0:request.getSession().setAttribute("tag","0");return "redirect:/book/allBook";
			case 1:request.getSession().setAttribute("tag","1");return "redirect:/book/allBook";
			case 2:request.getSession().setAttribute("tag","2");return "redirect:/book/allBook";
			}
			return null;
		}
	}

	@RequestMapping("/allUser")
	public String allUser(HttpServletRequest request) {
		List<User> result = userService.selectAll();
		request.setAttribute("userList", result);
		return "ShowUser";
	}
	
	@RequestMapping("/deleteUser")
	public String deleteBook(HttpServletRequest request) {
		String username = request.getParameter("name");
		User user = userService.select(username);
		if (user == null) {

		} else {
			userService.delete(username);
		}
		return "redirect:/user/allUser";
	}
	
	@RequestMapping("/toAddUser")
	public String toAddBook(HttpServletRequest request){
		return "addUser";
	}
	
	@RequestMapping("/addUser")
	public String addBook(HttpServletRequest request,@Param("user")User user){
		userService.insert(user);
		return "redirect:/user/allUser";
	}
	
	@RequestMapping("/toAlterUser")
	public String toReviseBook(HttpServletRequest request) {
		String username = request.getParameter("name");
		User user = userService.select(username);
		request.setAttribute("user", user);
		if (user == null) {
			
		}
		return "alterUser";
	}
	
	@RequestMapping("/alterUser")
	public String reviseBook(HttpServletRequest request,@Param("user")User user){
		userService.update(user);
		return "redirect:/user/allUser";
	}
}