package springdatajpa._nhatminh.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import springdatajpa._nhatminh.entity.SanPham;

import java.util.List;

public class ProductServiceImpl implements  ProductService{
    private static final String GET_SanPham_ALL_URL = "http://localhost:8080/getAllSanPham";
    private static final String GET_SanPham_ByMaSP_URL = "http://localhost:8080/findSanPhamByMaSp";
    private static final String CREATE_SanPham_URL = "http://localhost:8080/addSanPham";
    private static final String UPDATE_SanPham_URL = "http://localhost:8080/updateSanPham";
    private static final String DELETE_SanPham_URL = "http://localhost:8080/deleteSanPham/";
    private RestTemplate restTemplate;

    public ProductServiceImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<SanPham> getAllSanPham() {
        ResponseEntity<List<SanPham>> responseEntity =restTemplate.exchange(GET_SanPham_ALL_URL, HttpMethod.GET,null,new ParameterizedTypeReference<List<SanPham>>(){});
        List<SanPham> listSanPham = responseEntity.getBody();
        return listSanPham;
    }

    @Override
    public SanPham getSanPhamByMaSp(String masp) {
        SanPham sp = restTemplate.getForObject(GET_SanPham_ByMaSP_URL+"/"+masp,SanPham.class);
        return sp;
    }

    @Override
    public void deleteSanPhamByMaSp(String masp) {
        restTemplate.delete(DELETE_SanPham_URL+masp);
    }

    @Override
    public void addNewSanPham(SanPham sp) {
        restTemplate.postForObject(CREATE_SanPham_URL,sp,String.class);
    }

    @Override
    public void updateSanPhamByMaSp(String masp,SanPham sp) {

        restTemplate.put(UPDATE_SanPham_URL+"/"+masp,sp);
    }
}
