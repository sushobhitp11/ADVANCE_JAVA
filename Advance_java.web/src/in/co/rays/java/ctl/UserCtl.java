package in.co.rays.java.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.java.bean.UserBean;
import in.co.rays.java.model.UserModel;

@WebServlet("/UserCtl")
public class UserCtl extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("UserView.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		UserBean bean = new UserBean();

		bean.setFirstName(req.getParameter("firstName"));
		bean.setLastName(req.getParameter("lastName"));
		bean.setGender(req.getParameter("gender"));
		bean.setLoginId(req.getParameter("loginId"));
		bean.setPassword(req.getParameter("password"));
		try {
			bean.setDob(sdf.parse(req.getParameter("dob")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bean.setPhoneNo(req.getParameter("phoneNo"));
		bean.setAddress(req.getParameter("address"));
		UserModel model = new UserModel();

		try {
			model.add(bean);
			req.setAttribute("msg", "User Added Sucessfully...!!!");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher rd = req.getRequestDispatcher("UserView.jsp");
		rd.forward(req, resp);
	}
}


