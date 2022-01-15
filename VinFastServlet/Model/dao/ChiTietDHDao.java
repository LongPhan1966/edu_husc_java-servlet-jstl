package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.ChiTietDHBean;

public class ChiTietDHDao {
	DungChung dc=new DungChung();
	public ArrayList<ChiTietDHBean> getDonHang(int madh) throws Exception{
		dc.KetNoi();
		ArrayList<ChiTietDHBean> ds= new ArrayList<ChiTietDHBean>();
		String sql="select * from ChiTietHoaDon as cthd inner join HoaDon as hd on cthd.MaHoaDon = hd.MaHoaDon\r\n"
				+ "									inner join Xe on cthd.maxe = Xe.maxe\r\n"
				+ "									inner join Loai on xe.maloai = Loai.maloai\r\n"
				+ "									inner join KhachHang as kh on hd.makh = kh.makh\r\n"
				+ "			where hd.MaHoaDon = ?";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		cmd.setInt(1,madh);
		ResultSet rs= cmd.executeQuery();
		while(rs.next())
		{	
			Integer maCTHD = rs.getInt("MaChiTietHD");
			String maxe = rs.getString("maxe");
			Integer sMua = rs.getInt("SoLuongMua");
			Integer maHoaDon = rs.getInt("MaHoaDon");
			String tenxe = rs.getString("tenxe");
			String tenloai = rs.getString("tenloai");
			String HoTenKH = rs.getString("hoten");
			String SDT = rs.getString("sodt");
			ChiTietDHBean donHang = new ChiTietDHBean(maCTHD, maxe, sMua, maHoaDon, tenxe, tenloai, HoTenKH, SDT);
			ds.add(donHang);
		}
		rs.close();
		return ds;
	}
	
//	public static void main(String[] args) throws Exception{
//		ChiTietDHDao ctdh = new ChiTietDHDao();
//		ArrayList<ChiTietDHBean> list = ctdh.getDonHang(1);
//		for(ChiTietDHBean i : list) {
//			System.out.println(i);
//		}
//	}
}
