package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import bean.LichSuMuaHangBean;

public class LichSuMuaHangDao {
	DungChung dc = new DungChung();
	public ArrayList<LichSuMuaHangBean> getLichSuMuaHang(int makh)throws Exception{
		ArrayList<LichSuMuaHangBean> list = new ArrayList<LichSuMuaHangBean>();
        String sql = "select cthd.MaHoaDon,MaChiTietHD,tenxe,SoLuongMua,anh,gia,  NgayMua, hd.DaMua\r\n"
		        		+ "from hoadon as hd inner join ChiTietHoaDon as cthd on hd.MaHoaDon = cthd.MaHoaDon\r\n"
		        		+ "					inner join Xe on cthd.maxe = Xe.maxe\r\n"
		        		+ "where makh = ? \r\n"
		        		+ "order by cthd.MaHoaDon desc";
        dc.KetNoi();
        	PreparedStatement cmd=dc.cn.prepareStatement(sql);
        	cmd.setInt(1, makh);
        	ResultSet rs= cmd.executeQuery();
            while (rs.next()) 
            {
                 Long maHD = rs.getLong("MaHoaDon");
                 Long maCTHD = rs.getLong("MaChiTietHD");
                 String tensach= rs.getString("tenxe");
                 Long Soluongmua = rs.getLong("SoLuongMua");
                 Long giaxe = rs.getLong("gia");
                 Timestamp ngaymua = rs.getTimestamp("NgayMua");
                 Boolean damua = rs.getBoolean("damua");
                 list.add(new LichSuMuaHangBean(maHD,maCTHD,tensach,Soluongmua,giaxe,ngaymua,damua));
            }
            rs.close();
            dc.cn.close();
        return list;
    }

	public static void main(String[] args) throws Exception{
		LichSuMuaHangDao lsdao = new LichSuMuaHangDao();
		ArrayList<LichSuMuaHangBean> ds = lsdao.getLichSuMuaHang(1);
		for(LichSuMuaHangBean i : ds) {
			System.out.println(i);
		}
	}
}
