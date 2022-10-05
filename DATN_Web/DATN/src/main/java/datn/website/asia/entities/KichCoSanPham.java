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
@Table(name = "kichcosanpham")
public class KichCoSanPham implements Serializable{

	@Id
	private int iDKichCo;
	private int trangThai;
	
	@JsonIgnore
	@OneToMany(mappedBy = "kichcosanpham")
	List<ChiTietSanPham> chitietsanpham;
}
