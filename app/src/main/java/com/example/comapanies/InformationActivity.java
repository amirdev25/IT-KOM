package com.example.comapanies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
import java.util.List;

public class InformationActivity extends AppCompatActivity {

    ImageView imageCompanyInformation, imageFounder, shareBtn;
    TextView nameCompanyInformation, companyDescription, founderName, founderDescription, aboutName;
    RecyclerView recommedList;
    ConstraintLayout backButton;

    List<CompanyInfo> listCompanyInfo = new ArrayList<>();
    List<Company> customList = new ArrayList<>();
    String companyName;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        getWindow().setStatusBarColor(getResources().getColor(R.color.purple_700));
        getWindow().setNavigationBarColor(getResources().getColor(R.color.purple_700));


        List<Company> list = new ArrayList<>();
        list.add(new Company(R.drawable.google, "Google"));
        list.add(new Company(R.drawable.netflix, "Netflix"));
        list.add(new Company(R.drawable.meta, "Meta"));
        list.add(new Company(R.drawable.apple, "Apple"));
        list.add(new Company(R.drawable.alibaba, "Alibaba"));
        list.add(new Company(R.drawable.microsoft, "Microsoft"));
        list.add(new Company(R.drawable.samsung, "Samsung"));
        list.add(new Company(R.drawable.tesla, "Tesla"));
        list.add(new Company(R.drawable.xiaomi, "Xiaomi"));
        list.add(new Company(R.drawable.disney, "Disney"));

        loadData();
        loadList();
        companyName = getIntent().getExtras().getString("key");
        setData(listCompanyInfo, companyName);

        for (int i = 0; i < 10; i++) {
            if (!list.get(i).getName().equals(companyName)) {
                customList.add(list.get(i));
            }
        }

        recommedList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        AdapterRecommed adapterRecommed = new AdapterRecommed(customList, company -> {
            Intent intent = new Intent(InformationActivity.this, InformationActivity.class);
            intent.putExtra("key", company.name);
            startActivity(intent);
            finish();
        });
        recommedList.setAdapter(adapterRecommed);

        shareBtn.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String body = companyName + " kompaniyasi\n" + companyDescription.getText().toString();
            intent.putExtra(Intent.EXTRA_TEXT, body);
            startActivity(Intent.createChooser(intent, "Ilova tanlang"));

        });

        backButton.setOnClickListener(v -> {
            finish();
        });


    }

    private void loadData() {
        backButton = findViewById(R.id.backButton);
        recommedList = findViewById(R.id.recommedList);
        imageCompanyInformation = findViewById(R.id.imageCompanyInformation);
        imageFounder = findViewById(R.id.imageFounder);
        nameCompanyInformation = findViewById(R.id.nameCompanyInformation);
        founderName = findViewById(R.id.founderName);
        founderDescription = findViewById(R.id.founderDescription);
        companyDescription = findViewById(R.id.companyDescription);
        aboutName = findViewById(R.id.aboutName);
        shareBtn = findViewById(R.id.shareBtn);
    }

    @SuppressLint("SetTextI18n")
    public void setData(List<CompanyInfo> listCompanyInfo, String companyName) {

        for (int i = 0; i < 10; i++) {
            if (listCompanyInfo.get(i).getCompanyName().equals(companyName)) {
                imageCompanyInformation.setImageResource(listCompanyInfo.get(i).getImage());
                companyDescription.setText(listCompanyInfo.get(i).getCompanyDescription());
                imageFounder.setImageResource(listCompanyInfo.get(i).getFounderImage());
                founderName.setText(listCompanyInfo.get(i).getFounderName());
                founderDescription.setText(listCompanyInfo.get(i).getFounderDescription());
                aboutName.setText(listCompanyInfo.get(i).getCompanyName() + " haqida");
            }
        }

    }

    public void loadList() {
        listCompanyInfo.add(new CompanyInfo(getString(R.string.google), getString(R.string.google_description), R.drawable.google1, R.drawable.founder_google, getString(R.string.google_founder), getString(R.string.google_founder_des)));
        listCompanyInfo.add(new CompanyInfo(getString(R.string.apple), getString(R.string.apple_description), R.drawable.apple1, R.drawable.founder_apple, getString(R.string.apple_founder), getString(R.string.apple_founder_des)));
        listCompanyInfo.add(new CompanyInfo(getString(R.string.alibaba), getString(R.string.alibaba_description), R.drawable.alibaba1, R.drawable.alibaba_founder, getString(R.string.alibaba_founder), getString(R.string.alibaba_founder_des)));
        listCompanyInfo.add(new CompanyInfo(getString(R.string.disney), getString(R.string.disney_description), R.drawable.disney1, R.drawable.disney_founder, getString(R.string.disney_founder), getString(R.string.disney_founder_des)));
        listCompanyInfo.add(new CompanyInfo(getString(R.string.meta), getString(R.string.meta_description), R.drawable.meta1, R.drawable.meta_founder, getString(R.string.meta_founder), getString(R.string.meta_founder_des)));
        listCompanyInfo.add(new CompanyInfo(getString(R.string.microsoft), getString(R.string.microsoft_description), R.drawable.microsoft1, R.drawable.microsoft_founder, getString(R.string.microsoft_founder), getString(R.string.microsoft_founder_des)));
        listCompanyInfo.add(new CompanyInfo(getString(R.string.netflix), getString(R.string.netflix_description), R.drawable.netflex1, R.drawable.netflix_founder, getString(R.string.netflix_founder1), getString(R.string.netflix_founder_des)));
        listCompanyInfo.add(new CompanyInfo(getString(R.string.samsung), getString(R.string.samsung_description), R.drawable.samsung1, R.drawable.samsung_founder, getString(R.string.samsung_founder), getString(R.string.samsung_founder_des)));
        listCompanyInfo.add(new CompanyInfo(getString(R.string.tesla), getString(R.string.tesla_description), R.drawable.tesla1, R.drawable.tesla_founder, getString(R.string.tesla_founder), getString(R.string.tesla_founder_des)));
        listCompanyInfo.add(new CompanyInfo(getString(R.string.xiaomi), getString(R.string.xiaomi_description), R.drawable.xiaomi1, R.drawable.xiaomi_founder, getString(R.string.xiaomi_founder), getString(R.string.xiaomi_founder_des)));
    }
}