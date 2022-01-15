package user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.GioHangBean;
import bean.KhachHangBean;
import bean.Loaibean;
import bean.Xebean;
import bo.GioHangBo;
import bo.Loaibo;
import bo.Xebo;

/**
 * Servlet implementation class ThanhToanController
 */
@WebServlet("/ThanhToanController")
public class ThanhToanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThanhToanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Loaibo loai = new Loaibo();
			Xebo xe = new Xebo();
			ArrayList<Xebean> dsxe = null;
			dsxe = xe.getXe();
			ArrayList<Loaibean> dsloai = null;
			dsloai = loai.getloai();
			String ml=request.getParameter("ml");
			String key=request.getParameter("key");
			String name = request.getParameter("name");
			response.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			if (ml!=null)
				dsxe=xe.TimMaLoai(ml);
			else
				if (key != null)
					dsxe=xe.Tim(key);
			request.setAttribute("dsloai", dsloai);
			request.setAttribute("dsxe", dsxe);
			if (request.getParameter("btnXacNhan")!=null)
			{
				GioHangBo ghbo = new GioHangBo();
				GioHangBo gh = (GioHangBo)session.getAttribute("gh");
				ArrayList<GioHangBean> giohang = gh.ds;
				KhachHangBean kh = (KhachHangBean)session.getAttribute("kh");
				ghbo.themHoaDonbo(kh.getMaKH());
				int maHD = ghbo.maHDVuaTaobo();
				ghbo.themCTHDbo(giohang, maHD);
				session.setAttribute("ThongBaoXacNhan","Bạn đã đặt mua thành công");
				session.removeAttribute("gh");
				RequestDispatcher rd = request.getRequestDispatcher("/views/user/cart.jsp");
				rd.forward(request, response);
			}
			if(name!=null)
			{
				RequestDispatcher rd = request.getRequestDispatcher("/views/user/checkout.jsp");
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
