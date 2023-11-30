package com.demo.tablayoutapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.tablayoutapp.Model.MyData;

public class OpenNewFragment extends Fragment {

    //    MyData myData;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public OpenNewFragment() {
        // Required empty public constructor

    }


    TextView textView;
    ImageView imageView;

    public static OpenNewFragment newInstance(MyData myData) {
        OpenNewFragment fragment = new OpenNewFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, myData.getStringResourceId());
        args.putInt(ARG_PARAM2, myData.getImageResourceId());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_open_new, container, false);

        textView = view.findViewById(R.id.item_title);
        imageView = view.findViewById(R.id.item_image);

        int stringResourceId = getArguments().getInt(ARG_PARAM1);
        String stringResource = getString(stringResourceId);

        textView.setText(stringResource);
        int image = getArguments().getInt(ARG_PARAM2);

        Log.d("TAG", "Data: " + stringResourceId);
        Log.d("TAG", "Image: " + image);

        imageView.setImageResource(image);

        return view;
    }
}