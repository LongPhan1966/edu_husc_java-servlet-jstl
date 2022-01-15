package bean;

import java.sql.Timestamp;

public class LichSuMuaHangBean {
	private Long maHD;
    private Long maCTHD;
    private String tenxe;
    private Long Soluongmua;
    private Long giaxe;
    private Timestamp ngaymua;
    private Boolean damua;
	public LichSuMuaHangBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LichSuMuaHangBean(Long maHD, Long maCTHD, String tenxe, Long soluongmua, Long giaxe, Timestamp ngaymua,
			Boolean damua) {
		super();
		this.maHD = maHD;
		this.maCTHD = maCTHD;
		this.tenxe = tenxe;
		this.Soluongmua = soluongmua;
		this.giaxe = giaxe;
		this.ngaymua = ngaymua;
		this.damua = damua;
	}
	public Long getMaHD() {
		return maHD;
	}
	public void setMaHD(Long maHD) {
		this.maHD = maHD;
	}
	public Long getMaCTHD() {
		return maCTHD;
	}
	public void setMaCTHD(Long maCTHD) {
		this.maCTHD = maCTHD;
	}
	public String getTenxe() {
		return tenxe;
	}
	public void setTenxe(String tenxe) {
		this.tenxe = tenxe;
	}
	public Long getSoluongmua() {
		return Soluongmua;
	}
	public void setSoluongmua(Long soluongmua) {
		Soluongmua = soluongmua;
	}
	public Long getGiaxe() {
		return giaxe;
	}
	public void setGiaxe(Long giaxe) {
		this.giaxe = giaxe;
	}
	public Timestamp getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(Timestamp ngaymua) {
		this.ngaymua = ngaymua;
	}
	public Boolean getDamua() {
		return damua;
	}
	public void setDamua(Boolean damua) {
		this.damua = damua;
	}
	@Override
	public String toString() {
		return "LichSuMuaHangBean [maHD=" + maHD + ", maCTHD=" + maCTHD + ", tenxe=" + tenxe + ", Soluongmua="
				+ Soluongmua + ", giaxe=" + giaxe + ", ngaymua=" + ngaymua + ", damua=" + damua + "]";
	}
    
}
