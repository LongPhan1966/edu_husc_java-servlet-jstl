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
import bo.Loaibo;

/**
 * Servlet implementation class AdminThemLoaiController
 */
@WebServlet("/AdminThemLoaiController")
public class AdminThemLoaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminThemLoaiController() {
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
				Loaibo loai= new Loaibo();
				String ml = request.getParameter("txtmaloai");
				String tl = request.getParameter("txttenloai");
				if(ml!=null)
				{
					int c= loai.ThemLoai(ml, tl);
					if(c==0) {
			     		request.setAttribute("tb", "Thêm loại không thành công");
			     		RequestDispatcher rd= request.getRequestDispatcher("AdminQLLoaiController");
			     		rd.forward(request, response);
					}else if(c==-1) {
			    	    request.setAttribute("tb", "Trùng mã loại");
			     		RequestDispatcher rd= request.getRequestDispatcher("AdminQLLoaiController");
			     		rd.forward(request, response);
					}else{
			     		 request.setAttribute("tb", "Thêm loại thành công");
			     		 RequestDispatcher rd= request.getRequestDispatcher("AdminQLLoaiController");
			     		 rd.forward(request, response);  
			     }
				}
				RequestDispatcher rd= request.getRequestDispatcher("views/admin/AdminThemLoai.jsp");
	     		rd.forward(request, response); 
			}
			else
			{
				request.setAttribute("tb", "Bạn cần đăng nhập");
				RequestDispatcher rd = request.getRequestDispatcher("views/admin/adminLogin.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
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
