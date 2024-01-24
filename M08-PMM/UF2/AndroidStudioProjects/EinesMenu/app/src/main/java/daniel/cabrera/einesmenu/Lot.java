package daniel.cabrera.einesmenu;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Lot#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Lot extends Fragment {
    //CAMERA FLASH
    private ImageView botoFlash;
    private boolean flashOn;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Lot() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Lot.
     */
    // TODO: Rename and change types and number of parameters
    public static Lot newInstance(String param1, String param2) {
        Lot fragment = new Lot();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View fragmnt = inflater.inflate(R.layout.fragment_lot, container, false);
        //CAMERA FLASH
        botoFlash = (ImageView) fragmnt.findViewById(R.id.lot);
        botoFlash.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                flashOn = !flashOn;
                if (flashOn) {
                    botoApagarFlash();
                } else {
                    botoEncenFlash();
                }

            }


        });
        return fragmnt;
    }

    public void botoApagarFlash() {
        botoFlash.setImageResource(R.drawable.lot);
        Activity mAct = getActivity();
        ((ManeigFlash) mAct).onOffFlash(flashOn);
    }

    public void botoEncenFlash() {
        botoFlash.setImageResource(R.drawable.lot2);
        Activity mAct = getActivity();
        ((ManeigFlash) mAct).onOffFlash(flashOn);
    }
}