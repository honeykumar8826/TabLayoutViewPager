package com.tab.tabLayoutViewPager.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.tab.tabLayoutViewPager.R;
import com.tab.tabLayoutViewPager.fragment.DoCallFragment;
import com.tab.tabLayoutViewPager.fragment.HomeFragment;
import com.tab.tabLayoutViewPager.fragment.OpenChatFragment;

import java.util.ArrayList;
import java.util.List;

public class CustomTabActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    public static String TAG = "TAG";
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_tab);
        /*  initialization of id */
        inItId();
        /* add fragment and tab by viewpager*/
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    private void inItId() {
        viewPager = findViewById(R.id.viewpager_chat);
        tabLayout = findViewById(R.id.tabLayoutChat);
    }

    private void setupTabIcons() {
        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab_layout, null);
        tabOne.setText(""+"ONE");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_home_black_24dp, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);



        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab_layout, null);
        tabTwo.setText("TWO");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_chat_black_24dp, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab_layout, null);
        tabThree.setText("THREE");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_call_black_24dp, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new HomeFragment(), "ONE");
        adapter.addFrag(new OpenChatFragment(), "TWO");
        adapter.addFrag(new DoCallFragment(), "THREE");
        viewPager.setAdapter(adapter);
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}

