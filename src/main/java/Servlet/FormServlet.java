package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.FormDAO;

import DTO.FormDTO;
@WebServlet("/form")
public class FormServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String fname=req.getParameter("fname");
			String lname=req.getParameter("lname");
			String gender=req.getParameter("gender");
			String email=req.getParameter("email");
			String pwd=req.getParameter("password");
			String branch=req.getParameter("branch");
			FormDTO x=new FormDTO();
			x.setFname(fname);
			x.setLname(lname);
			x.setGender(gender);
			x.setEmail(email);
			x.setPwd(pwd);
			x.setBranch(branch);
			FormDAO y=new FormDAO();
			boolean st=y.saveDetails(x);
			String res="";
			if(st) {
				res="Details Inserted";
			}else {
				res="Insertion Failed";
			}
			PrintWriter pw=resp.getWriter();
			pw.append(res);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}
}
