package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GioHangDao {
	// Thêm hóa đơn mới
			public int themHoaDondao(int makh) throws Exception {
				DungChung dc = new DungChung();
				dc.KetNoi();
				String sql="INSERT dbo.hoadon (makh, NgayMua, damua) VALUES (?, GETDATE(), 0)";
				PreparedStatement cmd=dc.cn.prepareStatement(sql);
				cmd.setInt(1, makh);
				return cmd.executeUpdate();
			}
			
			//Thêm chi tiết hóa đơn
			public int themCTHDdao(String masach, long soluongmua, int mahd) throws Exception {
				DungChung dc = new DungChung();
				dc.KetNoi();
				String sql=" INSERT dbo.ChiTietHoaDon (maxe, SoLuongMua, MaHoaDon, damua)  VALUES (?,?,?, 0)";
				PreparedStatement cmd=dc.cn.prepareStatement(sql);
				cmd.setString(1, masach);
				cmd.setLong(2, soluongmua);
				cmd.setInt(3, mahd);
				return cmd.executeUpdate();
			}
			
			//Lấy ra mã hóa đơn vừa được tạo ra
			public int maHDVuaTao() throws Exception {
				DungChung dc = new DungChung();
				dc.KetNoi();
				int maHDVuaTao = 0;
				String sql = "SELECT MAX(MaHoaDon) MaHoaDon FROM dbo.hoadon";
				PreparedStatement cmd=dc.cn.prepareStatement(sql);
				ResultSet rs = cmd.executeQuery();
				while(rs.next()) {
					maHDVuaTao = rs.getInt("MaHoaDon");
				}
				rs.close();
				dc.cn.close();
				return maHDVuaTao;
			}
}
