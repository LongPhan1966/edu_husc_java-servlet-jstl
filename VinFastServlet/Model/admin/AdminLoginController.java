package admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AdminBean;
import bo.AdminBo;

/**
 * Servlet implementation class AdminLoginController
 */
@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginController() {
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
			String un=request.getParameter("txtun");
			String pass=request.getParameter("txtpass");
			AdminBo adbo=new AdminBo();
			AdminBean ad = adbo.ktdn(un, pass);
			HttpSession session = request.getSession();
			if(un !=null)
			{
				if (ad!=null){
					session.setAttribute("ad", ad);
					RequestDispatcher rd = request.getRequestDispatcher("AdminMenuController");
					rd.forward(request, response);
				}
				else 
				{
					request.setAttribute("tb", "Tài khoản hoặc mật khẩu sai");
					RequestDispatcher rd = request.getRequestDispatcher("views/admin/adminLogin.jsp");
					rd.forward(request, response);
				}
			}
			else
			{
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
