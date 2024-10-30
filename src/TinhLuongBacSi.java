
public class TinhLuongBacSi {
    public static double tinhLuong(double luongCoBan, double heSoLuong) {
        return luongCoBan * heSoLuong;
    }

    public static double tinhLuong(double luongCoBan, double heSoLuong, int soNamKinhNghiem) {
        return luongCoBan * heSoLuong * (1 + soNamKinhNghiem * 0.05);
    }

    public static double tinhLuong(double luongCoBan, double heSoLuong, int soNamKinhNghiem, int loai) {
        double heSoLoai = (loai == 1) ? 1.2 : 1.45;
        return luongCoBan * heSoLuong * (1 + soNamKinhNghiem * 0.05) * heSoLoai;
    }

    public static void main(String[] args) {
        double luongCoBan = 19000000;
        double heSoLuong = 2.5;
        int soNamKinhNghiem = 5;
        int loai = 2; // Đa khoa

        // Gọi các hàm tính lương
        System.out.println("Lương với 2 tham số: " + tinhLuong(luongCoBan, heSoLuong));
        System.out.println("Lương với 3 tham số: " + tinhLuong(luongCoBan, heSoLuong, soNamKinhNghiem));
        System.out.println("Lương với 4 tham số: " + tinhLuong(luongCoBan, heSoLuong, soNamKinhNghiem, loai));
    }
}