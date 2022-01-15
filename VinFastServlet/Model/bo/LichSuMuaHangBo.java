package bo;

import java.util.ArrayList;

import bean.LichSuMuaHangBean;
import dao.LichSuMuaHangDao;

public class LichSuMuaHangBo {
	LichSuMuaHangDao lichSuMuaHangDao = new LichSuMuaHangDao();
    public ArrayList<LichSuMuaHangBean> getLichSuMuaHang(int makh)throws Exception {
        return lichSuMuaHangDao.getLichSuMuaHang(makh);
    }
}
