package bo;

import java.util.ArrayList;

import bean.GioHangBean;
import dao.GioHangDao;

public class GioHangBo {
	public ArrayList<GioHangBean> ds = new ArrayList<GioHangBean>();
	GioHangDao ghdao = new GioHangDao();
	public void Them(String maxe, String tenxe, Long gia, Long soLuong)
	{
		for(GioHangBean g:ds)
		{
			if(g.getMaXe().equals(maxe))
			{
				g.setSoLuong(g.getSoLuong()+soLuong);
				return;
			}
		}
		ds.add(new GioHangBean(maxe, tenxe, gia, soLuong));
	}
	public void Sua(String maxe, long sl)
	{
		for(GioHangBean g:ds)
		{
			if(g.getMaXe().equals(maxe))
			{
				g.setSoLuong(g.getSoLuong()+sl);
				return;
			}
		}
	}
	public void Xoa(String maxe)
	{
		for(GioHangBean g:ds)
		{
			if(g.getMaXe().equals(maxe))
			{
				ds.remove(g);
				return;
			}
		}
	}
	public void XoaALL()
	{
		ds.removeAll(ds);
		return;
	}
	public Long TongTien()
	{
		long s=0;
		for(GioHangBean g:ds)
			s=s+g.getThanhTien();
		return s;
	}
	
	public int themHoaDonbo(int makh) throws Exception 
	{
		return ghdao.themHoaDondao(makh);
	}
		
	public int maHDVuaTaobo() throws Exception 
	{
		return ghdao.maHDVuaTao();
	}
		
	public void themCTHDbo(ArrayList<GioHangBean> dsgiohang, int maHD) throws Exception 
	{
		for (GioHangBean hang : dsgiohang) {
			ghdao.themCTHDdao(hang.getMaXe(), hang.getSoLuong(), maHD);
		}
	}
}
