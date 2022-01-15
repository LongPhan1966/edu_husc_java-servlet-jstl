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
import bean.KhachHangBean;
import bo.KhachHangBo;

/**
 * Servlet implementation class AdminQLKHController
 */
@WebServlet("/AdminQLKHController")
public class AdminQLKHController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminQLKHController() {
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
				String makh= request.getParameter("makh");
				KhachHangBo kh = new KhachHangBo();
				ArrayList<KhachHangBean> dskh = null;
				dskh = kh.getKH();
				request.setAttribute("dskh", dskh);
				if(makh!=null) 
					{
						Integer maKH = Integer.valueOf(makh);
						if(request.getParameter("btnXoa")!=null) 
						{ 
							kh.XoaKH(maKH); 
							dskh = kh.getKH();
							request.setAttribute("dskh", dskh);
							request.setAttribute("tb", "Đã xóa thành công");
							RequestDispatcher rd = request.getRequestDispatcher("views/admin/AdminQLKH.jsp");
							rd.forward(request, response);
						}
					}
				RequestDispatcher rd = request.getRequestDispatcher("views/admin/AdminQLKH.jsp");
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
