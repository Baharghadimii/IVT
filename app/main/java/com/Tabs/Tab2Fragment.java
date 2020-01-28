package com.example.bahar.ivt.Activities.Tabs;

/**
 * Created by Bahar on 10/17/2018.
 */

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bahar.ivt.Activities.Sources.DictionaryData;
import com.example.bahar.ivt.Activities.Sources.DictionaryEntry;
import com.example.bahar.ivt.R;


public class Tab2Fragment extends Fragment {

    private TextView word, meaning, codingWord, codingExample;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_two, container, false);


        word = (TextView) view.findViewById(R.id.word);
        meaning = (TextView) view.findViewById(R.id.meaning);
        codingWord = (TextView) view.findViewById(R.id.codingWord);
        codingExample = (TextView) view.findViewById(R.id.codingExmp);


        DictionaryEntry myEntry = DictionaryData.getDefinition(getActivity().getIntent().getStringExtra("word"));
        if (myEntry != null) {
            word.setText(myEntry.getWord());
            meaning.setText(myEntry.getMeaning());
            codingWord.setText(myEntry.getCodingWord());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                codingExample.setText(Html.fromHtml(myEntry.getCodingExample(),  Html.FROM_HTML_MODE_LEGACY), TextView.BufferType.SPANNABLE);
            } else {
                codingExample.setText(Html.fromHtml(myEntry.getCodingExample()), TextView.BufferType.SPANNABLE);
            }

        }

        return view;
    }
}