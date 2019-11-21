package com.asociacion.ferias.cultura.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;


import com.asociacion.ferias.R;
import com.asociacion.ferias.cultura.vista_cultura;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static Fragment newInstance(int index) {
        Fragment fragment = null;
        switch (index){
            case 1:fragment=new vista_cultura(1); break;
            case 2:fragment=new vista_cultura(2); break;
            case 3:fragment=new vista_cultura(3); break;
            case 4:fragment=new vista_cultura(4); break;
            case 5:fragment=new vista_cultura(5); break;
            case 6:fragment=new vista_cultura(6); break;
            case 7:fragment=new vista_cultura(7); break;
            case 8:fragment=new vista_cultura(8); break;
            case 9:fragment=new vista_cultura(9); break;
            case 10:fragment=new vista_cultura(10); break;
            case 11:fragment=new vista_cultura(11); break;

        }
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_lista__cultura, container, false);
        final TextView textView = root.findViewById(R.id.section_label);
        pageViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}