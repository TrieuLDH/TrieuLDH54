package datn.website.asia.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@SuppressWarnings("serial")
@Table(name="vaitro")
@Entity
public class VaiTro implements Serializable{

	@Id
	private int iDVaiTro;
	private String tenVaiTro;
	private int trangThai;
	
	@JsonIgnore
	@OneToMany(mappedBy = "vaitro")
	List<TaiKhoan> taikhoan;
}