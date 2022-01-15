package user;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class HTGioHangController
 */
@WebServlet("/HTGioHangController")
public class HTGioHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HTGioHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Loaibo loai = new Loaibo();
		Xebo xe = new Xebo();
		ArrayList<Xebean> dsxe = null;
		try {
			dsxe = xe.getXe();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Loaibean> dsloai = null;
		try {
			dsloai = loai.getloai();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		String ml=request.getParameter("ml");
//		String key=request.getParameter("key");
//		if (ml!=null)
//			try {
//				dsxe=xe.TimMaLoai(ml);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		else
//			if (key != null)
//				try {
//					dsxe=xe.Tim(key);
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
		request.setAttribute("dsloai", dsloai);
		request.setAttribute("dssach", dsxe);
		RequestDispatcher rd = request.getRequestDispatcher("/views/user/cart.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
