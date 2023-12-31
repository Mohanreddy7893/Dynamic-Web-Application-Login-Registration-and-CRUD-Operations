package org.jsp.user_web_app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsp.user_web_app.dao.UserDao;
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	UserDao dao=new UserDao();
	dao.deleteUser(id);
	HttpSession session=req.getSession();
	session.invalidate();
	PrintWriter writer=resp.getWriter();
	writer.write("<html><body><h1>Account Deleted</h1></body></html>");
	RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
	dispatcher.include(req, resp);
	
}
}
