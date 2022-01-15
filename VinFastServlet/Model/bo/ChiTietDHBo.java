package bo;

import java.util.ArrayList;

import bean.ChiTietDHBean;
import dao.ChiTietDHDao;

public class ChiTietDHBo {
	ChiTietDHDao ctdhdao = new ChiTietDHDao();
	public ArrayList<ChiTietDHBean> getDH(int madh) throws Exception{
		return ctdhdao.getDonHang(madh);
	}
}
