package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.KhachHangBean;

public class KhachHangDao {
	DungChung dc= new DungChung();
	public KhachHangBean ktdn(String tendn, String mk) throws Exception
	{
		//b1: ket noi vao csdl
		dc.KetNoi();
		//b2: Lay du lieu ve
		String sql="Select * from KhachHang where tendn=? and pass=?";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		//b3: Truyen tham so vao cau lenh sql
		cmd.setString(1,tendn);
		cmd.setString(2,mk);
		//b4: Thuc hien cau lieu
		ResultSet rs= cmd.executeQuery();
		//kiem tra xem nguoi dung dang nhap dung hay khong
		//neu rs.next==false return null;
		//Nguoc lai: tao ra 01 kh, return kh
		KhachHangBean kh = null;
		if (rs.next())
		{
			Integer MaKH=rs.getInt("makh");
			String HoTenKH=rs.getString("hoten");
			String DiaChi=rs.getString("diachi");
		    String SDT=rs.getString("sodt");
		    String Email=rs.getString("email");
			String TenDN=rs.getString("tendn");
			String MatKhau=rs.getString("pass");
			kh = new KhachHangBean(MaKH, HoTenKH, DiaChi, SDT, Email, TenDN, MatKhau);
		}
		//b6: Dong all 
		rs.close();
		dc.cn.close();
		return kh;
	}
	public int ktdk(String hoten,String diachi,String sodt, String email ,String tendn, String mk) throws Exception
	{
		//b1: ket noi vao csdl
		dc.KetNoi();
		String ktra="select * from KhachHang where tendn=?";
		PreparedStatement ktradk=dc.cn.prepareStatement(ktra);
		ktradk.setString(1,tendn);
		ResultSet ktdk= ktradk.executeQuery();
		int rs;
		if(ktdk.next() == false)
		{
			String sql="insert into KhachHang (hoten,diachi,sodt,email,tendn,pass) values (?,?,?,?,?,?)";
			PreparedStatement cmd=dc.cn.prepareStatement(sql);
			cmd.setString(1,hoten);
			cmd.setString(2,diachi);
			cmd.setString(3,sodt);
			cmd.setString(4,email);
			cmd.setString(5,tendn);
			cmd.setString(6,mk);
			//b4: Thuc hien cau lieu
			rs= cmd.executeUpdate();
		}
		else return 0;
		//b6: Dong all 
		ktdk.close();
		dc.cn.close();
		return rs;
	}
	public int XoaKH(Integer makh) throws Exception
	{
		dc.KetNoi();
		int rs;
		String sql="Delete KhachHang where makh=?";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		cmd.setInt(1,makh);
		rs= cmd.executeUpdate();
		//b6: Dong all 
		dc.cn.close();
		return rs;
	}
	public ArrayList<KhachHangBean> getkh() throws Exception{
		dc.KetNoi();
		ArrayList<KhachHangBean> ds= new ArrayList<KhachHangBean>();
		String sql="select * from KhachHang";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		ResultSet rs= cmd.executeQuery();
		while(rs.next())
		{
			Integer MaKH=rs.getInt("makh");
			String hoten = rs.getString("hoten");
			String diachi = rs.getString("diachi");
			String sdt = rs.getString("sodt");
			String email = rs.getString("email");
			String tendn = rs.getString("tendn");
			String pass = rs.getString("pass");
			KhachHangBean kh = new KhachHangBean(MaKH,hoten, diachi, sdt, email, tendn, pass);
			ds.add(kh);	
		}
		rs.close();
		return ds;
	}
	
	public static void main(String[] args) throws Exception{
		KhachHangDao khdao = new KhachHangDao();
		ArrayList<KhachHangBean> ds = khdao.getkh();
		for(KhachHangBean i : ds) {
			System.out.println(i);
		}
	}
}
