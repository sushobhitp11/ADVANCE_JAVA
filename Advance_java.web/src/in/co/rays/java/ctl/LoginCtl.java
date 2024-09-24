package in.co.rays.java.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.java.bean.UserBean;
import in.co.rays.java.model.UserModel;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("LoginView.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String loginId = req.getParameter("loginId");
		String password = req.getParameter("password");
		
		UserModel model = new UserModel();
		
		try {
			UserBean bean = model.Authenticate(loginId, password);
			if(bean != null) {
				resp.sendRedirect("Welcome.jsp");
			}else {
				req.setAttribute("msg", "loginId & password is invalid");
				RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
				rd.forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
