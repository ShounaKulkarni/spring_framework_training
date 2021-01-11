package com.zensar;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentController extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		String requestAction = request.getParameter("requestAction");
		if(requestAction.equals("getAllS")) {
			StudentRepository sr = new StudentRepository();
			List<BeanStudent> listOfAllStudent = sr.getAllStudent();
			System.out.println(listOfAllStudent);

			RequestDispatcher rd = request.getRequestDispatcher("showAllStudent.jsp");
			request.setAttribute("listOfAllStudent",listOfAllStudent );
			try {
				rd.forward(request, response);

			} catch (Exception e) {
				System.out.println("doGet Catch"+e);
			}
		}//if
		else if(requestAction.equals("delete")) {
			int sid = Integer.parseInt(request.getParameter("sid"));
			StudentRepository sr = new StudentRepository();
			sr.deleteStudent(sid);
			try {
				//rd.forward(request, response);
				response.sendRedirect("index.jsp");
			} catch (Exception e) {
				System.out.println("doGet deleteStudent catch"+e);
			}

		}//else if
		else if(requestAction.equals("updateS")) {
			StudentRepository rs = new StudentRepository();
			int sid = Integer.parseInt(request.getParameter("sid"));
			BeanStudent bs = rs.getStudent(sid);
			RequestDispatcher rd = request.getRequestDispatcher("updateStudentForm.jsp");
			request.setAttribute("bs",bs);
			try {
				rd.forward(request, response);
			} catch (Exception e) {

			}
		}
		else if(requestAction.equals("updateDB"))	{
			int sid = Integer.parseInt(request.getParameter("sid"));
			String sname = request.getParameter("sname");
			String scourse = request.getParameter("scourse");
			String shometown = request.getParameter("shometown");
			String sgender = request.getParameter("sgender");
			BeanStudent bs = new BeanStudent(sid, sname, scourse, shometown, sgender);
			StudentRepository rs = new StudentRepository();
			rs.updateStudent(bs);
			try {
				response.sendRedirect("index.jsp");
			} catch (IOException e) {

				e.printStackTrace();
			}

		}
		else if(requestAction.equals("addDB")) {
			int sid = Integer.parseInt(request.getParameter("sid"));
			String sname = request.getParameter("sname");
			String scourse = request.getParameter("scourse");
			String shometown = request.getParameter("shometown");
			String sgender = request.getParameter("sgender");
			BeanStudent bs = new BeanStudent(sid, sname, scourse, shometown, sgender);
			StudentRepository sr = new StudentRepository();
			sr.addStudent(bs);
			try {
				response.sendRedirect("index.jsp");
			} catch (Exception e) {
				System.out.println("doPost catch"+e);
			}
		}
		else if(requestAction.equals("loginFormjsp")) {
			String susername = request.getParameter("susername");
			String spassword = request.getParameter("spassword");

			StudentRepository sr = new StudentRepository();
			boolean loginResult = sr.loginCheck(susername, spassword);
			if(loginResult) {
				try {
					//RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		            //rd.include(request, response);
					response.sendRedirect("index.jsp");
				} catch (Exception e) {
					e.printStackTrace();
				}  
			}else {
				System.out.println("login Failed");
				 request.setAttribute("errorMessage", "Invalid user or password");
                 RequestDispatcher rd = request.getRequestDispatcher("loginForm.jsp");
                 
				try {
					rd.forward(request, response);
					//response.sendRedirect("loginForm.jsp");
				} catch (Exception e) {
					 
					System.out.println("loginfailed catch"+e);
				}
			}
		}//else if
		else if(requestAction.equals("logoutmessage")) {
			request.setAttribute("logoutmessage", "Logout Successfull");
            RequestDispatcher rd = request.getRequestDispatcher("loginForm.jsp");
            
			try {
				rd.forward(request, response);
				//response.sendRedirect("loginForm.jsp");
			} catch (Exception e) {
				 
				System.out.println("loginfailed catch"+e);
			}
			 	 
			}//else if
	}	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		doGet(request, response);
	}
}
