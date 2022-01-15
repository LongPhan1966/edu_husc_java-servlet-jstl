package bo;

import java.util.ArrayList;

import bean.Loaibean;
import dao.Loaidao;

public class Loaibo {
	Loaidao ldao = new Loaidao();
	public ArrayList<Loaibean> getloai() throws Exception
	{
		return ldao.getloai();
	}
	public ArrayList<Loaibean> Tim(String key) throws Exception
	{
		ArrayList<Loaibean> tam = new ArrayList<Loaibean>();
		ArrayList<Loaibean> ds = getloai();
		for(Loaibean s: ds)
			if(s.getTenloai().toLowerCase().trim().contains(key.toLowerCase().trim()))
				tam.add(s);
		return tam;
	}
	public Loaibean getMotLoai(String maloai) throws Exception
	{
		return ldao.getMotLoai(maloai);
	}
	public int ThemLoai(String maLoai,String TenLoai) throws Exception
	{
		return ldao.ThemLoai(maLoai, TenLoai);
	}
	public int XoaLoai(String maLoai) throws Exception
	{
		return ldao.XoaLoai(maLoai);
	}
	public int SuaLoai(String maLoai,String TenLoai) throws Exception {
		return ldao.SuaLoai(maLoai, TenLoai);
	}
}
