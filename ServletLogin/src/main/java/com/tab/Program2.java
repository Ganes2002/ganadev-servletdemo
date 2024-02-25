package com.tab;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Program2
 */
@WebServlet("/Program2")
public class Program2 extends HttpServlet{

	protected void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		
		//private static final long serialVersionUID = 1L;
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String dept=req.getParameter("department");
		int salary=Integer.parseInt(req.getParameter("salary"));
		
		InsertMember im=new InsertMember(id,name,email,dept,salary);
		InsertMemberDao imd=new InsertMemberDao();
		String result=imd.insert(im);
		//String result=imd.verify(im);
		res.getWriter().print(result);
		
		
	}

}

