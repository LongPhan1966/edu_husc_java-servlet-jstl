package admin;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import bean.AdminBean;
import bean.Loaibean;
import bo.Loaibo;
import bo.Xebo;

/**
 * Servlet implementation class AdminThemXeController
 */
@WebServlet("/AdminThemXeController")
public class AdminThemXeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminThemXeController() {
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
				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
				Xebo xe = new Xebo();
				Loaibo loai = new Loaibo();
				ArrayList<Loaibean> dsloai = null;
				dsloai = loai.getloai();
				request.setAttribute("dsloai", dsloai);
				try {
					String maxe=null,tenxe=null,maloai=null,soluong=null,gia=null,anhupload=null;
					Date ngay=new java.util.Date();
					
					
						List<FileItem> fileItems = upload.parseRequest((RequestContext) request);
				         for (FileItem fileItem : fileItems) {
				 			 if (!fileItem.isFormField()) {//Nếu ko phải các control=>upfile lên
								String nameimg = fileItem.getName();
								if (!nameimg.equals("")) {
									String dirUrl = request.getServletContext().getRealPath("") +  "img";
									File dir = new File(dirUrl);
									if (!dir.exists()) {//nếu ko có thư mục thì tạo ra
										dir.mkdir();
									}
								           String fileImg = dirUrl + File.separator + nameimg;
								           File file = new File(fileImg);//tạo file
								            try {
								               fileItem.write(file);// ghi file
								               anhupload =  "img/"+nameimg;
								              System.out.println(anhupload);
								 } catch (Exception e) {
								    e.printStackTrace();
								}
							}
						 }
							else
							{
								String tentk=fileItem.getFieldName();
								if(tentk.equals("txtmaxe")) maxe = fileItem.getString("UTF-8");
								if(tentk.equals("txttenxe")) tenxe = fileItem.getString("UTF-8");
								if(tentk.equals("maloai")) maloai = fileItem.getString("UTF-8");
								if(tentk.equals("txtsoluong")) soluong = fileItem.getString("UTF-8");;
								if(tentk.equals("txtgia")) gia = fileItem.getString("UTF-8");
								if(tentk.equals("txtngaynhap")) 
								{
									SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
									ngay = format.parse(fileItem.getString());
								}
							}
				         }

					
						 //thêm
					     	 int c = xe.ThemXe(maxe, tenxe, Long.parseLong(gia), Long.parseLong(soluong), anhupload, maloai, ngay);
					     	 if(c==0) {
						     		request.setAttribute("tb", "Thêm xe không thành công");
						     		RequestDispatcher rd= request.getRequestDispatcher("AdminQLXeController");
						     		rd.forward(request, response);
						     }else if(c==-1) {
						    	    request.setAttribute("tb", "Trùng mã xe");
						     		RequestDispatcher rd= request.getRequestDispatcher("AdminQLXeController");
						     		rd.forward(request, response);
						     }else{
						     		 request.setAttribute("tb", "Thêm xe thành công");
						     		 RequestDispatcher rd= request.getRequestDispatcher("AdminQLXeController");
						     		 rd.forward(request, response);  
						     }
				} catch (Exception e) {
					// TODO: handle exception
				}
				RequestDispatcher rd = request.getRequestDispatcher("views/admin/AdminThemXe.jsp");
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
