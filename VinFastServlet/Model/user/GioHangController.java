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

import bean.Loaibean;
import bean.Xebean;
import bo.GioHangBo;
import bo.Loaibo;
import bo.Xebo;

/**
 * Servlet implementation class GioHangController
 */
@WebServlet("/GioHangController")
public class GioHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public GioHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Loaibo loai = new Loaibo();
			Xebo xe = new Xebo();//Sachbo sach = new Sachbo();
			ArrayList<Xebean> dsxe = null;
			dsxe = xe.getXe();
			ArrayList<Loaibean> dsloai = null;
			dsloai = loai.getloai();
			String ml=request.getParameter("ml");
			String key=request.getParameter("key");
			if (ml!=null)
				dsxe=xe.TimMaLoai(ml);
			else
				if (key != null)
					dsxe=xe.Tim(key);
			request.setAttribute("dsloai", dsloai);
			request.setAttribute("dssach", dsxe);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		String maxe=request.getParameter("maxe");
		String tenxe=request.getParameter("tenxe");
		String giatam=request.getParameter("gia");
		String mxe = request.getParameter("mxe");
		String name = request.getParameter("name");
		String sl=request.getParameter("txtsl");
		if(maxe!=null)
		{
			//Tạo cho kh 1 giohang khi dat mua quyen sach dau tien
			GioHangBo gh=null;
			if(session.getAttribute("gh")==null)
			{
				gh=new GioHangBo(); //Cập nhật vùng nhớ
				session.setAttribute("gh", gh); //Tạo ra 1 giỏ
			}
			//
			gh=(GioHangBo)session.getAttribute("gh");
			gh.Them(maxe, tenxe, Long.parseLong(giatam), (long)1);
			session.setAttribute("gh", gh);
			RequestDispatcher rd = request.getRequestDispatcher("/views/user/cart.jsp");
			rd.forward(request, response);
		}
		if(name!=null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("/views/user/cart.jsp");
			rd.forward(request, response);
		}
		if(mxe!=null)
		{
			GioHangBo gh=(GioHangBo)session.getAttribute("gh");
			if(request.getParameter("btnXoa")!=null)
			{
				gh.Xoa(mxe);

			}
			if(request.getParameter("btnSua")!=null)
			{
				gh.Sua(mxe, Long.parseLong(sl));
			}
			if(gh.ds.size()==0)
				session.removeAttribute("gh");
			else session.setAttribute("gh", gh);
			RequestDispatcher rd = request.getRequestDispatcher("views/user/cart.jsp");
			rd.forward(request, response);
		}
		else 
		{
			if(request.getParameter("btnTraAll")!=null)
			{
				GioHangBo gh=(GioHangBo)session.getAttribute("gh");
				gh.XoaALL();
				session.removeAttribute("gh");
				RequestDispatcher rd = request.getRequestDispatcher("HomeController");
				rd.forward(request, response);
			}
			if(request.getParameter("btnThanhToan")!=null)
			{
				RequestDispatcher rd = request.getRequestDispatcher("/views/user/checkout.jsp");
				rd.forward(request, response);
			}
			if(request.getParameter("btnMuaHang")!=null)
			{
				RequestDispatcher rd1 = request.getRequestDispatcher("HomeController");
				rd1.forward(request, response);
			}
			if(request.getParameter("btnMua")!=null)
			{
				RequestDispatcher rd2 = request.getRequestDispatcher("HomeController");
				rd2.forward(request, response);
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
