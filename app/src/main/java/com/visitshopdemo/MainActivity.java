package com.visitshopdemo;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.visitshopdemo.activity.HouseResourceBaseFragmentActivity;
import com.visitshopdemo.adapter.CustomViewPagerAdapter;
import com.visitshopdemo.fragment.HomePageFragment;
import com.visitshopdemo.fragment.PersonCenterFragment;
import com.visitshopdemo.fragment.TrainingFragment;
import com.visitshopdemo.fragment.VisitFragment;
import com.visitshopdemo.fragment.VisitShopFragment;
import com.visitshopdemo.widget.MyTopbarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends HouseResourceBaseFragmentActivity implements View.OnClickListener {
    public static MainActivity mInstance = null;
    private Context mContext;
    private MyTopbarView topbarView;//actionbar
    private TextView tv_home_page;//首页
    private TextView tv_visit_shop;//巡店
    private TextView tv_visit;//拜访
    private TextView tv_training;//培训
    private TextView tv_person_center;//个人中心
    private ViewPager mViewPager;
    private List<Fragment> mFragments = new ArrayList<>();//三个页面集合
    private HomePageFragment mHomePageFragment;
    private VisitShopFragment mVisitShopFragment;
    private VisitFragment mVisitFragment;
    private TrainingFragment mTrainingFragment;
    private PersonCenterFragment mPersonCenterFragment;

    @Override
    public void initViews() {
        mInstance = MainActivity.this;
        mContext = this;
        topbarView = (MyTopbarView) findViewById(R.id.top_bar_view);
        mViewPager = (ViewPager) findViewById(R.id.visit_shop_viewpager);
        tv_home_page = (TextView) findViewById(R.id.tv_home_page);
        tv_visit_shop = (TextView) findViewById(R.id.tv_visit_shop);
        tv_visit = (TextView) findViewById(R.id.tv_visit);
        tv_training = (TextView) findViewById(R.id.tv_training);
        tv_person_center = (TextView) findViewById(R.id.tv_person_center);

        mHomePageFragment = new HomePageFragment();
        mVisitShopFragment = new VisitShopFragment();
        mVisitFragment = new VisitFragment();
        mTrainingFragment = new TrainingFragment();
        mPersonCenterFragment = new PersonCenterFragment();

        mFragments.add(mHomePageFragment);
        mFragments.add(mVisitShopFragment);
        mFragments.add(mVisitFragment);
        mFragments.add(mTrainingFragment);
        mFragments.add(mPersonCenterFragment);
        mViewPager.setAdapter(new CustomViewPagerAdapter(getSupportFragmentManager(), mFragments));
//        mViewPager.startScrollRightNow();
        mViewPager.setOffscreenPageLimit(0);
        mViewPager.setCurrentItem(0);

    }

    @Override
    public void initData() {
    }

    @Override
    public void addListeners() {
        tv_home_page.setOnClickListener(MainActivity.this);
        tv_visit_shop.setOnClickListener(MainActivity.this);
        tv_visit.setOnClickListener(MainActivity.this);
        tv_training.setOnClickListener(MainActivity.this);
        tv_person_center.setOnClickListener(MainActivity.this);
        mViewPager.addOnPageChangeListener(new viewPagerPageChangeListener());

    }

    class viewPagerPageChangeListener extends ViewPager.SimpleOnPageChangeListener {
        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
//                    ((HomePageFragment) mFragments.get(0)).setUrl(url1);
                    ((HomePageFragment) mFragments.get(0)).loadData();
                    break;
                case 1:
//                    ((VisitShopFragment) mFragments.get(1)).setUrl(url2);
                    ((VisitShopFragment) mFragments.get(1)).loadData();
                    break;
                case 2:
//                    ((VisitFragment) mFragments.get(2)).setUrl(url2);
                    ((VisitFragment) mFragments.get(2)).loadData();
                    break;
                case 3:
//                    ((TrainingFragment) mFragments.get(3)).setUrl(url2);
                    ((TrainingFragment) mFragments.get(3)).loadData();
                    break;
                case 4:
//                    ((PersonCenterFragment) mFragments.get(4)).setUrl(url2);
                    ((PersonCenterFragment) mFragments.get(4)).loadData();
                    break;
            }
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_home_page:
                mViewPager.setCurrentItem(0);
                tv_home_page.setTextColor(Color.parseColor("#ff0000"));
                tv_visit_shop.setTextColor(Color.parseColor("#666666"));
                tv_visit.setTextColor(Color.parseColor("#666666"));
                tv_training.setTextColor(Color.parseColor("#666666"));
                tv_person_center.setTextColor(Color.parseColor("#666666"));
                break;
            case R.id.tv_visit_shop:
                mViewPager.setCurrentItem(1);
                tv_home_page.setTextColor(Color.parseColor("#666666"));
                tv_visit_shop.setTextColor(Color.parseColor("#ff0000"));
                tv_visit.setTextColor(Color.parseColor("#666666"));
                tv_training.setTextColor(Color.parseColor("#666666"));
                tv_person_center.setTextColor(Color.parseColor("#666666"));
                break;
            case R.id.tv_visit:
                mViewPager.setCurrentItem(2);
                tv_home_page.setTextColor(Color.parseColor("#666666"));
                tv_visit_shop.setTextColor(Color.parseColor("#666666"));
                tv_visit.setTextColor(Color.parseColor("#ff0000"));
                tv_training.setTextColor(Color.parseColor("#666666"));
                tv_person_center.setTextColor(Color.parseColor("#666666"));
                break;
            case R.id.tv_training:
                mViewPager.setCurrentItem(3);
                tv_home_page.setTextColor(Color.parseColor("#666666"));
                tv_visit_shop.setTextColor(Color.parseColor("#666666"));
                tv_visit.setTextColor(Color.parseColor("#666666"));
                tv_training.setTextColor(Color.parseColor("#ff0000"));
                tv_person_center.setTextColor(Color.parseColor("#666666"));
                break;
            case R.id.tv_person_center:
                mViewPager.setCurrentItem(4);
                tv_home_page.setTextColor(Color.parseColor("#666666"));
                tv_visit_shop.setTextColor(Color.parseColor("#666666"));
                tv_visit.setTextColor(Color.parseColor("#666666"));
                tv_training.setTextColor(Color.parseColor("#666666"));
                tv_person_center.setTextColor(Color.parseColor("#ff0000"));
                break;


        }
    }
}
