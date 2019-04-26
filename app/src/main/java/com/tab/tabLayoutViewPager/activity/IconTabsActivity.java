package com.tab.tabLayoutViewPager.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.tab.tabLayoutViewPager.R;
import com.tab.tabLayoutViewPager.adapter.PageAdapter;

public class IconTabsActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    public static String TAG ="TAG";
    private ViewPager viewPager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon_tabs);
        /*initialization of id*/
        inItId();
        /* adding the tabLayout*/
        addTabDynamically();
        setupTabIcons();
        /* adding the toolBar*/
        addToolbar();
        /*adding the listener for the tabLayout*/
        listenerOnTab();
        /*adding the listener for the viewpager*/
        listenerOnViewPager();
        /*adding the adapter on viewpager*/
        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);
    }

    private void addToolbar() {
        toolbar.setNavigationIcon(getDrawable(R.drawable.ic_arrow_back_black_24dp));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(IconTabsActivity.this, "back button enable", Toast.LENGTH_SHORT).show();
            }
        });
        setSupportActionBar(toolbar);
    }

    private void listenerOnViewPager() {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if(tabLayout.getTabAt(i)!=null){
                tabLayout.getTabAt(i).select();
                }
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
                Toast.makeText(IconTabsActivity.this, "move", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void addTabDynamically() {
        tabLayout.addTab(tabLayout.newTab().setText("HOME"));
        tabLayout.addTab(tabLayout.newTab().setText("OPEN CHAT"));
        tabLayout.addTab(tabLayout.newTab().setText("DO CALL"));
        tabLayout.addTab(tabLayout.newTab().setText("OPEN LOG"));
    }

    private void inItId() {
        toolbar = findViewById(R.id.toolbar);
        viewPager = findViewById(R.id.viewpager_chat);
        tabLayout = findViewById(R.id.tabLayoutChat);
    }

    private void setupTabIcons() {
         int tabIcons[] = {
                R.drawable.ic_home_black_24dp,
                R.drawable.ic_chat_black_24dp,
                R.drawable.ic_call_black_24dp,
                R.drawable.ic_history_black_24dp
        };
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
    }
}
