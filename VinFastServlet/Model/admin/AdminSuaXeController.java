package admin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AdminBean;
import bo.Xebo;

/**
 * Servlet implementation class AdminSuaXeController
 */
@WebServlet("/AdminSuaXeController")
public class AdminSuaXeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSuaXeController() {
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
				
				Xebo xe=new Xebo();
				String maxe = request.getParameter("txtmaxe");
				String tenxe = request.getParameter("txttenxe");
				String soluong = request.getParameter("txtsoluong");
				String gia = request.getParameter("txtgia");
				String maloai = request.getParameter("maloai");
				String ngaynhap = request.getParameter("txtngaynhap");
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date ngaynhap1 = format.parse(ngaynhap);
				if(request.getParameter("btnSuaXe")!=null)
				{
					xe.SuaXe(maxe, tenxe, Long.parseLong(gia), Long.parseLong(soluong), maloai, ngaynhap1);	
					request.setAttribute("tb", "Sửa xe thành công");
		     		RequestDispatcher rd= request.getRequestDispatcher("AdminQLXeController");
		     		rd.forward(request, response);
				}

			}
			else
			{
				request.setAttribute("tb", "Bạn cần đăng nhập");
				RequestDispatcher rd = request.getRequestDispatcher("views/admin/adminLogin.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
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
