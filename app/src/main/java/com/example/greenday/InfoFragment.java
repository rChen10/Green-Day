package com.example.greenday;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class InfoFragment extends Fragment {
    private RecyclerView infoView;
    private RecyclerView.Adapter infoAdapter;
    private RecyclerView.LayoutManager infoLayoutManager;
    private InfoFragment.OnItemSelected listener;
    private Info info;

    public void setObject(Info newInfo) {
        info = newInfo;
    }

    public InfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_info, container, false);



        // assign instance variables
        infoView = (RecyclerView) view.findViewById(R.id.container_view);
        infoView.setHasFixedSize(true);

        infoLayoutManager = new LinearLayoutManager(this.getActivity());
        ((LinearLayoutManager) infoLayoutManager).setOrientation(LinearLayoutManager.VERTICAL);
        infoView.setLayoutManager(infoLayoutManager);

        infoAdapter = new InfoAdapter(info);
        infoView.addItemDecoration(new DividerItemDecoration(this.getActivity(), LinearLayoutManager.VERTICAL));
        infoView.setAdapter(infoAdapter);

        // Assign listeners
        infoView.addOnItemTouchListener(new RecyclerTouchListener(this.getActivity().getApplicationContext(), infoView,
                new RecyclerTouchListener.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                    }

                    @Override
                    public void onLongClick(View view, int position) {
                    }
                }));

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*
        if (context instanceof OnItemSelected) {
            listener = (OnItemSelected) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnItemSelected");
        } */
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface OnItemSelected{
        public void onCardSelected(int infoPosition, int cardPosition);
        public void onUpSelected();
    }

}