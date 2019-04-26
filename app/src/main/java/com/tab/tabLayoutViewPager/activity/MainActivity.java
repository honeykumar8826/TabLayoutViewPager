package com.tab.tabLayoutViewPager.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.tab.tabLayoutViewPager.R;
import com.tab.tabLayoutViewPager.adapter.PageAdapter;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    public static String TAG ="TAG";
    private ViewPager viewPager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*  initialization of id */
        inItId();
        /* adding the tabLayout*/
        addTabDynamically();
        /* adding the toolBar*/
        addToolbar();
        /*adding the listener for the tabLayout*/
        listenerOnTab();
        /*adding the listener for the viewpager*/
        listenerOnViewPager();
        /*adding the adapter on viewpager*/
        //asking the question
        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);
    }

    private void listenerOnViewPager() {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

                tabLayout.getTabAt(i).select();
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void listenerOnTab() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                Toast.makeText(MainActivity.this, "move", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void addToolbar() {
        toolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DeciderActivity.class);
                startActivity(intent);
                finish();
              //  Toast.makeText(MainActivity.this, "back button enable", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void addTabDynamically() {
        tabLayout.addTab(tabLayout.newTab().setText("HOME"));
        tabLayout.addTab(tabLayout.newTab().setText("OPEN CHAT"));
        tabLayout.addTab(tabLayout.newTab().setText("DO CALL"));
        tabLayout.addTab(tabLayout.newTab().setText("OPEN LOG"));
        tabLayout.addTab(tabLayout.newTab().setText("OPEN LOG"));
        tabLayout.addTab(tabLayout.newTab().setText("Chat"));
    }

    private void inItId() {
        toolbar = findViewById(R.id.toolbar);
        viewPager = findViewById(R.id.viewpager_chat);
        tabLayout = findViewById(R.id.tabLayoutChat);
    }

    /* adding the option menu */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.custom_menu,menu);
        return super.onCreateOptionsMenu(menu);

    }
    /*adding the listener on item selection*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.uLogout:
                Toast.makeText(this, "logout", Toast.LENGTH_SHORT).show();
                break;
            case R.id.uRefresh:
                Toast.makeText(this, "Refresh", Toast.LENGTH_SHORT).show();
                break;

            default:
                Toast.makeText(this, "default", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
