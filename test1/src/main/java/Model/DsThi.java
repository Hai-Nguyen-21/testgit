package Model;

import java.io.Serializable;


/**
 * The persistent class for the DS_THI database table.
 * 
 */
public class DsThi {

	private int id,cathi;
	private String loaithi,lop,maMon,ngayThi,tenMon,phongthi;
	

	public DsThi() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCaThi() {
		return this.cathi;
	}

	public void setCaThi(int caThi) {
		this.cathi = caThi;
	}

	public String getLoaiThi() {
		return this.loaithi;
	}

	public void setLoaiThi(String loaiThi) {
		this.loaithi = loaiThi;
	}

	public String getLop() {
		return this.lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public String getMaMon() {
		return this.maMon;
	}

	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}

	public String getNgayThi() {
		return this.ngayThi;
	}

	public void setNgayThi(String ngayThi) {
		this.ngayThi = ngayThi;
	}

	public String getPhongThi() {
		return this.phongthi;
	}

	public void setPhongThi(String phongThi) {
		this.phongthi = phongThi;
	}

	public String getTenMon() {
		return this.tenMon;
	}

	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}


	public DsThi(int caThi, String loaiThi, String lop, String maMon, String ngayThi, String phongThi, String tenMon) {
		super();
		this.cathi = caThi;
		this.loaithi = loaiThi;
		this.lop = lop;
		this.maMon = maMon;
		this.ngayThi = ngayThi;
		this.phongthi = phongThi;
		this.tenMon = tenMon;
	}

	
}