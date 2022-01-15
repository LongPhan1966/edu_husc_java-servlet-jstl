package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.AdminBean;

public class AdminDao {
	DungChung dc= new DungChung();
	public AdminBean ktdn(String tendn, String mk) throws Exception
	{
		//b1: ket noi vao csdl
		dc.KetNoi();
		//b2: Lay du lieu ve
		String sql="Select * from DangNhap where TenDangNhap=? and MatKhau=?";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		//b3: Truyen tham so vao cau lenh sql
		cmd.setString(1,tendn);
		cmd.setString(2,mk);
		//b4: Thuc hien cau lieu
		ResultSet rs= cmd.executeQuery();
		//kiem tra xem nguoi dung dang nhap dung hay khong
		//neu rs.next==false return null;
		//Nguoc lai: tao ra 01 kh, return kh
		AdminBean ad = null;
		if (rs.next())
		{
			String TenDangNhap=rs.getString("TenDangNhap");
			String MatKhau=rs.getString("MatKhau");
			Boolean Quyen=rs.getBoolean("Quyen");
			ad = new AdminBean(TenDangNhap, MatKhau, Quyen);
		}
		//b6: Dong all 
		rs.close();
		dc.cn.close();
		return ad;
}
	public static void main(String[] args) throws Exception{
		AdminDao ad= new AdminDao();
		AdminBean i = ad.ktdn("admin", "123");
		System.out.println(i);
	}
}
