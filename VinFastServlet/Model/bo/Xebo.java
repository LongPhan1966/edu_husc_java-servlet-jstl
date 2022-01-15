package bo;

import java.util.ArrayList;
import java.util.Date;

import bean.Xebean;
import dao.Xedao;

public class Xebo {
	Xedao xdao= new Xedao();
	public ArrayList<Xebean> getXe() throws Exception
	{
		return xdao.getxe();
	}
	public Xebean getMotXe(String maxe) throws Exception
	{
		return xdao.getMotXe(maxe);
	}
	public ArrayList<Xebean> TimMaLoai(String maloai) throws Exception
	{
		ArrayList<Xebean> tam = new ArrayList<Xebean>();
		ArrayList<Xebean> ds = getXe();
		for(Xebean s:ds)
			if(s.getMaloai().equals(maloai))
				tam.add(s);
		return tam;
	}
	public ArrayList<Xebean> Tim(String key) throws Exception
	{
		ArrayList<Xebean> tam = new ArrayList<Xebean>();
		ArrayList<Xebean> ds = getXe();
		for(Xebean s: ds)
			if(s.getTenxe().toLowerCase().trim().contains(key.toLowerCase().trim()))
				tam.add(s);
		return tam;
	}
	public Long Dem(String maloai) throws Exception
	{
		Long d=(long)0;
		ArrayList<Xebean> ds = getXe();
		for(Xebean s:ds)
			if(s.getMaloai().equals(maloai))
				d++;
		return d;
	}
	
	public ArrayList<Xebean> findByName(String key) throws Exception{
		return xdao.findByName(key);
	}
	
	public int ThemXe(String maxe,String tenxe, Long gia ,Long soluong, String anh,String maloai, java.util.Date ngay) throws Exception
	{
		return xdao.ThemXe(maxe, tenxe, gia, soluong, anh, maloai, ngay);
	}
	public int XoaXe(String maxe) throws Exception
	{
		return xdao.XoaXe(maxe);
	}
	public int SuaXe(String maxe,String tenxe, Long gia ,Long soluong,String maloai, java.util.Date ngay) throws Exception 
	{
		return xdao.SuaXe(maxe, tenxe, gia, soluong, maloai, ngay);
	}
	
	public ArrayList<Xebean> getxeByLoai(String maloai) throws Exception{
		return xdao.getxeByLoai(maloai);
	}
	
}
