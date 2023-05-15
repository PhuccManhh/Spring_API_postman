package com.example.controller;



import com.example.model.BanHang;
import com.example.model.NhanVien;
import com.example.repository.INhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NhanVienTM {
    @Autowired
    INhanVienRepository nhanVienRepository;

    ///kiểm tra id yes / no
    @GetMapping("/nhanvien/{id}")
    public NhanVien getById(@PathVariable int id){
        System.out.println(id);
        return nhanVienRepository.findById(id).get();
    }


    //thêm !
    @PostMapping("/themnhanvien")
    public NhanVien insert(@RequestBody NhanVien nhanVien){
        try{
            return nhanVienRepository.save(nhanVien);
        }catch (DataIntegrityViolationException e) {
            return null;
        }
    }

    //xóa!
    @DeleteMapping(path = "/xoanhanvien/{id}")
    public void delete(@PathVariable int id){
        try {
            nhanVienRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
        }
    }

    // chỉnh sửa.
    @PutMapping(path = "/editnhanvien")
    public NhanVien put(@RequestBody NhanVien nhanVien){
        try {
            NhanVien v = nhanVienRepository.findById(nhanVien.getId()).get();
            v.setTenNhanVien(nhanVien.getTenNhanVien());
            v.setMaNhanVien(nhanVien.getMaNhanVien());
            v.setChucVu(nhanVien.getChucVu());
            v.setLuong(nhanVien.getLuong());
            return nhanVienRepository.save(v);
        }catch (DataIntegrityViolationException e) {
            return null;
        }
    }



}
