package com.asociacion.ferias.cultura;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.asociacion.ferias.R;
import com.asociacion.ferias.conciertos.vista_conciertos;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link vista_cultura.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link vista_cultura#newInstance} factory method to
 * create an instance of this fragment.
 */
public class vista_cultura extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private String evento;
    private String urlEvento;
    private String desEvento;

    private ImageView imageView;
    private TextView titulo;
    private  TextView descrip;

    private int pantalla;

    private OnFragmentInteractionListener mListener;

    public vista_cultura(int pantalla) {
        this.pantalla = pantalla;
        // Required empty public constructor
        /*evento = nombre_event;
        urlEvento = url;
        desEvento = act;*/
    }

    public static class info {

        public String descripcion1, descripcion2, descripcion3, descripcion4, descripcion5,
        descripcion6, descripcion7, descripcion8, descripcion9, descripcion10, descripcion11;
        public String titulo1, titulo2, titulo3, titulo4, titulo5, titulo6, titulo7, titulo8,
        titulo9, titulo10, titulo11;
        public String url1, url2, url3, url4, url5, url6, url7, url8, url9, url10, url11;


        public info(){

        }
    }
    public class  feria{
        private String descripcion;
        private String titulo;
        private String url;
        feria(){
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public String getTitulo() {
            return titulo;
        }
    }
    feria pantalla1 = new feria();
    feria pantalla2 = new feria();
    feria pantalla3 = new feria();
    feria pantalla4 = new feria();
    feria pantalla5 = new feria();
    feria pantalla6 = new feria();
    feria pantalla7 = new feria();
    feria pantalla8 = new feria();
    feria pantalla9 = new feria();
    feria pantalla10 = new feria();
    feria pantalla11 = new feria();
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment vista_cultura.
     */
    // TODO: Rename and change types and number of parameters
    public static vista_cultura newInstance(int param1, String param2, String param3) {
        vista_cultura fragment = new vista_cultura(param1);
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_vista_cultura, container, false);
        imageView = vista.findViewById(R.id.imageEvents);
        titulo = vista.findViewById(R.id.txt_titulo_events);
        descrip = vista.findViewById(R.id.descript_event);

        titulo.setText("Cargando...");
        descrip.setText("Asegurate de tener conexion a internet");
        String url = "https://cdn.pixabay.com/photo/2016/11/13/12/22/woman-1820868_960_720.jpg";

        Picasso.get().load(url).resize(1500,1600).into(imageView);

        return vista;
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final Query Ref = database.getReference("cultura").limitToFirst(1);
        Ref.orderByChild("descripcion1").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                info inform = dataSnapshot.getValue(info.class);

                switch (pantalla){
                    case 1: pantalla1.setUrl(inform.url1);
                        pantalla1.setDescripcion(inform.descripcion1);
                        pantalla1.setTitulo(inform.titulo1);
                        titulo.setText(pantalla1.getTitulo());
                        descrip.setText(pantalla1.getDescripcion());
                        Picasso.get().load(pantalla1.getUrl()).resize(1500,1600).into(imageView);
                        break;
                    case 2: pantalla2.setUrl(inform.url2);
                        pantalla2.setDescripcion(inform.descripcion2);
                        pantalla2.setTitulo(inform.titulo2);
                        titulo.setText(pantalla2.getTitulo());
                        descrip.setText(pantalla2.getDescripcion());
                        Picasso.get().load(pantalla2.getUrl()).resize(1500,1600).into(imageView);
                        break;
                    case 3: pantalla3.setUrl(inform.url3);
                        pantalla3.setDescripcion(inform.descripcion3);
                        pantalla3.setTitulo(inform.titulo3);
                        titulo.setText(pantalla3.getTitulo());
                        descrip.setText(pantalla3.getDescripcion());
                        Picasso.get().load(pantalla3.getUrl()).resize(1500,1600).into(imageView);
                        break;
                    case 4: pantalla4.setUrl(inform.url4);
                        pantalla4.setDescripcion(inform.descripcion4);
                        pantalla4.setTitulo(inform.titulo4);
                        titulo.setText(pantalla4.getTitulo());
                        descrip.setText(pantalla4.getDescripcion());
                        Picasso.get().load(pantalla4.getUrl()).resize(1500,1600).into(imageView);
                        break;
                    case 5: pantalla5.setUrl(inform.url5);
                        pantalla5.setDescripcion(inform.descripcion5);
                        pantalla5.setTitulo(inform.titulo5);
                        titulo.setText(pantalla5.getTitulo());
                        descrip.setText(pantalla5.getDescripcion());
                        Picasso.get().load(pantalla5.getUrl()).resize(1500,1600).into(imageView);
                        break;
                    case 6: pantalla6.setUrl(inform.url6);
                        pantalla6.setDescripcion(inform.descripcion6);
                        pantalla6.setTitulo(inform.titulo6);
                        titulo.setText(pantalla6.getTitulo());
                        descrip.setText(pantalla6.getDescripcion());
                        Picasso.get().load(pantalla6.getUrl()).resize(1500,1600).into(imageView);
                        break;
                    case 7: pantalla7.setUrl(inform.url7);
                        pantalla7.setDescripcion(inform.descripcion7);
                        pantalla7.setTitulo(inform.titulo7);
                        titulo.setText(pantalla7.getTitulo());
                        descrip.setText(pantalla7.getDescripcion());
                        Picasso.get().load(pantalla7.getUrl()).resize(1500,1600).into(imageView);
                        break;
                    case 8: pantalla8.setUrl(inform.url8);
                        pantalla8.setDescripcion(inform.descripcion8);
                        pantalla8.setTitulo(inform.titulo8);
                        titulo.setText(pantalla8.getTitulo());
                        descrip.setText(pantalla8.getDescripcion());
                        Picasso.get().load(pantalla8.getUrl()).resize(1500,1600).into(imageView);
                        break;
                    case 9: pantalla9.setUrl(inform.url9);
                        pantalla9.setDescripcion(inform.descripcion9);
                        pantalla9.setTitulo(inform.titulo9);
                        titulo.setText(pantalla9.getTitulo());
                        descrip.setText(pantalla9.getDescripcion());
                        Picasso.get().load(pantalla9.getUrl()).resize(1500,1600).into(imageView);
                        break;
                    case 10: pantalla10.setUrl(inform.url10);
                        pantalla10.setDescripcion(inform.descripcion10);
                        pantalla10.setTitulo(inform.titulo10);
                        titulo.setText(pantalla10.getTitulo());
                        descrip.setText(pantalla10.getDescripcion());
                        Picasso.get().load(pantalla10.getUrl()).resize(1500,1600).into(imageView);
                        break;
                    case 11: pantalla11.setUrl(inform.url11);
                        pantalla11.setDescripcion(inform.descripcion11);
                        pantalla11.setTitulo(inform.titulo11);
                        titulo.setText(pantalla11.getTitulo());
                        descrip.setText(pantalla11.getDescripcion());
                        Picasso.get().load(pantalla11.getUrl()).resize(1500,1600).into(imageView);
                        break;

                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                info inform = dataSnapshot.getValue(info.class);
                switch (pantalla){
                    case 1: pantalla1.setUrl(inform.url1);
                        pantalla1.setDescripcion(inform.descripcion1);
                        pantalla1.setTitulo(inform.titulo1);
                        titulo.setText(pantalla1.getTitulo());
                        descrip.setText(pantalla1.getDescripcion());
                        Picasso.get().load(pantalla1.getUrl()).resize(1500,1600).into(imageView);
                        break;
                    case 2: pantalla2.setUrl(inform.url2);
                        pantalla2.setDescripcion(inform.descripcion2);
                        pantalla2.setTitulo(inform.titulo2);
                        titulo.setText(pantalla2.getTitulo());
                        descrip.setText(pantalla2.getDescripcion());
                        Picasso.get().load(pantalla2.getUrl()).resize(1500,1600).into(imageView);
                        break;
                    case 3: pantalla3.setUrl(inform.url3);
                        pantalla3.setDescripcion(inform.descripcion3);
                        pantalla3.setTitulo(inform.titulo3);
                        titulo.setText(pantalla3.getTitulo());
                        descrip.setText(pantalla3.getDescripcion());
                        Picasso.get().load(pantalla3.getUrl()).resize(1500,1600).into(imageView);
                        break;
                    case 4: pantalla4.setUrl(inform.url4);
                        pantalla4.setDescripcion(inform.descripcion4);
                        pantalla4.setTitulo(inform.titulo4);
                        titulo.setText(pantalla4.getTitulo());
                        descrip.setText(pantalla4.getDescripcion());
                        Picasso.get().load(pantalla4.getUrl()).resize(1500,1600).into(imageView);
                        break;
                    case 5: pantalla5.setUrl(inform.url5);
                        pantalla5.setDescripcion(inform.descripcion5);
                        pantalla5.setTitulo(inform.titulo5);
                        titulo.setText(pantalla5.getTitulo());
                        descrip.setText(pantalla5.getDescripcion());
                        Picasso.get().load(pantalla5.getUrl()).resize(1500,1600).into(imageView);
                        break;
                    case 6: pantalla6.setUrl(inform.url6);
                        pantalla6.setDescripcion(inform.descripcion6);
                        pantalla6.setTitulo(inform.titulo6);
                        titulo.setText(pantalla6.getTitulo());
                        descrip.setText(pantalla6.getDescripcion());
                        Picasso.get().load(pantalla6.getUrl()).resize(1500,1600).into(imageView);
                        break;
                    case 7: pantalla7.setUrl(inform.url7);
                        pantalla7.setDescripcion(inform.descripcion7);
                        pantalla7.setTitulo(inform.titulo7);
                        titulo.setText(pantalla7.getTitulo());
                        descrip.setText(pantalla7.getDescripcion());
                        Picasso.get().load(pantalla7.getUrl()).resize(1500,1600).into(imageView);
                        break;
                    case 8: pantalla8.setUrl(inform.url8);
                        pantalla8.setDescripcion(inform.descripcion8);
                        pantalla8.setTitulo(inform.titulo8);
                        titulo.setText(pantalla8.getTitulo());
                        descrip.setText(pantalla8.getDescripcion());
                        Picasso.get().load(pantalla8.getUrl()).resize(1500,1600).into(imageView);
                        break;
                    case 9: pantalla9.setUrl(inform.url9);
                        pantalla9.setDescripcion(inform.descripcion9);
                        pantalla9.setTitulo(inform.titulo9);
                        titulo.setText(pantalla9.getTitulo());
                        descrip.setText(pantalla9.getDescripcion());
                        Picasso.get().load(pantalla9.getUrl()).resize(1500,1600).into(imageView);
                        break;
                    case 10: pantalla10.setUrl(inform.url10);
                        pantalla10.setDescripcion(inform.descripcion10);
                        pantalla10.setTitulo(inform.titulo10);
                        titulo.setText(pantalla10.getTitulo());
                        descrip.setText(pantalla10.getDescripcion());
                        Picasso.get().load(pantalla10.getUrl()).resize(1500,1600).into(imageView);
                        break;
                    case 11: pantalla11.setUrl(inform.url11);
                        pantalla11.setDescripcion(inform.descripcion11);
                        pantalla11.setTitulo(inform.titulo11);
                        titulo.setText(pantalla11.getTitulo());
                        descrip.setText(pantalla11.getDescripcion());
                        Picasso.get().load(pantalla11.getUrl()).resize(1500,1600).into(imageView);
                        break;

                }
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
