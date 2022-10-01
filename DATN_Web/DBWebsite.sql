CREATE DATABASE WebSiteAsia
GO

USE WebSiteAsia
GO



--Ng??i Dùng
CREATE TABLE NhanVien
(
	    IdNhanVien		INT				PRIMARY KEY
	  , HoTen			NVARCHAR(100)
	  , SDT				NCHAR(15)
	  , Email			NVARCHAR(100)
	  , Password		NVARCHAR(100)
	  , TrangThai		INT
)

--Vai Trò
CREATE TABLE VaiTro
(
	    IdVaiTro		INT				PRIMARY KEY
	  , TenVaiTro		NVARCHAR(50)
	  , TrangThai		INT
	  
)

--Tài Kho?n
CREATE TABLE TaiKhoan
(
	    IdTaiKhoan		INT				PRIMARY KEY
	  , Email			NVARCHAR(100)
	  , IdVaiTro		INT				FOREIGN KEY REFERENCES VaiTro(IdVaiTro)
	  , Password		NVARCHAR(150)
	  , TrangThai		INT
)

--Danh M?c
CREATE TABLE DanhMuc
(
	    IdDanhMuc		INT				PRIMARY KEY
	  , TenDanhMuc		NVARCHAR(100)
	  , TrangThai		INT
)

--Nhà S?n Xu?t
CREATE TABLE NhaSanXuat
(
	    IdNhaSanXuat		INT				PRIMARY KEY
	  , TenNhaSanXuat		NVARCHAR(200)
	  , TrangThai		INT
)

--S?n Ph?m
CREATE TABLE SanPham
(
	    IdSanPham		INT				PRIMARY KEY
	  , IdDanhMuc		INT				FOREIGN KEY REFERENCES DanhMuc(IdDanhMuc)
	  , IdNhaSanXuat	INT				FOREIGN KEY REFERENCES NhaSanXuat(IdNhaSanXuat)
	  , TenSanPham		NVARCHAR(200)
	  , TrangThai		INT

)


-- Gi?i Tính
CREATE TABLE GioiTinh
(
	    IdGioiTinh		INT				PRIMARY KEY
	  , TenGioiTinh		NVARCHAR(200)
	  , TrangThai		INT
)

-- Kích C? S?n Ph?m
CREATE TABLE KichCoSanPham
(
	    IdKichCo		INT				PRIMARY KEY
	  , TrangThai		INT
)

-- Màu S?c
CREATE TABLE MauSac
(
	    IdMauSac		INT				PRIMARY KEY
	  , TenMauSac		NVARCHAR(200)
	  , TrangThai		INT
)
-- DVT
CREATE TABLE DonViTinh
(
	    IdDonViTinh			INT				PRIMARY KEY
	  , TenDonViTinh		NVARCHAR(200)
	  , TrangThai		INT
)
-- Ch?t Li?u
CREATE TABLE ChatLieu
(
	    IdChatLieu		INT				PRIMARY KEY
	  , TenChatLieu		NVARCHAR(200)
	  , TrangThai		INT
)

-- Hóa ??n
CREATE TABLE HoaDon
(
	    IDHoaDon			INT				PRIMARY KEY
	  , IdNhanVien			INT				FOREIGN KEY REFERENCES NhanVien(IdNhanVien)
	  , IdTaiKhoan			INT				FOREIGN KEY REFERENCES TaiKhoan(IdTaiKhoan)
	  , NgayLapHoaDon		DATE
	  , TongGiaTien			FLOAT
	  , HinhThucThanhToan	NVARCHAR(50)
	  , TrangThai			INT
	  , MaGiamGia			NVARCHAR(100)
	  , GhiChu				NVARCHAR(200)
)
-- Chi Ti?t SP
CREATE TABLE ChiTietSanPham
(
	    IdChiTietSanPham			INT				PRIMARY KEY
	  , IdSanPham					INT				FOREIGN KEY REFERENCES SanPham(IdSanPham)
	  , IdKichCo					INT				FOREIGN KEY REFERENCES KichCoSanPham(IdKichCo)
	  , IdMauSac					INT				FOREIGN KEY REFERENCES MauSac(IdMauSac)
	  , IdDonViTinh					INT				FOREIGN KEY REFERENCES DonViTinh(IdDonViTinh)
	  , IdChatLieu					INT				FOREIGN KEY REFERENCES ChatLieu(IdChatLieu)
	  , IdGioiTinh					INT				FOREIGN KEY REFERENCES GioiTinh(IdGioiTinh)
	  , MoTa						NVARCHAR(300)
	  , GiaTien						FLOAT
	  , TenChiTiet					NVARCHAR(100)
	  , SoLuong						INT
	  , TrangThai					INT
)

-- Hóa ??n Chi Ti?t
CREATE TABLE HoaDonChiTiet
(
	    IdHoaDonChiTiet				INT				PRIMARY KEY
	  , IdHoaDon					INT				FOREIGN KEY REFERENCES HoaDon(IdHoaDon)
	  , IdChiTietSanPham			INT				FOREIGN KEY REFERENCES ChiTietSanPham(IdChiTietSanPham)
	  , SoLuong						INT
	  , DonGia						FLOAT
	  , TrangThai					INT
	  , SoTienGiam					FLOAT										
)

