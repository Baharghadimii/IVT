package com.example.bahar.ivt.Activities.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bahar.ivt.Activities.Sources.DictionaryEntry;
import com.example.bahar.ivt.Activities.WordsActivity;
import com.example.bahar.ivt.R;

import java.util.ArrayList;

/**
 * Created by Bahar on 6/16/2018.
 */
public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.ViewHolder> {

    private static ArrayList<DictionaryEntry> dictionaryEntryList;


    public WordsAdapter(ArrayList<DictionaryEntry> dictionaryEntryList) {
        this.dictionaryEntryList = dictionaryEntryList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView word, pronunciation;
        public View layout;
        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            this.layout = v;
            word = (TextView) v.findViewById(R.id.word);
            pronunciation = (TextView) v.findViewById(R.id.pronunciation);
        }
        @Override
        public void onClick(View view) {
            Context context = view.getContext();
            Intent intent = new Intent(context, WordsActivity.class);
            intent.putExtra("word", dictionaryEntryList.get(getAdapterPosition()).getWord());
            context.startActivity(intent);
        }
    }
    @Override
    public WordsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.word_list, parent, false);

        return new ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DictionaryEntry word = dictionaryEntryList.get(position);
        holder.word.setText(word.getWord());
        holder.pronunciation.setText(word.getPronunciation());
    }
    @Override
    public int getItemCount() {
        return dictionaryEntryList.size();
    }
}
