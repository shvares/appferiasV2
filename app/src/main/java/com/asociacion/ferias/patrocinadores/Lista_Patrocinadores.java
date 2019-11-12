package com.asociacion.ferias.patrocinadores;

import android.net.Uri;
import android.os.Bundle;

import com.asociacion.ferias.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.asociacion.ferias.patrocinadores.ui.main.SectionsPagerAdapter;

public class Lista_Patrocinadores extends AppCompatActivity implements vista_patrocinadores.OnFragmentInteractionListener{

    ViewPager viewPager;
    private LinearLayout linearPuntos;
    private TextView[] puntosSlide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista__patrocinadores);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        linearPuntos=findViewById(R.id.idLinearPuntos);
        agregarIndicadorPuntos(0);
        viewPager.addOnPageChangeListener(viewListener);


    }

    private void agregarIndicadorPuntos(int pos) {
        puntosSlide = new TextView[3];
        linearPuntos.removeAllViews();

        for (int i =0;i<puntosSlide.length;i++){
            puntosSlide[i]=new TextView(this);
            puntosSlide[i].setText(Html.fromHtml("&#8226;"));
            puntosSlide[i].setTextSize(45);
            puntosSlide[i].setTextColor(getResources().getColor(R.color.colorblacoTransparente));
            linearPuntos.addView(puntosSlide[i]);

        }

        if (puntosSlide.length>0){
            puntosSlide[pos].setTextColor(getResources().getColor(R.color.colorBlanco));
        }
    }
    ViewPager.OnPageChangeListener viewListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int pos) {
            agregarIndicadorPuntos(pos);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}