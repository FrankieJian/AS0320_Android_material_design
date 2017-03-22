package com.example.g572_528r.as0320_android_material_design;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by g572-528r on 2017/3/22.
 */

public class MaterialActivity extends AppCompatActivity {
    public static final String MATERIAL_NAME = "material_name";
    public static final String MATERIAL_IMAGE_ID = "material_image_id";
    private Toolbar toolbar;
    private ImageView materialImageView;
    private TextView materialContentText;
    private CollapsingToolbarLayout collapsingToolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);
        initViews();
    }

    private void initViews() {
        Intent intent = getIntent();
        String materialName = intent.getStringExtra(MATERIAL_NAME);
        int materialImageId = intent.getIntExtra(MATERIAL_IMAGE_ID, 0);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        materialImageView = (ImageView) findViewById(R.id.material_image_view);
        materialContentText = (TextView) findViewById(R.id.material_content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(materialName);
        Glide.with(this).load(materialImageId).into(materialImageView);
        String materialContent = generateMaterialContent(materialName);
        materialContentText.setText(materialContent);
    }

    private String generateMaterialContent(String materialName) {
        StringBuffer materialContent = new StringBuffer();
        for (int i = 0; i < 500; i++) {
            materialContent.append(materialName);
        }
        return materialContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
