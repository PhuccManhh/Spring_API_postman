package com.example.repository;

import com.example.model.BanHang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBanHangRepository extends JpaRepository<BanHang, Integer> {
    BanHang findBanHangById(int id);

}
