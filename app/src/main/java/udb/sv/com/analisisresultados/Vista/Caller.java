package udb.sv.com.analisisresultados.Vista;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import udb.sv.com.analisisresultados.R;

public class Caller extends AppCompatActivity {

    EditText phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caller);

        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
    }

    public void callPhone(View v){
        Toast.makeText(Caller.this,"Iniciar llamada...", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phoneNumber.getText().toString()));

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            return;
        }

        startActivity(intent);
    }
}
