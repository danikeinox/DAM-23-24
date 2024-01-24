package daniel.cabrera.einesmenu;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Nivell#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Nivell extends Fragment implements SensorEventListener {
    private SensorManager sManager;
    private Sensor mSensor;
    private NivellPant pantalla;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Nivell() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Nivell.
     */
    // TODO: Rename and change types and number of parameters
    public static Nivell newInstance(String param1, String param2) {
        Nivell fragment = new Nivell();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sManager=(SensorManager)getActivity().getSystemService(Context.SENSOR_SERVICE);
        mSensor=sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        int costat = getResources().getDimensionPixelSize(R.dimen.maxim);
        pantalla=new NivellPant(getActivity(),costat);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_nivell, container, false);
        return pantalla;
    }
    public void onResume() {

        super.onResume();
        sManager.registerListener(this,mSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
    public void onPause(){
        super.onPause();
        sManager.unregisterListener(this);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        pantalla.angles(event.values);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}