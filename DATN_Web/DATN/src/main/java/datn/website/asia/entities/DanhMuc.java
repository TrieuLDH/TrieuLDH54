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
@Table(name = "danhmuc")
public class DanhMuc implements Serializable{

	@Id
	private int iDDanhMuc;
	private String tenDanhMuc;
	private int trangThai;
	
	@JsonIgnore
	@OneToMany(mappedBy = "danhmuc")
	List<SanPham> sanpham;
}
