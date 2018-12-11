package com.example.gome.myfragmentbestpractics;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NewsTitleFragment extends Fragment {

    private boolean isTwoPane;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.news_title_frag, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.news_title_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        NewsAdapter adapter = new NewsAdapter(getNews());
        recyclerView.setAdapter(adapter);
        return view;
    }

    private List<News> getNews(){
        List<News> newsList = new ArrayList<>();
        for(int i = 0; i <= 50; i++){
            News news = new News();
            news.setTitle("Today news is " + i);
            news.setContent("Liverpool salah goals " + i);
            newsList.add(news);
        }
        return newsList;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getActivity().findViewById(R.id.news_content_layout) != null){
            isTwoPane = true;
        }else{
            isTwoPane = false;
        }
    }



    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

        private List<News> mNewsList;

        class ViewHolder extends RecyclerView.ViewHolder{
            TextView newsTitleView;

            public ViewHolder(View view){
                super(view);
                newsTitleView = (TextView)view.findViewById(R.id.news_title_textview);
            }
        }
        public NewsAdapter(List<News> newsList){
            mNewsList = newsList;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            News news = mNewsList.get(position);
            holder.newsTitleView.setText(news.getTitle());
        }

        @NonNull
        @Override
        public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_item, viewGroup, false);
            final ViewHolder holder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    News news = mNewsList.get(holder.getAdapterPosition());
                    if(isTwoPane){
                        NewsFragment newsFragment = (NewsFragment) getFragmentManager().findFragmentById(R.id.news_content_fragment);
                        newsFragment.refresh(news.getTitle(),news.getContent());
                        news.getContent();
                    }else{
                        NewsContentActivity.startAction(getActivity(),news.getTitle(), news.getContent());
                    }
                }
            });
            return holder;
        }

        @Override
        public int getItemCount() {
            return mNewsList.size();
        }
    }
}
