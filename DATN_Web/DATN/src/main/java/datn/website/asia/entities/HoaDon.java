package datn.website.asia.entities;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "hoadon")
public class HoaDon implements Serializable{

	@Id
	private int idHoaDon;
	private Date ngayLapHoaDon;
	private float tongTien;
	private String hinhThucThanhToan;
	private int trangThai;
	private String maGiamGia;
	private String ghiChu;
	
	
	@ManyToOne
	@JoinColumn(name = "iDTaiKhoan")
	private TaiKhoan taikhoan;
	
	@ManyToOne
	@JoinColumn(name = "iDNguoiDung")
	private NguoiDung nguoidung;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "hoadon")
	List<HoaDonChiTiet> hoadonchitiet;
}
