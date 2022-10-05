package datn.website.asia.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Table(name = "nhanvien")
@Entity
public class NguoiDung implements Serializable{
	
	@Id
	private int idNguoiDung;
	private String hoTen;
	private String sdt;
	private String email;
	private String password;
	private int trangThai;

	@JsonIgnore
	@OneToMany(mappedBy = "nguoidung")
	List<HoaDon> hoadon;
}