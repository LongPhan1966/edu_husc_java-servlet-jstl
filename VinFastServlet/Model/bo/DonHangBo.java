package bo;

import java.util.ArrayList;

import bean.DonHangBean;
import dao.DonHangDao;

public class DonHangBo {
	DonHangDao dhdao= new DonHangDao();
	public ArrayList<DonHangBean> getDH() throws Exception
	{
		return dhdao.getDonHang();
	}
	public int XacNhanDH(Integer madh) throws Exception
	{
		return dhdao.XacNhan(madh);
	}
}
