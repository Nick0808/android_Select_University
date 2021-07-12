package com.example.practice27;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ResultFragment extends  Fragment{
    TextView txtMessage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        txtMessage = (TextView)view.findViewById(R.id.frag2_textView);
        String message = getArguments().getString("key_msg");
        txtMessage.setText(message);
        return view;
    }

    public static ResultFragment newInstance(String msg) {
        Bundle args = new Bundle();
        args.putString("key_msg", msg);
        ResultFragment fragment = new ResultFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
