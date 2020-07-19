package com.tzw.textview.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tzw.textview.R;

public class PuRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRvPu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pu_recycler_view);
        mRvPu=findViewById(R.id.rv_pu);
        mRvPu.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        mRvPu.addItemDecoration(new MyDecoration());
        mRvPu.setAdapter(new PuAdapter(PuRecyclerViewActivity.this,new PuAdapter.OnitemClickListener(){
            @Override
            public void onClick(int pos){
                Toast.makeText(PuRecyclerViewActivity.this, "click"+pos, Toast.LENGTH_SHORT).show();
            }
        }));

    }

    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(Rect outRect,View view,RecyclerView parent,RecyclerView.State state){
            super.getItemOffsets(outRect,view,parent,state);
            int gap=getResources().getDimensionPixelOffset(R.dimen.dividerHeight5);
            outRect.set(gap,gap,gap,gap);
        }
    }
}
