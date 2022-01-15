package bean;

import java.sql.Date;

public class Xebean {
	private String maxe;
	private String tenxe;
	private Long gia;
	private Long soluong;
	private String anh;
	private String maloai;
	private Date ngayNhap;
	public Xebean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Xebean(String maxe, String tenxe, Long gia, Long soluong, String anh, String maloai, Date ngayNhap) {
		super();
		this.maxe = maxe;
		this.tenxe = tenxe;
		this.gia = gia;
		this.soluong = soluong;
		this.anh = anh;
		this.maloai = maloai;
		this.ngayNhap = ngayNhap;
	}
	
	public String getMaxe() {
		return maxe;
	}
	public void setMaxe(String maxe) {
		this.maxe = maxe;
	}
	public String getTenxe() {
		return tenxe;
	}
	public void setTenxe(String tenxe) {
		this.tenxe = tenxe;
	}
	public Long getGia() {
		return gia;
	}
	public void setGia(Long gia) {
		this.gia = gia;
	}
	public Long getSoluong() {
		return soluong;
	}
	public void setSoluong(Long soluong) {
		this.soluong = soluong;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getMaloai() {
		return maloai;
	}
	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}
	public Date getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	@Override
	public String toString() {
		return "Xebean [maxe=" + maxe + ", tenxe=" + tenxe + ", gia=" + gia + ", soluong=" + soluong + ", anh=" + anh
				+ ", maloai=" + maloai + ", ngayNhap=" + ngayNhap + "]";
	}
	
	
}
