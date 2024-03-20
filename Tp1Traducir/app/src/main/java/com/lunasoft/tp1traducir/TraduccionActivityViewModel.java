package com.lunasoft.tp1traducir;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class TraduccionActivityViewModel extends AndroidViewModel {

    private Context context;
    private List<Palabra> bd = new ArrayList<>();
    private MutableLiveData<Palabra> traduccion;
    public TraduccionActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();

        bd.add(new Palabra("pajaro", "bird", R.drawable.bird));
        bd.add(new Palabra("mariposa", "butterfly", R.drawable.butterfly));
        bd.add(new Palabra("gato", "cat", R.drawable.cat));
        bd.add(new Palabra("perro", "dog", R.drawable.dog));
        bd.add(new Palabra("perezoso", "sloth", R.drawable.sloth));
        bd.add(new Palabra("oveja", "sheep", R.drawable.sheep));
        bd.add(new Palabra("ballena", "whale", R.drawable.whale));
    }

    //En este método se busca la palabra en la Lista de Palabras que tratamos de "base de datos"
    //si la palabra se encuentra, se muestra un mensaje diciendo que la palabra no existe en la BD
    //si la palabra está en la BD, se setea en MutableLiveData<Palabra>
    public void buscar(String pal) {
        boolean flag = true;
        for (Palabra palabra: bd){
            if (palabra.getEspanol().equals(pal)){
                traduccion.setValue(palabra);
                flag = false;
            }
        }
        if (flag){
            Palabra noexiste = new Palabra("noexiste", "No encontramos su palabra", R.drawable.error);
            traduccion.setValue(noexiste);
        }
    }

    public LiveData<Palabra> getPalabraM() {
        if (traduccion == null) {
            traduccion= new MutableLiveData<Palabra>();
        }
        return traduccion;
    }

}
