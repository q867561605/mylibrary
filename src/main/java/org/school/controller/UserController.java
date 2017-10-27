package org.school.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.school.model.User;
import org.school.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
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
			request.setAttribute("role", user.getRole());
			return "redirect:/book/allBook";
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
			request.setAttribute("role", resultUser.getRole());
			return "redirect:/book/allBook";
		}
	}

	@RequestMapping("/allUser")
	public String allUser(HttpServletRequest request) {
		List<User> result = userService.selectAll();
		request.setAttribute("userList", result);
		return "ShowUser";
	}
}