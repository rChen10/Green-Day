package com.example.greenday;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class InfoAdapter extends
        RecyclerView.Adapter<InfoAdapter.InfoViewHolder> {
    private Info info;

    public static class InfoViewHolder extends RecyclerView.ViewHolder{
        public TextView varName;
        public TextView varVal;
        public InfoViewHolder(View view){
            super(view);
            varName = (TextView) view.findViewById((R.id.variable_text));
            varVal = (TextView) view.findViewById(R.id.variable_value);
        }
    }


    public InfoAdapter(Info newInfo){
        info = newInfo;
    }


    @Override
    public InfoAdapter.InfoViewHolder onCreateViewHolder
            (ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.info_view, parent, false);
        //view.setOnClickListener(mOnClickListener);

        InfoViewHolder vh = new InfoViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(InfoViewHolder holder, int position) {
        String varInfo[] = info.getVar(position);

        holder.varName.setText(varInfo[0]);
        holder.varVal.setText(varInfo[1]);
    }

    @Override
    public int getItemCount() {
        return 6;
    }

}
