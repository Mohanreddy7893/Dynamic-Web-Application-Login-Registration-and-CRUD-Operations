package org.jsp.user_web_app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsp.user_web_app.dao.UserDao;
import org.jsp.user_web_app.dto.User;
@WebServlet("/edit")
public class EditUserServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("nm");
		String password=req.getParameter("ps");
		String email=req.getParameter("em");
		long phone=Long.parseLong(req.getParameter("ph"));
		User u=new User();
		u.setEmail(email);
		u.setId(id);
		u.setName(name);
		u.setPassword(password);
		u.setPhone(phone);
		UserDao dao =new UserDao();
		u=dao.updateUser(u);
		PrintWriter writer=resp.getWriter();
	writer.write("<html><body><h1> user save with id:"+u.getId()+"</h1></body></html>");
	}

}
