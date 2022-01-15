package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.Xebean;

public class Xedao {
	DungChung dc=new DungChung();
	public ArrayList<Xebean> getxe() throws Exception{
		dc.KetNoi();
		ArrayList<Xebean> ds= new ArrayList<Xebean>();
		String sql="select * from Xe";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		ResultSet rs= cmd.executeQuery();
		while(rs.next())
		{
			String maxe = rs.getString("maxe");
			String tenxe = rs.getString("tenxe");
			Long soluong = rs.getLong("soluong");
			Long gia = rs.getLong("gia");
			String maloai = rs.getString("maloai");
			String anh = rs.getString("anh");
			Date ngaynhap = rs.getDate("ngaynhap");
			Xebean xe = new Xebean(maxe, tenxe,  gia, soluong, anh, maloai, ngaynhap);
			ds.add(xe);
		}
		rs.close();
		dc.cn.close();
		return ds;
	}
	
	public ArrayList<Xebean> getxeByLoai(String maloai) throws Exception{
		dc.KetNoi();
		ArrayList<Xebean> ds= new ArrayList<Xebean>();
		String sql="select * from Xe where maloai =?";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		ResultSet rs= cmd.executeQuery();
		while(rs.next())
		{
			String maxe = rs.getString("maxe");
			String tenxe = rs.getString("tenxe");
			Long soluong = rs.getLong("soluong");
			Long gia = rs.getLong("gia");
			String maLoai = rs.getString("maloai");
			String anh = rs.getString("anh");
			Date ngaynhap = rs.getDate("ngaynhap");
			Xebean xe = new Xebean(maxe, tenxe,  gia, soluong, anh, maLoai, ngaynhap);
			ds.add(xe);
		}
		rs.close();
		dc.cn.close();
		return ds;
	}
	
	
	
	public Xebean getMotXe(String maxe) throws Exception
	{
		dc.KetNoi();
		Xebean xe = null;
		String sql="select * from Xe where maxe=?";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		cmd.setString(1, maxe);
		ResultSet rs= cmd.executeQuery();
		while(rs.next())
		{
			String mx = rs.getString("maxe");
			String tensach = rs.getString("tenxe");
			Long soluong = rs.getLong("soluong");
			Long gia = rs.getLong("gia");
			String maloai = rs.getString("maloai");
			String anh = rs.getString("anh");
			Date ngaynhap = rs.getDate("ngaynhap");
			xe = new Xebean(mx, tensach, gia, soluong, anh, maloai, ngaynhap);
		}
		rs.close();
		dc.cn.close();
		return xe;
	}
	public int ThemXe(String maxe,String tenxe, Long gia ,Long soluong, String anh,String maloai, java.util.Date ngay) throws Exception
	{
		//b1: ket noi vao csdl
		dc.KetNoi();
		String ktra="select * from Xe where maxe=?";
		PreparedStatement ktradk=dc.cn.prepareStatement(ktra);
		ktradk.setString(1,maxe);
		ResultSet ktdk= ktradk.executeQuery();
		int rs;
		if(ktdk.next() != false)
			return -1;
		else if (ktdk.next() == false)
		{
			String sql="insert into Xe (maxe,tenxe,gia,soluong,anh,maloai,NgayNhap) values (?,?,?,?,?,?,?)";
			PreparedStatement cmd=dc.cn.prepareStatement(sql);
			cmd.setString(1,maxe);
			cmd.setString(2,tenxe);
			cmd.setLong(3,gia);
			cmd.setLong(4,soluong);
			cmd.setString(5,anh);
			cmd.setString(6,maloai);
			cmd.setDate(7, new java.sql.Date(ngay.getTime()));
			//b4: Thuc hien cau lieu
			rs= cmd.executeUpdate();
		}
		else return 0;
		//b6: Dong all 
		ktdk.close();
		dc.cn.close();
		return rs;
	}
	public int XoaXe(String maxe) throws Exception
	{
		dc.KetNoi();
		int rs;
		String sql="Delete Xe where maxe=?";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		cmd.setString(1,maxe);
		rs= cmd.executeUpdate();
		//b6: Dong all 
		dc.cn.close();
		return rs;
	}
	public int SuaXe(String maxe,String tenxe, Long gia ,Long soluong, String maloai, java.util.Date ngay) throws Exception {
		dc.KetNoi();
			String sql ="Update Xe SET maxe =?,tenxe=?,gia= ?, soluong=?, maloai =?,NgayNhap =? WHERE maxe = ?";
			PreparedStatement cmd = dc.cn.prepareStatement(sql);
			cmd.setString(1,maxe);
			cmd.setString(2,tenxe);
			cmd.setLong(3,gia);
			cmd.setLong(4,soluong);
			cmd.setString(5,maloai);
			cmd.setDate(6, new java.sql.Date(ngay.getTime()));
			cmd.setString(7, maxe);
			int check = cmd.executeUpdate();
			dc.cn.close();
			return check;
	}
	
	public ArrayList<Xebean> findByName(String key) throws Exception{
		dc.KetNoi();
		ArrayList<Xebean> ds = new ArrayList<Xebean>();
		String sql = "select * from xe where maxe like ? or tenxe like ?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, "%"+key+"%");
		cmd.setString(2, "%"+key+"%");
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			String mx = rs.getString("maxe");
			String tensach = rs.getString("tenxe");
			Long soluong = rs.getLong("soluong");
			Long gia = rs.getLong("gia");
			String maloai = rs.getString("maloai");
			String anh = rs.getString("anh");
			Date ngaynhap = rs.getDate("ngaynhap");
			ds.add(new Xebean(mx, tensach, gia, soluong, anh, maloai, ngaynhap));
		}
		rs.close();
		dc.cn.close();
		return ds;
	}

}
