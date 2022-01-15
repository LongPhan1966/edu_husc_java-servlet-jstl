package bo;

import java.util.ArrayList;

import bean.KhachHangBean;
import dao.KhachHangDao;

public class KhachHangBo {
	KhachHangDao khdao = new KhachHangDao();
	public KhachHangBean ktdn(String tendn, String mk) throws Exception
	{
		return khdao.ktdn(tendn, mk);
	}
	public int ktdk(String hoten,String diachi,String sodt, String email ,String tendn, String mk) throws Exception
	{
		return khdao.ktdk(hoten, diachi, sodt, email, tendn, mk);
	}
	public ArrayList<KhachHangBean> getKH() throws Exception
	{
		return khdao.getkh();
	}
	public int XoaKH(Integer makh) throws Exception
	{
		return khdao.XoaKH(makh);
	}
}
