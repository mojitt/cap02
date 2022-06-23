package com.example.cap02;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

public class GuideHome extends TabActivity {

    Button Btnplastic, Btncan, Btnpaper,Btnmirror, Btnmetal, Btnstyro, Btnvinyl;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_home);

        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabSpecCalendar = tabHost.newTabSpec("product").setIndicator("분리수거 하기");
        tabSpecCalendar.setContent(R.id.content1);
        tabHost.addTab(tabSpecCalendar);

        TabHost.TabSpec tabSpecArlam = tabHost.newTabSpec("qna").setIndicator("질문게시판");
        tabSpecArlam.setContent(R.id.content2);
        tabHost.addTab(tabSpecArlam);

        tabHost.setCurrentTab(0);

        Btnplastic = (Button) findViewById(R.id.plasticbtn);
        Btncan = (Button) findViewById(R.id.canbtn);
        Btnpaper = (Button) findViewById(R.id.paperbtn);
        Btnmirror = (Button) findViewById(R.id.mirrorbtn);
        Btnmetal = (Button) findViewById(R.id.metalbtn);
        Btnstyro = (Button) findViewById(R.id.styrobtn);
        Btnvinyl = (Button) findViewById(R.id.vinylbtn);

        Btnplastic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PlasticGuide.class);
                startActivity(intent);
            }
        });

        Btncan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CanGuide.class);
                startActivity(intent);
            }
        });

        Btnpaper.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PaperGuide.class);
                startActivity(intent);
            }
        });

        Btnmirror.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GlassGuide.class);
                startActivity(intent);
            }
        });

        Btnmetal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MetalGuide.class);
                startActivity(intent);
            }
        });

        Btnstyro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StyroGuide.class);
                startActivity(intent);
            }
        });

        Btnvinyl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VinylGuide.class);
                startActivity(intent);
            }
        });
    }

}
