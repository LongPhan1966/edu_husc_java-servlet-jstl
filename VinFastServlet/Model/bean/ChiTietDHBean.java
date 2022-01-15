package bean;

public class ChiTietDHBean {
	private Integer maChiTietHD;
	private String maXe;
	private Integer soluongMua;
	private Integer MaHoaDon;
	private String tenxe;
	private String tenloai;
	private String HoTenKH;
	private String SDT;
	public ChiTietDHBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChiTietDHBean(Integer maChiTietHD, String maXe, Integer soluongMua, Integer maHoaDon, String tenxe,
			String tenloai, String hoTenKH, String sDT) {
		super();
		this.maChiTietHD = maChiTietHD;
		this.maXe = maXe;
		this.soluongMua = soluongMua;
		MaHoaDon = maHoaDon;
		this.tenxe = tenxe;
		this.tenloai = tenloai;
		HoTenKH = hoTenKH;
		SDT = sDT;
	}
	public Integer getMaChiTietHD() {
		return maChiTietHD;
	}
	public void setMaChiTietHD(Integer maChiTietHD) {
		this.maChiTietHD = maChiTietHD;
	}
	public String getMaXe() {
		return maXe;
	}
	public void setMaXe(String maXe) {
		this.maXe = maXe;
	}
	public Integer getSoluongMua() {
		return soluongMua;
	}
	public void setSoluongMua(Integer soluongMua) {
		this.soluongMua = soluongMua;
	}
	public Integer getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(Integer maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	public String getTenxe() {
		return tenxe;
	}
	public void setTenxe(String tenxe) {
		this.tenxe = tenxe;
	}
	public String getTenloai() {
		return tenloai;
	}
	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}
	public String getHoTenKH() {
		return HoTenKH;
	}
	public void setHoTenKH(String hoTenKH) {
		HoTenKH = hoTenKH;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	@Override
	public String toString() {
		return "ChiTietDHBean [maChiTietHD=" + maChiTietHD + ", maXe=" + maXe + ", soluongMua=" + soluongMua
				+ ", MaHoaDon=" + MaHoaDon + ", tenxe=" + tenxe + ", tenloai=" + tenloai + ", HoTenKH=" + HoTenKH
				+ ", SDT=" + SDT + "]";
	}
	
}
