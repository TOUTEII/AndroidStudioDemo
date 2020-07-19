package com.tzw.textview.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tzw.textview.R;

public class AFragment extends Fragment {

    private TextView mTextView;
    private Button mBtnChange, mBtnChangeText, mBtnMessage;
    private Activity mActivity;
    private BFragment bFragment;
    private IOnMessageClick listener;

    public static AFragment newInstance(String title) {
        AFragment aFragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        aFragment.setArguments(bundle);
        return aFragment;
    }

    public interface  IOnMessageClick{
        void onClick(String text);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activity, container, false);
        Log.d("AFragment", "----OnCreateView----");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //
        mTextView = view.findViewById(R.id.tv_title);
        mBtnChange = view.findViewById(R.id.btn_change);
        mBtnChangeText = view.findViewById(R.id.btn_reset);
        mBtnMessage = view.findViewById(R.id.btn_message);
        mBtnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ((ContainerActivity) getActivity()).setData("Hello");
                listener.onClick("No Good");
            }
        });

        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bFragment == null) {
                    bFragment = new BFragment();
                }
                Fragment fragment = getFragmentManager().findFragmentByTag("a");
                if (fragment != null) {
                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.fl_container, bFragment).addToBackStack(null).commitAllowingStateLoss();
                } else {
                    getFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).addToBackStack(null).commitAllowingStateLoss();
                }
            }
        });

        mBtnChangeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText("l am new words");
            }
        });
        if (getActivity() != null) {
            mTextView.setText(getArguments().getString("title"));
        } else {

        }

    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            listener=(IOnMessageClick) context;
        }catch(ClassCastException e){
            throw new ClassCastException("Activity must do the Interface");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //取消异步
    }
}
