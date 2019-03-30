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

public class CollectionFragment extends Fragment {
    private RecyclerView collectionView;
    private RecyclerView.Adapter collectionAdapter;
    private RecyclerView.LayoutManager collectionLayoutManager;
    private CollectionFragment.OnItemSelected listener;

    public void setObject() {
    }

    public CollectionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_collection, container, false);

        // assign instance variables
        collectionView = (RecyclerView) view.findViewById(R.id.collectionView);
        collectionView.setHasFixedSize(true);

        collectionLayoutManager = new LinearLayoutManager(this.getActivity());
        ((LinearLayoutManager) collectionLayoutManager).setOrientation(LinearLayoutManager.VERTICAL);
        collectionView.setLayoutManager(collectionLayoutManager);

        collectionAdapter = new CollectionAdapter(collection);
        collectionView.addItemDecoration(new DividerItemDecoration(this.getActivity(), LinearLayoutManager.VERTICAL));
        collectionView.setAdapter(collectionAdapter);

        // Assign listeners
        collectionView.addOnItemTouchListener(new RecyclerTouchListener(this.getActivity().getApplicationContext(), collectionView,
                new RecyclerTouchListener.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        listener.onCardSelected(managerPosition, position+1);
                    }

                    @Override
                    public void onLongClick(View view, int position) {
                    }
        }));

        Button addCardButton = (Button)view.findViewById(R.id.add_card);

        addCardButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                addCardSelected(view, inflater);
            }
        });

        Button sizeButton = (Button)view.findViewById(R.id.size_button);

        sizeButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                showSize(view, inflater);
            }
        });

        Button backButton = (Button)view.findViewById(R.id.back_button);

        backButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                listener.onUpSelected();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnItemSelected) {
            listener = (OnItemSelected) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnItemSelected");
        }
    }

    public void showSize(View view, LayoutInflater inflater){
        // inflate the layout of the popup window
        final View popupView = inflater.inflate(R.layout.basic_popup, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        TextView text = popupView.findViewById(R.id.main_text);
        text.setText("This collection has " + collection.size() + " cards.");

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface OnItemSelected{
        public void onCardSelected(int collectionPosition, int cardPosition);
        public void onUpSelected();
    }

}
