package com.tzw.textview.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tzw.textview.R;

public class MyGridViewAdapt extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public MyGridViewAdapt(Context context){
        this.mContext=context;
        mLayoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    static class ViewHolder{
        public ImageView imageView;
        public TextView textView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            convertView=mLayoutInflater.inflate(R.layout.layout_grid_item,null);
            holder=new ViewHolder();
            holder.imageView=convertView.findViewById(R.id.iv_grid);
            holder.textView=convertView.findViewById(R.id.tv_title);
            convertView.setTag(holder);
        }else{
            holder=(ViewHolder) convertView.getTag();
        }
        //give parmarter
        holder.textView.setText("flower");
        Glide.with(mContext).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1590911577344&di=5848a43b1f2d3c43b410e3d8fea1e1a1&imgtype=0&src=http%3A%2F%2Fimg.pconline.com.cn%2Fimages%2Fphotoblog%2F8%2F1%2F9%2F6%2F8196944%2F20093%2F25%2F1237995645904_mthumb.jpg").into(holder.imageView);
        return convertView;
    }
}
