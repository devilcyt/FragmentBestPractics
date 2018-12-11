package com.example.gome.myfragmentbestpractics;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NewsFragment extends Fragment{

    private View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mView = inflater.inflate(R.layout.news_content_frag, container, false);
        return mView;
    }

    public void refresh(String title, String content){
        View visibilityLayout = mView.findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);
        TextView newsTitle =  mView.findViewById(R.id.news_title);
        TextView newsContent =  mView.findViewById(R.id.new_content);
        newsTitle.setText(title);
        newsContent.setText(content);
    }
}
