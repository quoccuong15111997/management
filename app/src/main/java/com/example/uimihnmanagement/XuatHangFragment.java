package com.example.uimihnmanagement;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.model.ItemNhap;

import java.util.ArrayList;

public class XuatHangFragment extends Fragment {
    static View view;

    RecyclerView rcl_lisNhap;
    ArrayList<ItemNhap> arritemNhap;
   

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_xuathang, container, false);

        addControls();
        addEvents();
        return view;
    }

    private void addEvents() {
    }

    private void addControls() {
    }


}
