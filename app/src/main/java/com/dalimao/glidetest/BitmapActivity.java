package com.dalimao.glidetest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class BitmapActivity extends AppCompatActivity {

    private ImageView ivBitmap;
    private Bitmap copyBitmap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);
        initView();
    }

    private void initView() {
        ivBitmap = findViewById(R.id.ivBitmap);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_top_pic);
        copyBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(copyBitmap);

        canvas.drawColor(Color.GRAY);
        ivBitmap.setImageBitmap(copyBitmap);
        ivBitmap.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                for (int i = 0; i < 20; i++) {
                    for (int j = 0; j < 20; j++) {
                        copyBitmap.setPixel((int) (motionEvent.getX()+i), (int) (motionEvent.getY()+j), Color.RED);
                    }
                }
                ivBitmap.setImageBitmap(copyBitmap);
                return true;
            }
        });
    }
}
