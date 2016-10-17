package com.hyz.myproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hyz.myproject.R;
import com.hyz.myproject.bean.ModelMeiTuan;

import java.util.List;

/**
 * Created by hyz on 2016/10/17.
 * powered by company
 */

public class GridViewAdapter extends BaseAdapter{

    private List<ModelMeiTuan>mDatas;
    private LayoutInflater inflater;

    //页数下标，从0开始（当前是第几页）
    private int curIndex;

    //每一页显示的个数
    private  int pageSize;

    public GridViewAdapter(Context context,List<ModelMeiTuan> mDatas, int curIndex, int pageSize) {
        this.mDatas = mDatas;
        inflater = LayoutInflater.from(context);
        this.curIndex = curIndex;
        this.pageSize = pageSize;
    }

    /**
     * 先判断数据集的大小是否够显示满本页，如果够，则直接返回每一页显示的最大条目
     * 个数pageSize,如果不够，则有几项就返回几,(也就是最后一页的时候就显示剩余item)
     */
    @Override
    public int getCount() {
        return mDatas.size() > (curIndex + 1)*pageSize ? pageSize : (mDatas.size() - curIndex*pageSize);
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position + curIndex*pageSize);
    }

    @Override
    public long getItemId(int position) {
        return position + curIndex*pageSize;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if(convertView ==null){
            convertView = inflater.inflate(R.layout.item_gridview,parent,false);
           holder = new ViewHolder();
            holder.tv = (TextView) convertView.findViewById(R.id.textView);
            holder.iv = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        /**
         * 在给View绑定显示的数据时，计算正确的position = position + curIndex * pageSize
         */
        int pos = position + curIndex * pageSize;
        holder.tv.setText(mDatas.get(pos).getName());
        holder.iv.setImageResource(mDatas.get(pos).getIconRes());
        return convertView;
    }
    class ViewHolder{
        public TextView tv;
        public ImageView iv;
    }
}

