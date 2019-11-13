package com.asociacion.ferias.patrocinadores;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.asociacion.MapsActivity;
import com.asociacion.ferias.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.asociacion.ferias.*;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link vista_patrocinadores.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link vista_patrocinadores#newInstance} factory method to
 * create an instance of this fragment.
 */
public class vista_patrocinadores extends Fragment implements OnMapReadyCallback {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private MapView mapView;
    private GoogleMap mMap;
    private Double lat = 14.8382166;
    private Double longi = -91.5067797;
    private Button btnfb;

    private ImageView imageView;

    private OnFragmentInteractionListener mListener;

    public vista_patrocinadores() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment vista_patrocinadores.
     */
    // TODO: Rename and change types and number of parameters
    public static vista_patrocinadores newInstance(String param1, String param2) {
        vista_patrocinadores fragment = new vista_patrocinadores();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_vista_patrocinadores, container, false);
        btnfb = vista.findViewById(R.id.btnfb);
        mapView = vista.findViewById(R.id.mapa);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        imageView = vista.findViewById(R.id.imageViewPa1);


        String url = "https://www.mrthink.es/wp-content/uploads/bfi_thumb/foto_mr.-think_blog_la-importancia-del-logo-32kclavus35t2vcikjco8xql1eviv9vku2sb4pxw28ov9n66g.jpg";

        Picasso.get().load(url).resize(2500,1600).into(imageView);

        btnfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
                String facebookUrl = getFacebookPageURL(getContext());
                facebookIntent.setData(Uri.parse(facebookUrl));
                startActivity(facebookIntent);
            }
        });

        return vista;
    }

    public static String FACEBOOK_URL = "https://www.facebook.com/Mulinik-2633364246733665";
    public static String FACEBOOK_PAGE_ID = "2633364246733665";

    //método que obtiene la verdadera URL
    public  String getFacebookPageURL(Context context) {
        try {
            int versionCode = context.getPackageManager().getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850) { //versiones nuevas de facebook
                return "fb://facewebmodal/f?href=" + FACEBOOK_URL;
            } else { //versiones antiguas de fb
                return "fb://page/" + FACEBOOK_PAGE_ID;
            }
        } catch (Exception e) {
            return FACEBOOK_URL; //normal web url
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(lat,longi);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Aqui trabajop"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 17));
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
