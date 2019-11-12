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
            case 1:fragment=new vista_cultura("Evento Cultura No 1","https://cdn.pixabay.com/photo/2016/11/13/12/22/woman-1820868_960_720.jpg","Descripcion " +
                    "de la actividad numero uno de la seccion cultura del municipio de nahuala de la feria 2019 realizado por SAI"); break;
            case 2:fragment=new vista_cultura("Evento Cultura No 2","https://cdn.pixabay.com/photo/2017/01/28/02/24/japan-2014616_960_720.jpg","Descripcion " +
                    "de la actividad numero dos de la seccion cultura del municipio de nahuala de la feria 2019 realizado por MULINIK"); break;
            case 3:fragment=new vista_cultura("Evento Cultura No 3","https://cdn.pixabay.com/photo/2015/07/09/22/45/tree-838667_960_720.jpg","Descripcion " +
                    "de la actividad numero tres de la seccion cultura del municipio de nahuala de la feria 2019 realizado por MULINIK & SAI"); break;

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