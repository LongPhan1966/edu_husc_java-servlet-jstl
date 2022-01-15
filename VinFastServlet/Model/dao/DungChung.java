package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DungChung {
	public Connection cn;
	 public void KetNoi() throws Exception{
		//B1: Xac dinh HQTCSDL
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	System.out.println("Da xac dinh HQTCSDL");
	    	//B2: Ket noi vao csdl
	    	String url="jdbc:sqlserver://LAPCN-LONGPH:1433;databaseName=QlXe;user=sa; password=longph12345";
	    	cn=DriverManager.getConnection(url);
	    	System.out.println("Da ket noi");
	 		}
	 public static void main(String[] args) {
			try {
				DungChung dc = new DungChung();
				dc.KetNoi();
				
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
}
