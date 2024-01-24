package daniel.cabrera.spotifray;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class ServeiMusica extends Service {
    MediaPlayer mRep;
    public void onCreate(){
        super.onCreate();
        mRep=MediaPlayer.create(getApplicationContext(), R.raw.musicon);
        mRep.setLooping(true);
        mRep.setVolume(100,100);

    }
    public int onStartCommand(Intent intent, int flags, int startId){
        mRep.start();
        return START_STICKY;
    }
    public void onDestroy(){
        super.onDestroy();
        if(mRep.isPlaying()) mRep.stop();
        mRep.release();
        mRep=null;
    }
    public IBinder onBind(Intent intent){
        return null;
    }
}