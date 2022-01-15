package bean;

public class KhachHangBean {
	private Integer MaKH;
	private String HoTenKH;
	private String DiaChi;
	private String SDT;
	private String Email;
	private String TenDN;
	private String MatKhau;
	
	
	@Override
	public String toString() {
		return "KhachHangBean [MaKH=" + MaKH + ", HoTenKH=" + HoTenKH + ", DiaChi=" + DiaChi + ", SDT=" + SDT
				+ ", Email=" + Email + ", TenDN=" + TenDN + ", MatKhau=" + MatKhau + "]";
	}
	public KhachHangBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhachHangBean(Integer maKH, String hoTenKH, String diaChi, String sDT, String email, String tenDN,
			String matKhau) {
		super();
		MaKH = maKH;
		HoTenKH = hoTenKH;
		DiaChi = diaChi;
		SDT = sDT;
		Email = email;
		TenDN = tenDN;
		MatKhau = matKhau;
	}
	
	public KhachHangBean(String hoTenKH, String diaChi, String sDT, String email, String tenDN,
			String matKhau) {
		super();
		HoTenKH = hoTenKH;
		DiaChi = diaChi;
		SDT = sDT;
		Email = email;
		TenDN = tenDN;
		MatKhau = matKhau;
	}
	public Integer getMaKH() {
		return MaKH;
	}
	public void setMaKH(Integer maKH) {
		MaKH = maKH;
	}
	public String getHoTenKH() {
		return HoTenKH;
	}
	public void setHoTenKH(String hoTenKH) {
		HoTenKH = hoTenKH;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTenDN() {
		return TenDN;
	}
	public void setTenDN(String tenDN) {
		TenDN = tenDN;
	}
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
	
	
}
