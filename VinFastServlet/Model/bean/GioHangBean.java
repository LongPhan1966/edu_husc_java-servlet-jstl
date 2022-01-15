package bean;

public class GioHangBean {
	private String MaXe;
	private String TenXe;
	private Long Gia;
	private Long SoLuong;
	private Long ThanhTien;
	public GioHangBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GioHangBean(String maXe, String tenXe, Long gia, Long soLuong, Long thanhTien) {
		super();
		MaXe = maXe;
		TenXe = tenXe;
		Gia = gia;
		SoLuong = soLuong;
		ThanhTien = thanhTien;
	}
	
	public GioHangBean(String maXe, String tenXe, Long gia, Long soLuong) {
		super();
		MaXe = maXe;
		TenXe = tenXe;
		Gia = gia;
		SoLuong = soLuong;
	}
	public String getMaXe() {
		return MaXe;
	}
	public void setMaXe(String maXe) {
		MaXe = maXe;
	}
	public String getTenXe() {
		return TenXe;
	}
	public void setTenXe(String tenXe) {
		TenXe = tenXe;
	}
	public Long getGia() {
		return Gia;
	}
	public void setGia(Long gia) {
		Gia = gia;
	}
	public Long getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(Long soLuong) {
		SoLuong = soLuong;
	}
	public Long getThanhTien() {
		return SoLuong*Gia;
	}
	public void setThanhTien(Long thanhTien) {
		ThanhTien = thanhTien;
	}
	
	
}
