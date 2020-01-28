package com.example.bahar.ivt.Activities.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bahar.ivt.Activities.CustomItemClickListener;
import com.example.bahar.ivt.R;

import java.util.ArrayList;

/**
 * Created by Bahar on 12/9/2018.
 */
public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {

    private static ArrayList<String> testEntryList;
    private static CustomItemClickListener listener;


    public TestAdapter(ArrayList<String> testEntryList, CustomItemClickListener listener) {
        this.testEntryList = testEntryList;
        this.listener = listener;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView word;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            this.layout = v;
            word = (TextView) v.findViewById(R.id.test_word);


        }


        @Override
        public void onClick(View view) {

            listener.onItemClick(view , this.getAdapterPosition());
        }
    }


    @Override
    public TestAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.test_list, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.word.setText(testEntryList.get(position));
    }


    @Override
    public int getItemCount() {
        return testEntryList.size();
    }


}
