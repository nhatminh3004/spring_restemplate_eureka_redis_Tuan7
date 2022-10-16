package springdatajpa._nhatminh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import springdatajpa._nhatminh.entity.SanPham;

import javax.transaction.Transactional;
import java.util.List;

public interface SanPhamRepository extends JpaRepository<SanPham, String> {
    @Modifying
    @Transactional
    @Query(value = "select * from sanpham", nativeQuery = true)
    public List<SanPham> findAllSanPham();

}
