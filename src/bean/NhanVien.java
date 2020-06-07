package bean;

public class NhanVien {
	String maNhanVien ;
	String name ;
	int age ;
	String email ;
	String luong ;
	
	public NhanVien() {
		
	}
	public NhanVien(String maNhanVien, String name, int age, String email, String luong) {
		this.maNhanVien = maNhanVien;
		this.name = name;
		this.age = age;
		this.email = email;
		this.luong = luong;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLuong() {
		return luong;
	}
	public void setLuong(String luong) {
		this.luong = luong;
	}
	

}
