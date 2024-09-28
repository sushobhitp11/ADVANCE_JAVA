package in.co.rays.java.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.java.bean.UserBean;
import in.co.rays.java.model.UserModel;

@WebServlet("/UserListCtl.do")
public class UserListCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UserBean bean = null;

		int pageNo = 1;

		int pageSize = 5;

		UserModel model = new UserModel();

		try {
			List list = model.search(bean, pageNo, pageSize);
			req.setAttribute("list", list);
			req.setAttribute("pageNo", pageNo);
			RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("operation");

		UserBean bean = null;

		int pageNo = 1;

		int pageSize = 5;

		UserModel model = new UserModel();

		if (op.equals("search")) {

			bean = new UserBean();
			bean.setFirstName(req.getParameter("firstName"));
		}

		if (op.equals("next")) {
			pageNo = Integer.parseInt(req.getParameter("pageNo"));
			pageNo++;
		}

		if (op.equals("previous")) {
			pageNo = Integer.parseInt(req.getParameter("pageNo"));
			pageNo--;
		}
		if (op.equals("add")) {
			resp.sendRedirect("UserCtl.do");

		}
		if (op.equals("delete")) {

			String[] ids = req.getParameterValues("ids");
			if (ids != null && ids.length > 0) {
				for (String id : ids) {

					try {
						model.delete(Integer.parseInt(id));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		}

		try {
			List list = (List) model.search(bean, pageNo, pageSize);
			req.setAttribute("list", list);
			req.setAttribute("pageNo", pageNo);
			RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
