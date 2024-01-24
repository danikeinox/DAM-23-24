package daniel.cabrera.einesmenu;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;

public class Eines extends AppCompatActivity implements CommMenu, ManeigFlash {
    Fragment[] elsFragments;
    CameraManager mCamera;
    private String idCamera;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eines);
        elsFragments=new Fragment[3];
        elsFragments[0]=new Lot();
        elsFragments[1]=new Nivell();
        elsFragments[2]=new Musica();
        Bundle extras=getIntent().getExtras();
        menu(extras.getInt("BotoPres"));
        mCamera=((CameraManager) getSystemService(Context.CAMERA_SERVICE));
        try {
            idCamera = mCamera.getCameraIdList()[0];
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void menu(int qBoto){
        FragmentManager mFragment = getSupportFragmentManager();
        FragmentTransaction mTrans = mFragment.beginTransaction();

        Fragment menu_iluminat = new Menu();
        Bundle dades = new Bundle();
        dades.putInt("BotoP",qBoto);
        menu_iluminat.setArguments(dades);
        mTrans.replace(R.id.menu,menu_iluminat);


        mTrans.replace(R.id.eines, elsFragments[qBoto]);
        mTrans.commit();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onOffFlash(boolean eFlash){
        try{
            mCamera.setTorchMode(idCamera, eFlash);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}