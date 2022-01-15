package admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AdminBean;
import bean.Loaibean;
import bean.Xebean;
import bo.Loaibo;
import bo.Xebo;

/**
 * Servlet implementation class AdminQLXeController
 */
@WebServlet("/AdminQLXeController")
public class AdminQLXeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminQLXeController() {
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
			AdminBean ad = (AdminBean)session.getAttribute("ad");
			if(ad!=null)
			{
				Xebo xe = new Xebo();
				ArrayList<Xebean> dsxe = null;
				Xebean xebean = null;
				dsxe = xe.getXe();
				String key=request.getParameter("key");
				String mx=request.getParameter("mx");
				if (key != null)
					dsxe=xe.Tim(key);
				request.setAttribute("dsxe", dsxe);
				if(request.getParameter("btnThem")!=null)
				{
					RequestDispatcher rd = request.getRequestDispatcher("AdminThemXeController");
					rd.forward(request, response);
				}
				if(request.getParameter("btnXoa")!=null)
				{
					xe.XoaXe(mx);
					dsxe = xe.getXe();
					request.setAttribute("dsxe", dsxe);
					request.setAttribute("tb", "Xóa xe thành công");
					RequestDispatcher rd = request.getRequestDispatcher("views/admin/AdminQLXe.jsp");
					rd.forward(request, response);
				}
				if(request.getParameter("btnSua")!=null)
				{
					Loaibo loai = new Loaibo();
					ArrayList<Loaibean> dsloai = null;
					dsloai = loai.getloai();
					request.setAttribute("dsloai", dsloai);
					xebean = xe.getMotXe(mx);
					request.setAttribute("xebean", xebean);
					RequestDispatcher rd = request.getRequestDispatcher("views/admin/AdminSuaXe.jsp");
					rd.forward(request, response);
				}
				RequestDispatcher rd = request.getRequestDispatcher("views/admin/AdminQLXe.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("tb", "Bạn cần đăng nhập");
				RequestDispatcher rd = request.getRequestDispatcher("views/admin/adminLogin.jsp");
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
