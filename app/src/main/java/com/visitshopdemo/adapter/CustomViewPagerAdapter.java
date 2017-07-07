package com.visitshopdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 作者：popular cui
 * 时间：2017/7/7 14:09
 * 功能:viewpager适配器
 */
public class CustomViewPagerAdapter <T extends Fragment> extends FragmentPagerAdapter {
    private List<T> mFragments;
    public CustomViewPagerAdapter(FragmentManager fm, List<T> mFragments) {
        super(fm);
        this.mFragments = mFragments;
    }

    @Override
    public T getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
