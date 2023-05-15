package com.example.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "sanpham")
@Data
public class BanHang {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String TenSanPham;
    private int SoLuong;
    private int GiaSanPham;
}
