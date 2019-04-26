package com.tab.tabLayoutViewPager.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tab.tabLayoutViewPager.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class OpenChatFragment extends Fragment {


    public OpenChatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_open_chat, container, false);
    }

}
