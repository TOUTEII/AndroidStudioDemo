package com.tzw.textview.recycleview;

import android.content.Context;
import android.net.sip.SipSession;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tzw.textview.R;

import java.util.List;

public class HorAdapter extends RecyclerView.Adapter<HorAdapter.LinearViewHolder> {
    private Context mContext;
    private OnitemClickListener mListener;

    private List<String> list;

    public HorAdapter(Context context,OnitemClickListener listener){
        this.mContext=context;
        this.mListener=listener;
    }

    @NonNull
    @Override
    public HorAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_hor_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HorAdapter.LinearViewHolder holder, final int position) {
            holder.textView.setText("Hello");
            holder.textView.setOnClickListener(new View.OnClickListener() {
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
        private TextView textView;

        public LinearViewHolder(View itemView){
            super(itemView);
            textView=itemView.findViewById(R.id.tv_title);
        }
    }

    public interface OnitemClickListener{
        void onClick(int pos);
    }


}
