package com.example.controller;

import com.example.model.BanHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;
import com.example.repository.IBanHangRepository;

@RestController
public class BanHangTM {
    @Autowired
    IBanHangRepository banHangRepository;

    ///kiểm tra id yes / no
    @GetMapping("/banhang/{id}")
    public BanHang getById(@PathVariable int id){
        System.out.println(id);
        return banHangRepository.findById(id).get();
    }

    //thêm !
    @PostMapping("/thembanhang")
    public BanHang insert(@RequestBody BanHang banHang){
        try{
            return banHangRepository.save(banHang);
        }catch (DataIntegrityViolationException e) {
            return null;
        }
    }

    //xóa!
    @DeleteMapping(path = "/xoabanhang/{id}")
    public void delete(@PathVariable int id){
        try {
            banHangRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
        }
    }

// chỉnh sửa.
    @PutMapping(path = "/editbanhang")
    public BanHang put(@RequestBody BanHang banhang){
        try {
            BanHang b = banHangRepository.findById(banhang.getId()).get();
            b.setTenSanPham(banhang.getTenSanPham());
            b.setSoLuong(banhang.getSoLuong());
            b.setGiaSanPham(banhang.getGiaSanPham());
            return banHangRepository.save(b);
        }catch (DataIntegrityViolationException e) {
            return null;
        }
    }

}
