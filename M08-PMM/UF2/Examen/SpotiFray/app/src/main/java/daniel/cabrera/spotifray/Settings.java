package daniel.cabrera.spotifray;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Settings extends AppCompatActivity implements CommMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }
    public void menu(int qBoto){
        Intent in=new Intent(this,Eines.class);
        in.putExtra("BotoPres",qBoto);
        startActivity(in);
    }
}