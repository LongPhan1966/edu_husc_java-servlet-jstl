package bean;

import java.sql.Date;

public class DonHangBean {
	private Integer maHD;
	private Integer maKH;
	private Date NgayMua;
	private Boolean damua;
	private String hoTen;
	private Long thanhTien;
	public DonHangBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DonHangBean(Integer maHD, Integer maKH, Date ngayMua, Boolean damua, String hoTen, Long thanhTien) {
		super();
		this.maHD = maHD;
		this.maKH = maKH;
		NgayMua = ngayMua;
		this.damua = damua;
		this.hoTen = hoTen;
		this.thanhTien = thanhTien;
	}
	public Integer getMaHD() {
		return maHD;
	}
	
	public void setMaHD(Integer maHD) {
		this.maHD = maHD;
	}
	public Integer getMaKH() {
		return maKH;
	}
	public void setMaKH(Integer maKH) {
		this.maKH = maKH;
	}
	public Date getNgayMua() {
		return NgayMua;
	}
	public void setNgayMua(Date ngayMua) {
		NgayMua = ngayMua;
	}
	public Boolean getDamua() {
		return damua;
	}
	public void setDamua(Boolean damua) {
		this.damua = damua;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public Long getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(Long thanhTien) {
		this.thanhTien = thanhTien;
	}
	@Override
	public String toString() {
		return "DonHangBean [maHD=" + maHD + ", maKH=" + maKH + ", NgayMua=" + NgayMua + ", damua=" + damua + ", hoTen="
				+ hoTen + ", thanhTien=" + thanhTien + "]";
	}
	
	
}
