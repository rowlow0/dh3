package controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dto.Dto;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		
		int custno=0;
		if(req.getParameter("custno")!=null) {custno=Integer.parseInt(req.getParameter("custno"));}
		String custname=req.getParameter("custname")==null?"":req.getParameter("custname");
		String phone=req.getParameter("phone")==null?"":req.getParameter("phone");
		String address=req.getParameter("address")==null?"":req.getParameter("address");
		String joindate=req.getParameter("joindate")==null?"":req.getParameter("joindate");
		String grade=req.getParameter("grade")==null?"":req.getParameter("grade");
		String city=req.getParameter("city")==null?"":req.getParameter("city");
		String flag=req.getParameter("flag")==null?"":req.getParameter("flag");
		String nextUrl="";
		
		if(flag.equals("u")) {
			Dao dao=new Dao();
			Dto dto=new Dto();
			dto.setCustno(custno);
			dto.setAddress(address);
			dto.setCity(city);
			dto.setCustname(custname);
			dto.setGrade(grade);
			dto.setJoindate(joindate);
			dto.setPhone(phone);
			dao.update(dto);
			nextUrl="Controller?flag=s";
		}
		
		
		if(flag.equals("i")) {
			Dao dao=new Dao();
			Dto dto=new Dto();
			dto.setCustno(custno);
			dto.setAddress(address);
			dto.setCity(city);
			dto.setCustname(custname);
			dto.setGrade(grade);
			dto.setJoindate(joindate);
			dto.setPhone(phone);
			dao.insert(dto);
			nextUrl="Controller?flag=s";
		}
		
		if(flag.equals("sm")) {
			Dao dao=new Dao();
			Dto dto=new Dto();
			List<Dto> list=dao.selectM(dto);
			req.setAttribute("list", list);
			nextUrl="selectM.jsp";
		}
		
		if(flag.equals("s")) {
			Dao dao=new Dao();
			Dto dto=new Dto();
			List<Dto> list=dao.select(dto);
			req.setAttribute("list", list);
			nextUrl="select.jsp";
		}
		
		if(flag.equals("gotoi")) {
			Dao dao=new Dao();
			Dto dto=new Dto();
			custno=dao.getInsert(dto);
			req.setAttribute("custno", custno);
			nextUrl="insert.jsp";
		}
		
		if(flag.equals("gotou")) {
			Dao dao=new Dao();
			Dto dto=new Dto();
			req.setAttribute("custno", custno);
			req.setAttribute("address", address);
			req.setAttribute("city", city);
			req.setAttribute("custname", custname);
			req.setAttribute("grade", grade);
			req.setAttribute("joindate", joindate);
			req.setAttribute("phone", phone);
			nextUrl="update.jsp";
		}
		
		RequestDispatcher dis=req.getRequestDispatcher(nextUrl);
		dis.forward(req, res);
		
		
	}

}
