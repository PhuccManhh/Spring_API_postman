package com.example.repository;

import com.example.model.BanHang;
import com.example.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface INhanVienRepository extends JpaRepository<NhanVien, Integer>  {
    NhanVien findNhanVienById(int id);
}
