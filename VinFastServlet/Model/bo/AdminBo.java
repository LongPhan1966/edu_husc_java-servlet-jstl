package bo;

import bean.AdminBean;
import dao.AdminDao;

public class AdminBo {
	AdminDao amdao = new AdminDao();
	public AdminBean ktdn(String tendn, String mk) throws Exception
	{
		return amdao.ktdn(tendn, mk);
	}
	
}
