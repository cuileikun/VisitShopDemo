package com.visitshopdemo.fragment;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.visitshopdemo.R;

/**
 * 作者：popular cui
 * 时间：2017/7/7 14:02
 * 功能:拜访fragment
 */
public class VisitFragment extends VisitShopBaseFragment{
    private Context context;
    private TextView tv1;
    @Override
    public void initViews(View view) {
        context = getActivity();
        tv1 = (TextView) view.findViewById(R.id.tv1);
    }

    @Override
    public void initData() {

    }

    @Override
    public void addListeners() {

    }
    public void loadData() {
        tv1.setText("拜访更新出来的东西");
    }
    @Override
    public int getLayoutId() {
        return R.layout.fragment_visit;
    }
}
