package user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.KhachHangBo;

/**
 * Servlet implementation class DangKyController
 */
@WebServlet("/DangKyController")
public class DangKyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangKyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String UserName=request.getParameter("user");
			String FullName=request.getParameter("fullname");
			String Pass=request.getParameter("pass");
			String DiaChi=request.getParameter("diachi");
			String Email=request.getParameter("email");
			String Sodt=request.getParameter("sodt");
			KhachHangBo khbo=new KhachHangBo();
			int kh = khbo.ktdk(FullName, DiaChi, Sodt, Email, UserName, Pass);
			HttpSession session = request.getSession();
			if (kh==1){
				session.setAttribute("ThongBaoThanhCong", "Đăng ký thành công");
				RequestDispatcher rd = request.getRequestDispatcher("HomeController");
				rd.forward(request, response);
			}
			else 
			{
				session.setAttribute("ThongBaoThatBai", "Đăng ký thất bại");
				RequestDispatcher rd = request.getRequestDispatcher("views/user/dangky.jsp");
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
