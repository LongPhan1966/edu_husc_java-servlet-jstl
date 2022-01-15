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
import bean.ChiTietDHBean;
import bean.DonHangBean;
import bo.ChiTietDHBo;
import bo.DonHangBo;

/**
 * Servlet implementation class AdminQLDHController
 */
@WebServlet("/AdminQLDHController")
public class AdminQLDHController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminQLDHController() {
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
				String madh= request.getParameter("madh");
				DonHangBo donhang = new DonHangBo();
				ArrayList<DonHangBean> dsdh = null;
				dsdh = donhang.getDH();
				//String key=request.getParameter("key");
				/*if (key != null)
					dsloai=loai.Tim(key);*/
				request.setAttribute("dsdh", dsdh);
				if(madh!=null) 
				{
					Integer maDH = Integer.valueOf(madh);
					if(request.getParameter("btnXacNhan")!=null) 
					{ 
						donhang.XacNhanDH(maDH);
						dsdh = donhang.getDH();
						request.setAttribute("dsdh", dsdh);
						request.setAttribute("XacNhanThanhCong", "Đã xác nhận thành công");
						RequestDispatcher rd = request.getRequestDispatcher("views/admin/AdminQLDH.jsp");
						rd.forward(request, response);
					}
					if(request.getParameter("btnChiTiet")!=null) 
					{ 
						ChiTietDHBo ctdh= new ChiTietDHBo();
						ArrayList<ChiTietDHBean> dsctdh = null;
						dsctdh = ctdh.getDH(maDH);
						request.setAttribute("dsctdh", dsctdh);
						RequestDispatcher rd = request.getRequestDispatcher("views/admin/AdminCTDH.jsp");
						rd.forward(request, response);
					}
				}
				if(request.getParameter("btnQuayLai")!=null)
				{
					RequestDispatcher rd = request.getRequestDispatcher("views/admin/AdminQLDH.jsp");
					rd.forward(request, response);
				}
				RequestDispatcher rd = request.getRequestDispatcher("views/admin/AdminQLDH.jsp");
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
