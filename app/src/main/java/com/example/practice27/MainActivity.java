package com.example.practice27;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnSelect, btnResult, btnOther;
    FragmentManager manager;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSelect = (Button)findViewById(R.id.main_button01);
        btnResult = (Button)findViewById(R.id.main_button02);
        btnOther = (Button)findViewById(R.id.main_button03);

        btnSelect.setOnClickListener(new TapClickListener());
        btnResult.setOnClickListener(new TapClickListener());
        btnOther.setOnClickListener(new TapClickListener());

    }

    public class TapClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            manager = getSupportFragmentManager();
            transaction = manager.beginTransaction();

            switch (v.getId()) {
                case R.id.main_button01:
                    SelectFragment frag1 = SelectFragment.newInstance();
                    transaction.replace(R.id.frag_container, frag1);
                    break;
                case R.id.main_button02:
                    ResultFragment frag2 = ResultFragment.newInstance(SelectFragment.message);
                    transaction.replace(R.id.frag_container, frag2);
                    break;
                case R.id.main_button03:
                    OtherFragment fag3 = OtherFragment.newInstance();
                    transaction.replace(R.id.frag_container, fag3);
                    break;
            }

            transaction.commit();
        }
    }
}