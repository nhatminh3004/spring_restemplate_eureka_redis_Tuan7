package springdatajpa._nhatminh.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springdatajpa._nhatminh.entity.SanPham;
import springdatajpa._nhatminh.repository.SanPhamRepository;


import java.util.List;
import java.util.Optional;

@RestController
public class SanPhamController {
    @Autowired
    private SanPhamRepository sanPhamRepository;

    @GetMapping("/getAllSanPham")
    List<SanPham> getAllSanPham() {
        return sanPhamRepository.findAllSanPham();
    }

    //phương thức thêm sản phẩm mới
    @PostMapping("/addSanPham")
    public ResponseEntity<SanPham> addNewSanPham(@RequestBody SanPham sp) {
        return new ResponseEntity<>(sanPhamRepository.save(sp), HttpStatus.OK);
    }

    //phương thức xoá 1 sản phẩm
    @DeleteMapping("/deleteSanPham/{masp}")
    public ResponseEntity<SanPham> deleteSanPhamByMasp(@PathVariable String masp) {
        Optional<SanPham> sanPhamOptional = sanPhamRepository.findById(masp);
        return sanPhamOptional.map(sp -> {
            sanPhamRepository.deleteById(masp);
            return new ResponseEntity<>(sp, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //phương thức update 1 sản phẩm
    @PutMapping("/updateSanPham/{masp}")
    public ResponseEntity<SanPham> updateSanPhamByMaSp(@PathVariable String masp, @RequestBody SanPham sp) {
        Optional<SanPham> sanPhamOptional = sanPhamRepository.findById(masp);
        return sanPhamOptional.map(sanpham1 -> {
            sp.setMasp(sanpham1.getMasp());
            return new ResponseEntity<>(sanPhamRepository.save(sp), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //Tìm sản phẩm bằng mã sản phẩm
    @GetMapping("/findSanPhamByMaSp/{masp}")
    public ResponseEntity<SanPham> findSanPhamByMaSp(@PathVariable String masp) {
        Optional<SanPham> sanPhamOptional = sanPhamRepository.findById(masp);
        return sanPhamOptional.map(sanpham -> new ResponseEntity<>(sanpham, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
