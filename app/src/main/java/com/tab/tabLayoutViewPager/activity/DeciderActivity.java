package com.tab.tabLayoutViewPager.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tab.tabLayoutViewPager.R;

public class DeciderActivity extends AppCompatActivity {
private Button btnIcon,btnText,btnIconOnly,btnCustom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decider);
        /*initialize the id*/
        inItId();
       /*listener for Icon with text type*/
        btnText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeciderActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
     btnIcon.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent(DeciderActivity.this,IconTabsActivity.class);
             startActivity(intent);
         }
     });
        btnIconOnly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeciderActivity.this,IconOnlyActivity.class);
                startActivity(intent);
            }
        });
        btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeciderActivity.this,CustomTabActivity.class);
                startActivity(intent);
            }
        });
    }

    private void inItId() {
        btnCustom = findViewById(R.id.custom_tab);
        btnIconOnly = findViewById(R.id.icon_only_tab);
        btnIcon= findViewById(R.id.icon_tab);
        btnText = findViewById(R.id.text_tab);
    }
}
