package user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.KhachHangBean;
import bean.LichSuMuaHangBean;
import bo.LichSuMuaHangBo;

/**
 * Servlet implementation class LichSuController
 */
@WebServlet("/LichSuController")
public class LichSuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LichSuController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			String name = request.getParameter("name");
			LichSuMuaHangBo ls = new LichSuMuaHangBo();
			KhachHangBean kh = (KhachHangBean)session.getAttribute("kh");
			if(kh!=null)
			{
				ArrayList<LichSuMuaHangBean> lsmh= null;
				lsmh=ls.getLichSuMuaHang(kh.getMaKH());
				request.setAttribute("lsmh",lsmh);
			}
			if(name!=null)
			{
				RequestDispatcher rd = request.getRequestDispatcher("views/user/history.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
