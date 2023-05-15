package com.example.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nhanvien")
@Data
public class NhanVien {
    @Id

    private int id;
    private String TenNhanVien;
    private int MaNhanVien;
    private String ChucVu;
    private int Luong;
}
