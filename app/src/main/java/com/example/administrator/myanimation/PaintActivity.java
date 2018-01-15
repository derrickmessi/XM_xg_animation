package com.example.administrator.myanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.administrator.myanimation.view.PaintView;

public class PaintActivity extends AppCompatActivity {

    private FrameLayout rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);
        rootView = (FrameLayout) findViewById(R.id.root_view);
        rootView.addView(new PaintView(this));
    }
}
