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
@Table(name = "mausac")
public class MauSac implements Serializable{

	@Id
	private int iDMauSac;
	private String tenMauSac;
	private int trangThai;
	
	@JsonIgnore
	@OneToMany(mappedBy = "mausac")
	List<ChiTietSanPham> chitietsanpham;
}
