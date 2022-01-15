package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.ChiTietDHBean;
import bean.DonHangBean;

public class DonHangDao {
	DungChung dc=new DungChung();
	public ArrayList<DonHangBean> getDonHang() throws Exception{
		dc.KetNoi();
		ArrayList<DonHangBean> ds= new ArrayList<DonHangBean>();
		String sql="select hd.MaHoaDon, hd.makh, kh.hoten, hd.NgayMua, hd.DaMua, sum(cthd.SoLuongMua * Xe.gia) as ThanhTien\r\n"
				+ "from HoaDon as hd inner join ChiTietHoaDon as cthd on hd.MaHoaDon = cthd.MaHoaDon\r\n"
				+ "					inner join Xe on cthd.maxe = Xe.maxe\r\n"
				+ "					inner join KhachHang as kh on hd.makh = kh.makh\r\n"
				+ "group by hd.MaHoaDon, hd.makh, kh.hoten, hd.NgayMua, hd.DaMua";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		ResultSet rs= cmd.executeQuery();
		while(rs.next())
		{	
			Integer maHD = rs.getInt("MaHoaDon");
			Integer maKH = rs.getInt("makh");
			Date ngayMua = rs.getDate("NgayMua");
			Boolean damua = rs.getBoolean("damua");
			String hoten = rs.getString("hoten");
			Long thanhtien = rs.getLong("ThanhTien");
			DonHangBean donHang = new DonHangBean(maHD, maKH, ngayMua, damua, hoten, thanhtien);
			ds.add(donHang);
		}
		rs.close();
		return ds;
	}
	
	public int XacNhan(int madh) throws Exception
	{
		dc.KetNoi();
		int rs;
		String sql="update hoadon set damua='true' where MaHoaDon=?";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		cmd.setInt(1,madh);
		rs= cmd.executeUpdate();
		dc.cn.close();
		return rs;
	}
	
	public static void main(String[] args) throws Exception{
	DonHangDao ctdh = new DonHangDao();
	ArrayList<DonHangBean> list = ctdh.getDonHang();
	for(DonHangBean i : list) {
		System.out.println(i);
	}
}
}
