package udb.sv.com.analisisresultados.Vista;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import udb.sv.com.analisisresultados.R;

public class Temperatura extends AppCompatActivity {

    EditText temperatura;
    Button btnEvaluarTemperatura;
    TextView tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura);

        temperatura = (EditText) findViewById(R.id.temperatura);
        tvDescription = (TextView) findViewById(R.id.tvDescripcion);
        btnEvaluarTemperatura = (Button) findViewById(R.id.btnEvaluarTemperatura);


        btnEvaluarTemperatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double temperaturaDouble = 0;

                try{
                    temperaturaDouble = Double.parseDouble(temperatura.getText().toString());
                }catch (Exception e){
                    Toast.makeText(Temperatura.this,"Error en temperatura", Toast.LENGTH_SHORT).show();
                    return;
                }

                String mensajeDescripcion = "";
                int color = Color.BLACK;

                if(temperaturaDouble<=0){
                    mensajeDescripcion="Temperatura de congelación";
                    color = Color.BLUE;
                }else if(temperaturaDouble > 0 && temperaturaDouble <10){
                    mensajeDescripcion="Hace Frio";
                    color = Color.rgb(0,215,255);
                }else if(temperaturaDouble >= 10 && temperaturaDouble <25) {
                    mensajeDescripcion = "Clima Agradable";
                    color = Color.GREEN;
                }else if(temperaturaDouble >= 25 && temperaturaDouble <40){
                    mensajeDescripcion = "Hace Calor";
                    color = Color.YELLOW;
                }else{
                    mensajeDescripcion = "Algo malo pasa...";
                    color = Color.RED;
                }

                tvDescription.setText(mensajeDescripcion);
                tvDescription.setBackgroundColor(color);
            }
        });

    }
}
