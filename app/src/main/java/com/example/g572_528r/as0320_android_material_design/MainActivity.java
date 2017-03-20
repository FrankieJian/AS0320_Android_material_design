package com.example.g572_528r.as0320_android_material_design;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button tvSnackbar;
    private EditText edtUsername;
    private EditText edtPassword;
    private FloatingActionButton faSearch;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        edtUsername = (EditText) findViewById(R.id.edt_username);
        edtPassword = (EditText) findViewById(R.id.edt_password);

        faSearch = (FloatingActionButton) findViewById(R.id.fab_search);
        faSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSnackbar.setTextColor(Color.BLUE);
            }
        });

        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_item_home:
                        Toast.makeText(MainActivity.this, "首页", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navigation_item_blog:
                        Toast.makeText(MainActivity.this, "我的博客", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navigation_item_about:
                        Toast.makeText(MainActivity.this, "关于", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                item.setChecked(true);
                return false;
            }
        });

        tvSnackbar = (Button) findViewById(R.id.tv_snackbar);
        tvSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(tvSnackbar, "SnackbarClicked", Snackbar.LENGTH_SHORT).setAction("Action", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "I'm a Toast", Toast.LENGTH_SHORT).show();
                    }
                }).setActionTextColor(Color.RED).show();
            }
        });
    }
}
