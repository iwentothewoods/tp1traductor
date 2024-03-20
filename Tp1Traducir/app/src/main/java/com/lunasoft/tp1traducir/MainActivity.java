package com.lunasoft.tp1traducir;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.lunasoft.tp1traducir.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private com.lunasoft.tp1traducir.MainActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(com.lunasoft.tp1traducir.MainActivityViewModel.class);

        //Le agregamos el On Click Listener al botón de traducir para que envíe el texto del Edit Text
        binding.btTraducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vm.enviar(binding.etPalabra.getText().toString());
            }
        });
    }

    public void Cerrar(View view){
        finishAffinity();
    }
}

/*
 --> Paso 1: MainActivity se inicia cuando se corre la app. Se infla la vista usando ActivityMainBinding,
y se crea una instancia de MainActivityViewModel.

 --> Paso 2: El usuario ingresa una palabra en español en el EditText y presiona el botón de traducir
(btTraducir). El OnClickListener del botón btTraducir guarda la palabra ingresada y la pasa al
método "enviar" del ViewModel (MainActivityViewModel).

 --> Paso 3: El método "enviar" verifica si el campo de texto está vacío. Si está vacío, se muestra
un Toast notificando al user que debe ingresar una palabra.
Si no está vacío, se crea un Intent para ir a TraduccionActivity, pasando la palabra como extra
en el Intent.

 --> Paso 4: En TraduccionActivity, se recupera la palabra enviada desde MainActivity a través del Intent.
Se crea una instancia de TraduccionActivityViewModel, y se inicia una observación sobre el LiveData
palabraM para cualquier cambio en la palabra traducida. Se llama al método "buscar" en el ViewModel
(TraduccionActivityViewModel), pasando la palabra recibida.

 --> Paso 5: El método "buscar" busca la palabra en la lista de palabras creadas (la "base de datos").
Si la encuentra, actualiza "traduccion" (un MutableLiveData<Palabra>) con la palabra
encontrada. Si no la encuentra, actualiza "traduccion" con un valor que muestra que la
palabra no se encontró.

 --> Paso 6: La actualización de "traduccion" en TraduccionActivityViewModel dispara la observación en
TraduccionActivity.La UI se actualiza con la traducción y la imagen correspondiente mediante el
Observer que cambia el texto de tvPalabraIngles y la imagen de imgPalabra.
*/
