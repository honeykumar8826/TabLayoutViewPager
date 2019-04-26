package com.tab.tabLayoutViewPager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.tab.tabLayoutViewPager.fragment.DoCallFragment;
import com.tab.tabLayoutViewPager.fragment.HomeFragment;
import com.tab.tabLayoutViewPager.fragment.OpenChatFragment;
import com.tab.tabLayoutViewPager.fragment.OpenLogFragment;

public class PageAdapter extends FragmentPagerAdapter {
    private int tabNum;
    public static String TAG ="Adapter";
    public PageAdapter(FragmentManager fm,int tabNum) {
        super(fm);
        this.tabNum = tabNum;
    }
    @Override
    public Fragment getItem(int position) {
        Log.i(TAG, "getItem: ");
        switch (position)
        {
            case 0: return new HomeFragment();
            case 1: return new OpenChatFragment();
            case 2: return new DoCallFragment();
            case 3: return new OpenLogFragment();
//          case 4: return new CallFragment();
            default:return  null;
        }
    }
    @Override
    public int getCount() {
        Log.i(TAG, "getCount: ");
        return tabNum;
    }
}
