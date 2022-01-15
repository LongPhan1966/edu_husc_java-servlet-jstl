package user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Loaibean;
import bean.Xebean;
import bo.Loaibo;
import bo.Xebo;

/**
 * Servlet implementation class LoaiHangController
 */
@WebServlet("/LoaiHangController")
public class LoaiHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoaiHangController() {
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
			
			String loaixe = request.getParameter("maloai");
			Loaibo lbo = new Loaibo();
			Xebo xbo = new Xebo();
			ArrayList<Xebean> loai = xbo.getxeByLoai(loaixe);
			ArrayList<Loaibean> listLoai = lbo.getloai();
			request.setAttribute("ListXe", loai);
			request.setAttribute("ListLoai", listLoai);
			RequestDispatcher rd= request.getRequestDispatcher("/views/user/home.jsp");	
			   rd.forward(request, response);
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
