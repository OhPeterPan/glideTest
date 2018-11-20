package com.dalimao.glidetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String url = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg";
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        Button button = findViewById(R.id.button);
        iv = findViewById(R.id.iv);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Glide.with(this).load(url).into(iv);
        Intent intent = new Intent(this, BitmapActivity.class);
        startActivity(intent);
    }
}
