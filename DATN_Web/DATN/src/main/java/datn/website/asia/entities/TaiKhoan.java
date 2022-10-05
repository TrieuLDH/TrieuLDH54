package datn.website.asia.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Table(name = "taikhoan")
@SuppressWarnings("serial")
@Entity
public class TaiKhoan implements Serializable{

	@Id
	private int idTaiKhoan;
	private String email;
	private String password;
	private int trangThai;
	private String sdt;
	
	@ManyToOne
	@JoinColumn(name = "iDTaiKhoan")
	private VaiTro vaitro;
	
	@JsonIgnore
	@OneToMany(mappedBy = "taikhoan")
	List<HoaDon> hoadon;
}