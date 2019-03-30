package com.example.greenday;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CollectionAdapter extends
        RecyclerView.Adapter<CollectionAdapter.CollectionViewHolder> {

    public static class CollectionViewHolder extends RecyclerView.ViewHolder{
        public CollectionViewHolder(View view){
            super(view);
        }
    }

    public CollectionAdapter(){

    }

    @Override
    public CollectionAdapter.CollectionViewHolder onCreateViewHolder
            (ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_layout, parent, false);
        //view.setOnClickListener(mOnClickListener);

        CollectionViewHolder vh = new CollectionViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(CollectionViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
    }
}
