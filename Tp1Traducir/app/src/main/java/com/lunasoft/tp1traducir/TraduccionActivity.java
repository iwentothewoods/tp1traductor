package com.lunasoft.tp1traducir;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.lunasoft.tp1traducir.databinding.ActivityTraduccionBinding;

public class TraduccionActivity extends AppCompatActivity {

    private TraduccionActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ActivityTraduccionBinding binding = ActivityTraduccionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(TraduccionActivityViewModel.class);
        Intent intent = getIntent();
        String pal = (String) intent.getStringExtra("palabra");

        //Acá seteamos dinámicamente la imagen y la traducción según lo que el usuario ingrese
        vm.getPalabraM().observe(this, new Observer<Palabra>() {
            @Override
            public void onChanged(Palabra palabra) {
                binding.tvPalabraIngles.setText(palabra.getIngles());
                binding.imgPalabra.setImageResource(palabra.getFoto());
            }
        });

        //Acá llamamos al método buscar y le enviamos la palabra que recibimos con el intent
        //desde la MainActivity
        vm.buscar(pal);
    }

    //Volvemos a la vista inicial
    public void Volver(View view){
        finish();
    }
}
