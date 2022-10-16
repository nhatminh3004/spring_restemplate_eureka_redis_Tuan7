package springdatajpa._nhatminh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import springdatajpa._nhatminh.entity.SanPham;
import springdatajpa._nhatminh.service.ProductService;
import springdatajpa._nhatminh.service.ProductServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController

public class Controller {
    private ProductService productService = new ProductServiceImpl();


    @GetMapping("/api/getsanphambyMaSP/{masp}")
    public SanPham sanPhamByMaSp(@PathVariable String masp){
      return  productService.getSanPhamByMaSp(masp);
    }
    @GetMapping("/api/getAllSP")
    public List<SanPham> getAllSanPham(){

        return  productService.getAllSanPham();
    }
    @PostMapping("/api/addSanPham")
    public SanPham addNewSanPham(@RequestBody SanPham sp) {
         productService.addNewSanPham(sp);
        return  sp;
    }
    @PutMapping("/api/updateSanPham/{masp}")
    public SanPham updateSanPhamByMaSp(@PathVariable String masp, @RequestBody SanPham sp) {
        productService.updateSanPhamByMaSp(masp,sp);
        SanPham spsaukhiupdate = sp;
        spsaukhiupdate.setMasp(masp);
        return  spsaukhiupdate;
    }
    @DeleteMapping("/api/deleteSanPham/{masp}")
    public String deleteSanPhamByMasp(@PathVariable String masp) {
       productService.deleteSanPhamByMaSp(masp);
       return  "Delete thành công";
    }

}
