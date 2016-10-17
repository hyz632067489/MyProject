package com.hyz.myproject.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.hyz.myproject.R;
import com.hyz.myproject.adapter.GridViewAdapter;
import com.hyz.myproject.adapter.ViewPagerAdapter;
import com.hyz.myproject.bean.ModelMeiTuan;
import com.hyz.myproject.ui.activity.DrawingBoardActivity;
import com.hyz.myproject.ui.activity.LoginActivity;
import com.hyz.myproject.ui.base.BaseFragment;
import com.hyz.myproject.utils.MLog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by ${hyz} on 2016/7/28.
 */
public class FindFragment extends BaseFragment implements View.OnClickListener {

    private String TAG = FindFragment.class.getCanonicalName();

    Button btnN1, btnN2, btnN3, btnN4;

    private Intent mIntent;

    private String[] titles = {"美食", "电影", "酒店住宿", "休闲娱乐", "外卖", "自助餐", "KTV", "机票/火车票", "周边游", "美甲美睫",
            "火锅", "生日蛋糕", "甜品饮品", "水上乐园", "汽车服务", "美发", "丽人", "景点", "足疗按摩", "运动健身", "健身", "超市", "买菜",
            "今日新单", "小吃快餐", "面膜", "洗浴/汗蒸", "母婴亲子", "生活服务", "婚纱摄影", "学习培训", "家装", "结婚", "全部分配"};

    @BindView(R.id.viewpager)
    ViewPager mPager;
    private List<View> mPagerList;
    private List<ModelMeiTuan> mDatas;
    private LayoutInflater inflater;
    @BindView(R.id.ll_dot)
    LinearLayout mLlDot;
    /**
     * 总的页数
     */
    private int pageCount;

    /**
     * 每一页显示的个数
     */
    private int pageSize = 10;

    /**
     * 当前显示的是第几页
     */
    private int curIndex = 0;

    public FindFragment() {

    }

    public static FindFragment newInstance() {
        return new FindFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_find, null);
        btnN1 = findView(view, R.id.btn_1);
        btnN2 = findView(view, R.id.btn_2);
        btnN3 = findView(view, R.id.btn_3);
        btnN4 = findView(view, R.id.btn_4);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //初始化数据源
        initDatas();
        inflater = LayoutInflater.from(activity);
        //总的页数 = 总数/每页数量，并取整
        pageCount = (int) Math.ceil(mDatas.size() * 1.0 / pageSize);
        mPagerList = new ArrayList<View>();
        for (int i = 0; i < pageCount; i++) {
            //每个页面都是inflate出一个新实例
            GridView gridView = (GridView) inflater.inflate(R.layout.gridview, mPager, false);
            gridView.setAdapter(new GridViewAdapter(activity, mDatas, i, pageSize));

            mPagerList.add(gridView);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    toast(mDatas.get(position).getName());
                }
            });
        }
        mPager.setAdapter(new ViewPagerAdapter(mPagerList));

        //设置圆点
        setOvalLayout();

        btnN1.setOnClickListener(this);
        btnN2.setOnClickListener(this);
    }

    /**
     * 初始化数据源
     */
    private void initDatas() {
        mDatas = new ArrayList<ModelMeiTuan>();
        for (int i = 0; i < titles.length; i++) {
            //动态获取资源ID，第一个参数是资源名，第二个参数是资源类型例如drawable，string等，第三个参数包名
//            int imageId = getResources().getIdentifier("ic_category_" + i, "mipmap", getPackageName());
            mDatas.add(new ModelMeiTuan(titles[i]));
        }
    }

    /**
     * 设置圆点
     *
     * @param
     */
    public void setOvalLayout() {

        for (int i = 0; i < pageCount; i++) {
            mLlDot.addView(inflater.inflate(R.layout.dot, null));
        }
        //默认显示第一页
        mLlDot.getChildAt(0).findViewById(R.id.v_dot).setBackgroundResource(R.drawable.page_indicator_focused);

        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //取消圆点选中
                mLlDot.getChildAt(curIndex).findViewById(R.id.v_dot).setBackgroundResource(R.drawable.page_indicator_unfocused);
                //圆点选中
                mLlDot.getChildAt(position).findViewById(R.id.v_dot).setBackgroundResource(R.drawable.page_indicator_focused);

                curIndex = position;
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                MLog.i(TAG, "onClick1================");
                mIntent = new Intent(getContext(), LoginActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_2:
                MLog.i(TAG, "onClick2================");
                mIntent = new Intent(getContext(), DrawingBoardActivity.class);
                startActivity(mIntent);
                break;
        }

    }

}
