package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.Loaibean;

public class Loaidao {
	DungChung dc = new DungChung();
	public ArrayList<Loaibean> getloai() throws Exception{
		dc.KetNoi();
		ArrayList<Loaibean> ds= new ArrayList<Loaibean>();
		String sql="select * from loai";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		ResultSet rs= cmd.executeQuery();
		while(rs.next())
		{
			String maloai = rs.getString("maloai");
			String tenloai = rs.getString("tenloai");
			Loaibean loai = new Loaibean( maloai,  tenloai);
			ds.add(loai);
		}
		rs.close();
		dc.cn.close();
		return ds;
	}
	public Loaibean getMotLoai(String maloai) throws Exception
	{
		dc.KetNoi();
		Loaibean loai = null;
		String sql="select * from loai where maloai=?";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		ResultSet rs= cmd.executeQuery();
		while(rs.next())
		{
			String ml = rs.getString("maloai");
			String tenloai = rs.getString("tenloai");
			loai = new Loaibean( ml,  tenloai);
		}
		rs.close();
		return loai;
	}
	public int ThemLoai(String maLoai,String TenLoai) throws Exception
	{
		//b1: ket noi vao csdl
		dc.KetNoi();
		String ktra="select * from loai where maloai=?";
		PreparedStatement ktradk=dc.cn.prepareStatement(ktra);
		ktradk.setString(1,maLoai);
		ResultSet ktdk= ktradk.executeQuery();
		int rs;
		if(ktdk.next() != false)
			return -1;
		else if (ktdk.next() == false)
		{
			String sql="insert into loai (maloai,tenloai) values (?,?)";
			PreparedStatement cmd=dc.cn.prepareStatement(sql);
			cmd.setString(1,maLoai);
			cmd.setString(2,TenLoai);
			//b4: Thuc hien cau lieu
			rs= cmd.executeUpdate();
		}
		else return 0;
		//b6: Dong all 
		ktdk.close();
		dc.cn.close();
		return rs;
	}
	public int XoaLoai(String maLoai) throws Exception
	{
		dc.KetNoi();
		int rs;
		String sql="Delete loai where maloai=?";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		cmd.setString(1,maLoai);
		rs= cmd.executeUpdate();
		//b6: Dong all 
		dc.cn.close();
		return rs;
	}
	public int SuaLoai(String maLoai,String TenLoai) throws Exception {
		dc.KetNoi();
		String sql ="Update loai SET tenloai =? WHERE maloai = ?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1,TenLoai);
		cmd.setString(2,maLoai);
		int check = cmd.executeUpdate();
		dc.cn.close();
		return check;
	}
	
	public static void main(String[] args) throws Exception {
		Loaidao ldao = new Loaidao();
		int a = ldao.SuaLoai("caocap", "Cao cấp");
		
		ArrayList<Loaibean> list = ldao.getloai();
		for(Loaibean i: list) {
			System.out.println(i);
		}
		
	}
}
