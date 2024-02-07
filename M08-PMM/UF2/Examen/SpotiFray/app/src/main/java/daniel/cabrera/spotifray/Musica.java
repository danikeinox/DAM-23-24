package daniel.cabrera.spotifray;

import static java.util.ResourceBundle.getBundle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ResourceBundle;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Musica#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Musica extends Fragment {

    private static boolean musOn;

    private ImageView IMusica;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Musica() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param musOn Parameter 1.
     * @return A new instance of fragment Musica.
     */
    // TODO: Rename and change types and number of parameters
    public static Musica newInstance(boolean musOn) {
        Musica fragment = new Musica();
        Bundle args = new Bundle();
        args.putBoolean("musicaOnOff", musOn);
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
        View fragMus = inflater.inflate(R.layout.fragment_musica, container, false);
        IMusica = (ImageView) fragMus.findViewById(R.id.musica);

        // Recibe el estado de la música como argumento
        Bundle args = getArguments();
        if (args != null) {
            musOn = args.getBoolean("musicaOnOff", false);
        }

        return fragMus;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Actualiza la imagen de fondo del ImageView
        if (musOn) {
            IMusica.setImageResource(R.drawable.icon_big);
        } else {
            IMusica.setImageResource(R.drawable.icon_big);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}


// old
//
//    ImageView backgroundImg;
//    boolean musOn;
//    public void onCreate(){
//        super.onCreate();
//        ImageView bckImg = backgroundImg.findViewById(R.id.musica);
//        if (musOn){
//            bckImg.setBackgroundResource(R.drawable.musica2);
//            musOn=!musOn;
//        } else {
//            bckImg.setBackgroundResource(R.drawable.musica);
//            musOn=!musOn;
//        }
//    }