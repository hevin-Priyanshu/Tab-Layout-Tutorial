package com.demo.tablayoutapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.demo.tablayoutapp.Model.DataSource;
import com.demo.tablayoutapp.Model.MyData;

import java.util.List;


public class TabBFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match

    public TabBFragment(OnItemClickListener listener) {
        // Required empty public constructor
        this.listener = listener;
    }

    RecyclerView recyclerView;
    OnItemClickListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_b, container, false);

        List<MyData> dataSet = new DataSource().loadDataSourceForFragB();

        recyclerView = view.findViewById(R.id.recyclerViewTabB);

        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(requireContext(), dataSet, listener);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setHasFixedSize(true);

        return view;
    }
}