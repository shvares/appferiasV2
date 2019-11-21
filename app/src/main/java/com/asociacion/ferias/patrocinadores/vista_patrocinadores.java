package com.asociacion.ferias.patrocinadores;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.asociacion.ferias.R;
import com.asociacion.ferias.conciertos.vista_conciertos;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
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

    private TextView informacion;

    private OnFragmentInteractionListener mListener;

    private int patrocinador;

    private   String FACEBOOK_URL = "https://www.facebook.com/Mulinik-2633364246733665";
    private   String FACEBOOK_PAGE_ID = "2633364246733665";

    private  String lugar = "Descripcion";
    public vista_patrocinadores(int patrocinador) {
        // Required empty public constructor
        this.patrocinador =  patrocinador;
    }

    public static class info {

        public String descripcion1;
        public String facebook1;
        public String idpagina1;
        public String logo1;


        public info(){

        }
    }

    public class feria{
        private String descripcion;
        private String facebook;
        private String idpagina;
        private String logo;


        public feria(){

        }

        public void datos(String descripcion, String facebook, String idpagina, String logo) {
            this.descripcion = descripcion;
            this.facebook = facebook;
            this.idpagina = idpagina;
            this.logo = logo;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public String getFacebook() {
            return facebook;
        }

        public String getIdpagina() {
            return idpagina;
        }



        public String getLogo() {
            return logo;
        }

    }
    feria pantalla1 = new feria();
    feria pantalla2 = new feria();
    feria pantalla3 = new feria();

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment vista_patrocinadores.
     */
    // TODO: Rename and change types and number of parameters
    public static vista_patrocinadores newInstance(int param1, String param2) {
        vista_patrocinadores fragment = new vista_patrocinadores(param1);
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
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
        informacion = vista.findViewById(R.id.info);

        informacion.setText("Descripcion");

        String url = "https://www.mrthink.es/wp-content/uploads/bfi_thumb/foto_mr.-think_blog_la-importancia-del-logo-32kclavus35t2vcikjco8xql1eviv9vku2sb4pxw28ov9n66g.jpg";
        switch (patrocinador){
            case 1:
                url = "https://firebasestorage.googleapis.com/v0/b/zunil-8cbba.appspot.com/o/patrocinadores%2F%C3%ADndice.jpg?alt=media&token=4c29cf1e-bdbb-4868-b00c-14f3b80b801f";
                FACEBOOK_URL = "https://www.facebook.com/IK-CAF%C3%88-355137874873158/";
                FACEBOOK_PAGE_ID = "355137874873158";
                break;
            case 2:
                url = "https://firebasestorage.googleapis.com/v0/b/zunil-8cbba.appspot.com/o/patrocinadores%2F%C3%ADndice2.jpg?alt=media&token=93db0d70-1082-4de6-a78c-f67f1bba2bef";
                FACEBOOK_URL = "https://www.facebook.com/IK-CAF%C3%88-355137874873158/";
                FACEBOOK_PAGE_ID = "355137874873158";
                break;
            case 3:
                url = "https://www.mrthink.es/wp-content/uploads/bfi_thumb/foto_mr.-think_blog_la-importancia-del-logo-32kclavus35t2vcikjco8xql1eviv9vku2sb4pxw28ov9n66g.jpg";
                FACEBOOK_URL = "https://www.facebook.com/Mulinik-2633364246733665";
                FACEBOOK_PAGE_ID = "2633364246733665";
                break;
        }

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

    @Override
    public void onStart() {
        super.onStart();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final Query Ref = database.getReference("patrocinadores").limitToFirst(1);
        Ref.orderByChild("descripcion1").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                info inform = dataSnapshot.getValue(info.class);

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

            // ...
        });

    }

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

        switch(patrocinador){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
        LatLng sydney = new LatLng(lat,longi);
        mMap.addMarker(new MarkerOptions().position(sydney).title(lugar));
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
