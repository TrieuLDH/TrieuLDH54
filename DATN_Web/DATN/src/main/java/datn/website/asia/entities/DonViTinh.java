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
@Table(name = "donvitinh")
public class DonViTinh implements Serializable{

	@Id
	private int iDDonViTinh;
	private String tenDonViTinh;
	private int trangThai;
	
	@JsonIgnore
	@OneToMany(mappedBy = "donvitinh")
	List<ChiTietSanPham> chitietsanpham;
}
