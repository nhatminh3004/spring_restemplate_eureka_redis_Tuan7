package springdatajpa._nhatminh.service;

import springdatajpa._nhatminh.entity.SanPham;

import java.util.List;

public interface ProductService {
    public List<SanPham>getAllSanPham();
    public SanPham getSanPhamByMaSp(String masp);
    public void deleteSanPhamByMaSp(String masp);
    public void addNewSanPham(SanPham sp);
    public void updateSanPhamByMaSp(String masp,SanPham sp);
}
