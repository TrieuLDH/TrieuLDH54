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
@Entity
@Table(name = "gioitinh")
public class GioiTinh implements Serializable{

	@Id
	private int iDGioiTinh;
	private String tenGioiTinh;
	private int trangThai;
	
	@JsonIgnore
	@OneToMany(mappedBy = "gioitinh")
	List<ChiTietSanPham> chitietsanpham;
}