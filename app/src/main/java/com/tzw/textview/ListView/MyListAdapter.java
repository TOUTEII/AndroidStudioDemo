package com.tzw.textview.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tzw.textview.R;

public class MyListAdapter extends BaseAdapter {

    private Context mContext;

    private LayoutInflater mLayoutInflater;


    public MyListAdapter(Context context){
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
        public TextView tvTitle,tvTime,tvContent;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            convertView=mLayoutInflater.inflate(R.layout.layout_list_item,null);
            holder=new ViewHolder();
            holder.imageView=convertView.findViewById(R.id.iv_1);
            holder.tvTitle=convertView.findViewById(R.id.tv_title);
            holder.tvTime=convertView.findViewById(R.id.tv_time);
            holder.tvContent=convertView.findViewById(R.id.tv_content);
            convertView.setTag(holder);

        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        //get value
        holder.tvTitle.setText("this is a title");
        holder.tvTime.setText("2088-08-08");
        holder.tvContent.setText("this is a body");
        Glide.with(mContext).load("https://pics2.baidu.com/feed/8644ebf81a4c510f1e96348d883d9e2bd52aa547.png?token=bf1a02a06dfff2bf0cb5538134c4e591").into(holder.imageView);
        return convertView;
    }
}
