package user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.KhachHangBean;
import bo.KhachHangBo;

/**
 * Servlet implementation class uDangNhapController
 */
@WebServlet("/DangNhapController")
public class DangNhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangNhapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			String un = request.getParameter("txtun");
			String pass = request.getParameter("txtpass");
			
			KhachHangBo khbo=new KhachHangBo();
			KhachHangBean kh = khbo.ktdn(un, pass);
			HttpSession session = request.getSession();
			if(kh != null) {
				session.setAttribute("kh", kh);
				session.setAttribute("kt", (long)1);
				
				if(request.getParameter("btnDNTT")!=null)
				{
					RequestDispatcher rd = request.getRequestDispatcher("views/user/checkout.jsp");
					rd.forward(request, response);
				}
				
				RequestDispatcher rd= request.getRequestDispatcher("HomeController");	
				rd.forward(request, response);
			}
			else{
				
				if(request.getParameter("btnDNTT")!=null)
				{
					RequestDispatcher rd = request.getRequestDispatcher("views/user/checkout.jsp");
					rd.forward(request, response);
				}
				RequestDispatcher rd= request.getRequestDispatcher("views/user/Dangnhap.jsp");	
				rd.forward(request, response);
				session.setAttribute("kt", (long)0);
			   }
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
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
