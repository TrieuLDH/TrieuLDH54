package datn.website.asia.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "hoadonchitiet")
public class HoaDonChiTiet implements Serializable{

	@Id
	private int iDHoaDonChiTiet;
	private int soLuong;
	private float donGia;
	private int trangThai;
	private float soTienGiam;
	
	@ManyToOne
	@JoinColumn(name = "iDHoaDon")
	private HoaDon hoadon;
	
	@ManyToMany(mappedBy = "hoadonchitiet")
	private ChiTietSanPham chitietsanpham;
	
}
