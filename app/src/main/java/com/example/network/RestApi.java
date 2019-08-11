package com.example.network;

import com.example.model.ChiTietPhieuNhap;
import com.example.model.DanhMuc;
import com.example.model.NhanHieu;
import com.example.model.NhanVien;
import com.example.model.PhieuNhap;
import com.example.model.SanPham;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestApi {
    @GET("danhmuc")
    Call<List<DanhMuc>> getDanhMuc();

    @GET("nhanhieu")
    Call<List<NhanHieu>> getNhanHieu();

    @GET("phieunhap")
    Call<List<PhieuNhap>> getListPhieuNhap();

    @GET("ctphieunhap/{id}")
    Call<List<ChiTietPhieuNhap>> getDetailPhieuNhap(@Path("id") int id);

    @GET("sanpham/{id}")
    Call<SanPham> getSanPham(@Path("id") int id);

    @GET("sanpham")
    Call<List<SanPham>> getListSanPhamTheoDanhMuc(@Query("madm") int madm);

    @GET("sanpham")
    Call<SanPham> getSanPhamTheoTen(@Query("tenSanPhamTim") String tensp);

    @POST("sanpham")
    Call<Boolean> xoaSanPham(@Query("maSp") int masp);

    @POST("sanpham")
    Call<Boolean> suaTenSanPham(@Query("maSpSua") int masp, @Query("tenSp") String tensp);

    @POST("sanpham")
    Call<Boolean> suaDonGiaSanPham(@Query("maSpSua") int masp, @Query("giaSp") int giaSp);

    @POST("sanpham")
    Call<Boolean> suaMoTaSanPham(@Query("maSpSua") int masp, @Query("moTa") String mota);

    @POST("sanpham")
    Call<Boolean> suaHinhSanPham(@Query("maSpSua") int masp, @Query("hinh") String hinh);

    @GET("nhanvien")
    Call<List<NhanVien>> getNhanVienTheoUsername(@Query("userName") String username);
}
