package com.tzw.textview.gridview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.tzw.textview.R;

public class GridViewActivity extends AppCompatActivity {
    private GridView mGv;

    @Override
    protected void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        mGv=findViewById(R.id.gv);
        mGv.setAdapter(new MyGridViewAdapt(GridViewActivity.this));
        mGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this,"click pos:"+position,Toast.LENGTH_SHORT).show();
            }
        });

        mGv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this,"click long:"+position,Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }
}
