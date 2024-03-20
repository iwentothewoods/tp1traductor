package com.lunasoft.tp1traducir;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class MainActivityViewModel extends AndroidViewModel {

    private Context context;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    //primero se chequea que hayan ingresado una palabra, si se dejó un espacio en blanco
    //aparece un pop up para avisarle al usuario que primero ingrese una palabra
    public void enviar (String palabra){
        if (palabra.length() == 0 ){
            Toast.makeText(context, "Ingrese una palabra", Toast.LENGTH_SHORT).show();
        } else {
            //Se crea el intent y se envía la palabra ingresada con el putExtra a la activity de traducción
            Intent intent = new Intent(context, com.lunasoft.tp1traducir.TraduccionActivity.class);
            intent.putExtra("palabra", palabra);
            intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}
