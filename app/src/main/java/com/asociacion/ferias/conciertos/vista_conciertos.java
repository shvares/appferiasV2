package com.asociacion.ferias.conciertos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.asociacion.ferias.R;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link vista_conciertos.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link vista_conciertos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class vista_conciertos extends Fragment {
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

    public static class info {

        public String descripcion1, descripcion2, descripcion3;
        public String titulo1, titulo2, titulo3;
        public String url1, url2, url3;


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

    private OnFragmentInteractionListener mListener;

   /* public vista_conciertos(String nombre_event, String url, String act) {

        evento = nombre_event;
        urlEvento = url;
        desEvento = act;

    }*/
    public vista_conciertos(int pantalla){
        this.pantalla=pantalla;
    }

    feria pantalla1 = new feria();
    feria pantalla2 = new feria();
    feria pantalla3= new feria();

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment vista_conciertos.
     */
    // TODO: Rename and change types and number of parameters
    public static vista_conciertos newInstance(int param1) {
        vista_conciertos fragment = new vista_conciertos(param1);
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
           // mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vistaConcierto = inflater.inflate(R.layout.fragment_vista_conciertos, container, false);

        imageView = vistaConcierto.findViewById(R.id.imageConcierto);
        titulo = vistaConcierto.findViewById(R.id.txt_titulo_concierto);
        descrip = vistaConcierto.findViewById(R.id.descript_concierto);

        titulo.setText("Hola");
        descrip.setText("Ejemplo");
        String url = "";

        switch (pantalla){
            case 1:
                pantalla1.setUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ1vQ4oaSCVsDvQsppuoG-9Rt2kdy9F6ji9vjtoBub_mEBUjWUT8w&s");
                url = pantalla1.getUrl();
                titulo.setText("Primera pantalla");
                descrip.setText("Descripcion1");
                break;
            case 2:
                pantalla2.setUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ1vQ4oaSCVsDvQsppuoG-9Rt2kdy9F6ji9vjtoBub_mEBUjWUT8w&s");
                url = pantalla2.getUrl();
                titulo.setText("Segunda pantalla");
                descrip.setText("Descripcion2");
                break;
            case 3:
                pantalla3.setUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ1vQ4oaSCVsDvQsppuoG-9Rt2kdy9F6ji9vjtoBub_mEBUjWUT8w&s");
                url = pantalla3.getUrl();
                titulo.setText("Tercera pantalla");
                descrip.setText("Descripcion3");
                break;
        }

        Picasso.get().load(url).resize(1500,1600).into(imageView);

        return vistaConcierto;
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
