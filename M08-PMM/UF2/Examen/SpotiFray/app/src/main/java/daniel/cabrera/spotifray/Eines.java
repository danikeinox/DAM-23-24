package daniel.cabrera.spotifray;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Build;
import android.os.Bundle;

import daniel.cabrera.spotifray.R;

public class Eines extends AppCompatActivity implements CommMenu {
    Fragment[] elsFragments;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eines);
        elsFragments=new Fragment[2];
        elsFragments[0]=new MusicPlayer();
        elsFragments[1]=new Menu();
        Bundle extras=getIntent().getExtras();
        menu(extras.getInt("BotoPres"));
    }
    public void menu(int qBoto) {
        FragmentManager mFragment = getSupportFragmentManager();
        FragmentTransaction mTrans = mFragment.beginTransaction();

        Fragment menu_iluminat = new Menu();
        Bundle dades = new Bundle();
        dades.putInt("BotoP", qBoto);
        menu_iluminat.setArguments(dades);
        mTrans.replace(R.id.menu, menu_iluminat);


        mTrans.replace(R.id.eines, elsFragments[qBoto]);
        mTrans.commit();
    }

}