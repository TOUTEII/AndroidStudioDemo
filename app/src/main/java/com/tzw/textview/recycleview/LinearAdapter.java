package com.tzw.textview.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tzw.textview.R;

import java.util.List;

public class LinearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;

    private List<String> list;

    public  LinearAdapter(Context context){
        this.mContext=context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==0){
            return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item,parent,false));
        }else{
            return new LinearViewHolder2(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item2,parent,false));
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
            if(getItemViewType(position)==0) {
                ((LinearViewHolder) holder).textView.setText("Hello World");
                ((LinearViewHolder) holder).textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "click..." + position, Toast.LENGTH_SHORT).show();
                    }
                });
            }else{
                ((LinearViewHolder2) holder).textView.setText("TZW");
                ((LinearViewHolder2) holder).textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "click..." + position, Toast.LENGTH_SHORT).show();
                    }
                });
            }


            //holder.itemView.setOnLongClickListener();
    }

    @Override
    public int getItemViewType(int position){
        if(position %2 ==0){
            return 0;
        }else{
            return 1;
        }

    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public LinearViewHolder(View itemView){
            super(itemView);
            textView=itemView.findViewById(R.id.tv_title);
        }
    }

    class LinearViewHolder2 extends RecyclerView.ViewHolder{
        private TextView textView;
        public ImageView imageView;

        public LinearViewHolder2(View itemView){
            super(itemView);
            textView=itemView.findViewById(R.id.tv_title);
            imageView=itemView.findViewById(R.id.iv_image);
        }
    }


}
