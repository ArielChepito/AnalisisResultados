package udb.sv.com.analisisresultados.Vista;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import udb.sv.com.analisisresultados.R;

public class Login extends AppCompatActivity {

    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);

    }

    public void login(View v){

        String emailString, passwordString;

        emailString = email.getText().toString();
        passwordString = password.getText().toString();


        if(emailString.equals("estudiantes@udb.edu.sv") && passwordString.equals("udb")){

            Toast.makeText(Login.this,"WELCOME", Toast.LENGTH_SHORT).show();

            email.setText("");
            password.setText("");

        }else{

            Toast.makeText(Login.this,"Usuario or Password invalid", Toast.LENGTH_SHORT).show();

        }

    }



}
