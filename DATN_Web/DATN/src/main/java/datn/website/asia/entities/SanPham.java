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

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "SanPham")
public class SanPham implements Serializable{

	@Id
	private int iDSanPham;
	private int iDDanhMuc;
	private String tenSanPham;
	private int trangThai;
	
	@ManyToOne
	@JoinColumn(name = "iDNhaSanXuat")
	private NhaSanXuat nhasanxuat;
	
	@ManyToOne
	@JoinColumn(name = "iDDanhMuc")
	private DanhMuc danhmuc;
	
	@JsonIgnore
	@OneToMany(mappedBy = "sanpham")
	List<ChiTietSanPham> chitietsanpham;
}
