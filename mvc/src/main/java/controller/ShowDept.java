package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class numDept
 */
@WebServlet("/ShowDept")
public class ShowDept extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NumDeptMapper numdeptMapper = new NumDeptMapper();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowDept() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String DeptNum = request.getParameter("deptinfos");
		DeptNum.trim();
		String DeptName = numdeptMapper.findDept(DeptNum);

		String address = null;
		DeptPair deptinfo = new DeptPair(DeptNum, DeptName);
		request.setAttribute("deptinfo", deptinfo);
		if (DeptNum.isEmpty()) {

			address = "/WEB-INF/result/missing-num.jsp";
			request.getRequestDispatcher(address).forward(request, response);

		} else if (DeptName != null) {
			address = "/WEB-INF/result/show-departement-1.jsp";
			request.getRequestDispatcher(address).forward(request, response);
		} else {
			address = "/WEB-INF/result/unknown-num-1.jsp";
			request.getRequestDispatcher(address).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
