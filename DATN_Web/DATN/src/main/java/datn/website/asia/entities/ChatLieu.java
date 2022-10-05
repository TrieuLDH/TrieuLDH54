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
@Table(name = "chatlieu")
public class ChatLieu implements Serializable{
	
	@Id
	private int iDChatLieu;
	private String tenChatLieu;
	private int trangThai;
	
	@JsonIgnore
	@OneToMany(mappedBy = "chatlieu")
	List<ChiTietSanPham> chitietsanpham;
}
