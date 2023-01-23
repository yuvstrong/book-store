package com.js.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.js.dao.BookCRUD;
import com.js.dto.Book;
@WebServlet(value="/insert")
public class InsertBook extends HttpServlet{
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Book b=new Book();
	b.setBid(Integer.parseInt(req.getParameter("Bid")));
	b.setBname(req.getParameter("Bname"));
    b.setBauthor(req.getParameter("Bauthor"));
    b.setBpage(Integer.parseInt(req.getParameter("Bpage")));
    b.setBprice(Double.parseDouble(req.getParameter("Bprice")));
    
    BookCRUD bc=new BookCRUD();
    int result=bc.insertBook(b);
    if (result>0) {
    	RequestDispatcher rd= req.getRequestDispatcher("result.jsp");
    	req.setAttribute("msg", "INSERTED SUSCCESSFULLY");
    	rd.forward(req, resp);
		
	} else {
		RequestDispatcher rd= req.getRequestDispatcher("result.jsp");
    	req.setAttribute("msg", " FAILED TO INSERT");
    	rd.forward(req, resp);
	}
}
}
