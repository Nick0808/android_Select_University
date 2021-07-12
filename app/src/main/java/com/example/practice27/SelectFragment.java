package com.example.practice27;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SelectFragment extends  Fragment{
    ListView liUniv;
    String[] univList = {"Hankuk University", "Ilbon University", "Spain University"};
    String[] departList = {"Korean", "Japanese", "Spanish"};
    ArrayAdapter<String> univAdapter;
    String univ ="", depart = "";
    static String message = "";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select, container, false);

        univAdapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_list_item_single_choice,
                univList
        );

        liUniv = (ListView)view.findViewById(R.id.frag1_listView);
        liUniv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        liUniv.setAdapter(univAdapter);

        liUniv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                univ = univList[position];
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Select a University");
                builder.setSingleChoiceItems(departList, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        depart = departList[which];
                    }
                });
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        message = univ + " " + depart;
                    }
                });
                builder.show();
            }
        });

        return view;
    }

    public static SelectFragment newInstance() {

        Bundle args = new Bundle();

        SelectFragment fragment = new SelectFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
