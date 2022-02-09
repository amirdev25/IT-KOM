package com.example.comapanies;

import android.app.UiModeManager;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(getResources().getColor(R.color.purple_700));
        getWindow().setNavigationBarColor(getResources().getColor(R.color.purple_700));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));

        List<Company> list = new ArrayList<>();
        list.add(new Company(R.drawable.google, getString(R.string.google)));
        list.add(new Company(R.drawable.netflix, getString(R.string.netflix)));
        list.add(new Company(R.drawable.meta, getString(R.string.meta)));
        list.add(new Company(R.drawable.apple, getString(R.string.apple)));
        list.add(new Company(R.drawable.alibaba, getString(R.string.alibaba)));
        list.add(new Company(R.drawable.microsoft, getString(R.string.microsoft)));
        list.add(new Company(R.drawable.samsung, getString(R.string.samsung)));
        list.add(new Company(R.drawable.tesla, getString(R.string.tesla)));
        list.add(new Company(R.drawable.xiaomi, getString(R.string.xiaomi)));
        list.add(new Company(R.drawable.disney, getString(R.string.disney)));

        AdapterRecyclerView adapterRecyclerView = new AdapterRecyclerView(list, company -> {
            Intent intent = new Intent(MainActivity.this, InformationActivity.class);
            intent.putExtra("key", company.name);
            startActivity(intent);
        });
        recyclerView.setAdapter(adapterRecyclerView);
    }
}