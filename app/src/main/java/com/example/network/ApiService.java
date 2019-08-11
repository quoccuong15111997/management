package com.example.network;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.example.model.ChiTietPhieuNhap;
import com.example.model.DanhMuc;
import com.example.model.NhanHieu;
import com.example.model.NhanVien;
import com.example.model.PhieuNhap;
import com.example.model.SanPham;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiService {
    private static ApiService apiService;

    private Retrofit retrofit;

    private ApiService(String baseUrl) {
        initClient(baseUrl);
    }

    private void initClient(@NonNull String baseUrl) {
        if (TextUtils.isEmpty(baseUrl)) {
            return;
        }
        if (!baseUrl.endsWith("/")) {
            baseUrl = baseUrl + "/";
        }
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create());
        retrofit = builder.build();
    }

    public static void init(@NonNull String baseUrl) {
        if (apiService == null) {
            apiService = new ApiService(baseUrl);
        }
    }

    public static ApiService getInstance() {
        return apiService;
    }

    public void getDanhMuc(Callback<List<DanhMuc>> callback){
        if(retrofit != null){
            Call<List<DanhMuc>> getDanhMucApi = retrofit.create(RestApi.class).getDanhMuc();
            getDanhMucApi.enqueue(callback);
        }
    }

    public void getNhanHieu(Callback<List<NhanHieu>> callback){
        if(retrofit != null){
            Call<List<NhanHieu>> getNhanHieuApi = retrofit.create(RestApi.class).getNhanHieu();
            getNhanHieuApi.enqueue(callback);
        }
    }

    public void getListPhieuNhap(Callback<List<PhieuNhap>> callback){
        if(retrofit != null){
            Call<List<PhieuNhap>> getListPhieuNhapAPI = retrofit.create(RestApi.class).getListPhieuNhap();
            getListPhieuNhapAPI.enqueue(callback);
        }
    }

    public void getDetailPhieuNhap(int id,Callback<List<ChiTietPhieuNhap>> callback){
        if(retrofit != null){
            Call<List<ChiTietPhieuNhap>> getDetailPhieuNhapApi = retrofit.create(RestApi.class).getDetailPhieuNhap(id);
            getDetailPhieuNhapApi.enqueue(callback);
        }
    }

    public void getSanPham(int id,Callback<SanPham> callback){
        if(retrofit != null){
            Call<SanPham> getSanPhamApi = retrofit.create(RestApi.class).getSanPham(id);
            getSanPhamApi.enqueue(callback);
        }
    }
    public void getListSanPhamTheoDanhMuc(int maDM,Callback<List<SanPham>> callback){
        if(retrofit != null){
            Call<List<SanPham>> getSanPhamApi = retrofit.create(RestApi.class).getListSanPhamTheoDanhMuc(maDM);
            getSanPhamApi.enqueue(callback);
        }
    }
    public void getSanPhamTheoTen(String tenSp,Callback<SanPham> callback){
        if(retrofit != null){
            Call<SanPham> getSanPhamApi = retrofit.create(RestApi.class).getSanPhamTheoTen(tenSp);
            getSanPhamApi.enqueue(callback);
        }
    }
    public void xoaSanPham(int masp,Callback<Boolean> callback){
        if(retrofit != null){
            Call<Boolean> getSanPhamApi = retrofit.create(RestApi.class).xoaSanPham(masp);
            getSanPhamApi.enqueue(callback);
        }
    }
    public void suaTenSanPham(int masp,String tensp,Callback<Boolean> callback){
        if(retrofit != null){
            Call<Boolean> getSanPhamApi = retrofit.create(RestApi.class).suaTenSanPham(masp,tensp);
            getSanPhamApi.enqueue(callback);
        }
    }
    public void suaDonGiaSanPham(int masp,int Dongia,Callback<Boolean> callback){
        if(retrofit != null){
            Call<Boolean> getSanPhamApi = retrofit.create(RestApi.class).suaDonGiaSanPham(masp,Dongia);
            getSanPhamApi.enqueue(callback);
        }
    }
    public void suaMoTaSanPham(int masp,String mota,Callback<Boolean> callback){
        if(retrofit != null){
            Call<Boolean> getSanPhamApi = retrofit.create(RestApi.class).suaMoTaSanPham(masp,mota);
            getSanPhamApi.enqueue(callback);
        }
    }
    public void suaHinhSanPham(int masp,String hinh,Callback<Boolean> callback){
        if(retrofit != null){
            Call<Boolean> getSanPhamApi = retrofit.create(RestApi.class).suaHinhSanPham(masp,hinh);
            getSanPhamApi.enqueue(callback);
        }
    }
    public void getNhanVienTheoUserName(String username,Callback<List<NhanVien>> callback){
        if(retrofit != null){
            Call<List<NhanVien>> getSanPhamApi = retrofit.create(RestApi.class).getNhanVienTheoUsername(username);
            getSanPhamApi.enqueue(callback);
        }
    }
}
