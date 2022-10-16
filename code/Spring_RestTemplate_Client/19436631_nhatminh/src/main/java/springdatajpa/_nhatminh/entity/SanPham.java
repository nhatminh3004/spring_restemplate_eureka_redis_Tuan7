package springdatajpa._nhatminh.entity;




public class SanPham {

    private String masp;

    private String tensp;

    private int giasp;

    private String loaisp;

    public SanPham() {
    }

    public SanPham(String masp, String tensp, int giasp, String loaisp) {
        this.masp = masp;
        this.tensp = tensp;
        this.giasp = giasp;
        this.loaisp = loaisp;
    }

    public String getMasp() {
        return masp;
    }

    public String getTensp() {
        return tensp;
    }

    public int getGiasp() {
        return giasp;
    }

    public String getLoaisp() {
        return loaisp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public void setGiasp(int giasp) {
        this.giasp = giasp;
    }

    public void setLoaisp(String loaisp) {
        this.loaisp = loaisp;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "masp='" + masp + '\'' +
                ", tensp='" + tensp + '\'' +
                ", giasp=" + giasp +
                ", loaisp='" + loaisp + '\'' +
                '}';
    }
}
