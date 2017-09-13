package udb.sv.com.analisisresultados.Vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import udb.sv.com.analisisresultados.R;

public class Comeplementario4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comeplementario4);
    }

    //metodo de un boton que no realiza operaciones
    public void mostrarMensasje(View v){
        Toast.makeText(Comeplementario4.this,"Este botón no tiene implementacion",Toast.LENGTH_SHORT).show();
    }

    public void llamada(View v){

        Intent intent = new Intent(Comeplementario4.this,Caller.class);
        startActivity(intent);

    }
    public void login(View v){

        Intent intent = new Intent(Comeplementario4.this,Login.class);
        startActivity(intent);

    }
    public void temperatura(View v){

        Intent intent = new Intent(Comeplementario4.this,Temperatura.class);
        startActivity(intent);

    }

}
