package com.servicios.servicios;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import com.servicios.R;

public class MiService extends Service {
    MediaPlayer musica;
    public MiService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("miService","Creando el servicio");
        musica=MediaPlayer.create(this, R.raw.prueba);
        musica.setLooping(true);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("miService", "......inicia el servicio......");
        //tareaEjecutar();
        musica.start();
        return  START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("miService",".............Para el servicio...........");
        musica.stop();
    }
    private void tareaEjecutar(){
        for (int i=0;i<100; i++){
            Log.i("miService","........"+i);
            try{
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}