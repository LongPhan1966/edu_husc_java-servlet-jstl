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
import bo.Loaibo;

/**
 * Servlet implementation class AdminQLLoaiController
 */
@WebServlet("/AdminQLLoaiController")
public class AdminQLLoaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminQLLoaiController() {
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
			if (ad!=null)
			{
				Loaibo loai = new Loaibo();
				Loaibean loaibean = null;
				ArrayList<Loaibean> dsloai = null;
				dsloai = loai.getloai();
				String key=request.getParameter("key");
				String ml=request.getParameter("ml");
				if (key != null)
					dsloai=loai.Tim(key);
				request.setAttribute("dsloai", dsloai);
				if(request.getParameter("btnThemLoai")!=null)
				{
					RequestDispatcher rd = request.getRequestDispatcher("AdminThemLoaiController");
					rd.forward(request, response);
				}
				if(request.getParameter("btnXoa")!=null)
				{
					loai.XoaLoai(ml);
					dsloai = loai.getloai();
					request.setAttribute("dsloai", dsloai);
					request.setAttribute("tb", "Xóa loại thành công");
					RequestDispatcher rd = request.getRequestDispatcher("views/admin/AdminQLLoai.jsp");
					rd.forward(request, response);
				}
				if(request.getParameter("btnSua")!=null)
				{
					loaibean = loai.getMotLoai(ml);
					request.setAttribute("loaibean", loaibean);
					RequestDispatcher rd = request.getRequestDispatcher("views/admin/AdminSuaLoai.jsp");
					rd.forward(request, response);
				}
				RequestDispatcher rd = request.getRequestDispatcher("views/admin/AdminQLLoai.jsp");
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
