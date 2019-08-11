package com.example.uimihnmanagement;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.model.DanhMuc;
import com.example.model.NhanHieu;
import com.example.model.SanPham;
import com.example.network.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThemSanPhamActivity extends AppCompatActivity {
    ImageView imgSanPham, iv_back;
    EditText et_Ma, et_Ten, et_Gia, et_SoLuong, et_MoTa;
    Button bt_luu;
    TextView txtTenSanPham;

    Spinner spinner_danhMuc;
    ArrayAdapter<DanhMuc> danhMucAdapter;
    ArrayList<DanhMuc> arrDM;


    Spinner spinner_NhanHieu;
    ArrayAdapter<NhanHieu> nhanHieuAdapter;
    ArrayList<NhanHieu> arrNH;

    SanPham sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_san_pham);

        addControls();
        addEvents();
    }

    private void addEvents() {
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result",100);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });

        bt_luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    private void addControls() {
        iv_back=findViewById(R.id.iv_backChiTiet);

        et_Ma=findViewById(R.id.edtMaSpChiTiet);
        et_Ten=findViewById(R.id.edtTenSpChiTiet);
        et_Gia=findViewById(R.id.edtDonGiaSpChiTiet);
        et_SoLuong=findViewById(R.id.edtSoLuongSpChiTiet);
        et_MoTa = findViewById(R.id.edtMotaSpChiTiet);

        bt_luu=findViewById(R.id.btnLuuChiTiet);

        imgSanPham=findViewById(R.id.imgSanPham);
        txtTenSanPham=findViewById(R.id.txtTen);

        arrDM = new ArrayList<>();
        layDanhSachDM();
        spinner_danhMuc=findViewById(R.id.spinner_ChungLoai);
        danhMucAdapter= new ArrayAdapter<>(ThemSanPhamActivity.this,android.R.layout.simple_spinner_item);
        danhMucAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_danhMuc.setAdapter(danhMucAdapter);

        arrNH = new ArrayList<>();
        layDanhSachNH();
        spinner_NhanHieu = findViewById(R.id.spinner_NhanHieu);
        nhanHieuAdapter = new ArrayAdapter<>(ThemSanPhamActivity.this, android.R.layout.simple_spinner_item);
        nhanHieuAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_NhanHieu.setAdapter(nhanHieuAdapter);


    }

    private void layDanhSachDM(){
        ApiService.getInstance().getDanhMuc(new Callback<List<DanhMuc>>() {
            @Override
            public void onResponse(Call<List<DanhMuc>> call, Response<List<DanhMuc>> response) {
                Log.d("AAAAA", response.toString());
                if(response.isSuccessful()){
                    List<DanhMuc> list = response.body();

                    danhMucAdapter.addAll(list);
                    danhMucAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<DanhMuc>> call, Throwable t) {
                Log.d("aaaaaa", t.toString());
            }
        });
    }

    private void layDanhSachNH(){
        ApiService.getInstance().getNhanHieu(new Callback<List<NhanHieu>>() {
            @Override
            public void onResponse(Call<List<NhanHieu>> call, Response<List<NhanHieu>> response) {
                if (response.isSuccessful()){
                    List<NhanHieu> list = response.body();
                    nhanHieuAdapter.addAll(list);
                    nhanHieuAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<NhanHieu>> call, Throwable t) {

            }
        });
    }


}
