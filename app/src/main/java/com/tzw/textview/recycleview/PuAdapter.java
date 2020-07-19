package com.tzw.textview.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tzw.textview.R;

import java.util.List;

public class PuAdapter extends RecyclerView.Adapter<PuAdapter.LinearViewHolder> {
    private Context mContext;
    private OnitemClickListener mListener;

    private List<String> list;

    public PuAdapter(Context context, OnitemClickListener listener){
        this.mContext=context;
        this.mListener=listener;
    }

    @NonNull
    @Override
    public PuAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_pu_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PuAdapter.LinearViewHolder holder, final int position) {
        if(position % 2 !=0) {
            holder.imageView.setImageResource(R.drawable.picture1);
        }else{
            holder.imageView.setImageResource(R.drawable.picture2);
        }
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onClick(position);
                }
            });

            //holder.itemView.setOnLongClickListener();
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;

        public LinearViewHolder(View itemView){
            super(itemView);
            imageView=itemView.findViewById(R.id.iv);
        }
    }

    public interface OnitemClickListener{
        void onClick(int pos);
    }


}
