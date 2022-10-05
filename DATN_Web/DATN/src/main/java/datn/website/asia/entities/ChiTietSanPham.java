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
@Table(name = "chitietsanpham")
public class ChiTietSanPham implements Serializable{

	@Id
	private int iDChiTietSanPham;
	private String moTa;
	private float giaTien;
	private String tenChiTiet;
	private int soLuong;
	private int trangThai;
	
	@ManyToOne
	@JoinColumn(name = "iDSanPham")
	private SanPham sanpham;
	
	@ManyToMany
	private HoaDonChiTiet hoadonchitiet;
	
	@ManyToOne
	@JoinColumn(name = "iDMauSac")
	private MauSac mausac;
	
	@ManyToOne
	@JoinColumn(name = "iDChatLieu")
	private ChatLieu chatlieu;
	
	@ManyToOne
	@JoinColumn(name = "iDKichCo")
	private KichCoSanPham kichcosanpham;
	
	@ManyToOne
	@JoinColumn(name = "iDGioiTinh")
	private GioiTinh gioitinh;
	
	@ManyToOne
	@JoinColumn(name = "iDDonViTinh")
	private DonViTinh donvitinh;
}