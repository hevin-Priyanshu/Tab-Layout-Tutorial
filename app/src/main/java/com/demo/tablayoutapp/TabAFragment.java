package com.demo.tablayoutapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.tablayoutapp.Model.DataSource;
import com.demo.tablayoutapp.Model.MyData;

import java.util.List;

public class TabAFragment extends Fragment {

    public TabAFragment(OnItemClickListener listener) {
        // Required empty public constructor
        this.listener = listener;
    }

    RecyclerView recyclerView;
    OnItemClickListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_a, container, false);

        List<MyData> dataSet = new DataSource().loadDataSourceForFragA();

        recyclerView = view.findViewById(R.id.recyclerViewTabA);

        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(requireContext(), dataSet, listener);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setHasFixedSize(true);


        return view;
    }
}