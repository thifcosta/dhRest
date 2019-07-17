package com.example.dh_rest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dh_rest.util.Constantes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private Button botaoPseudoLogin;
    private EditText emailLogin;
    private EditText nomeLogin;
    private EditText senhaLogin;
    private CheckBox loginSalvarCheck;
    private Button botaoInutil01;
    private Button botaoInutil02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        botaoPseudoLogin = findViewById(R.id.pseudo_login_button);
        nomeLogin = findViewById(R.id.login_nome);
        emailLogin = findViewById(R.id.login_email);
        senhaLogin = findViewById(R.id.login_senha);
        botaoInutil01 = findViewById(R.id.botao_inutil_01);
        botaoInutil02 = findViewById(R.id.botao_inutil_02);
        loginSalvarCheck = findViewById(R.id.login_checkbox);

        loginSalvarCheck.setChecked(true);

        SharedPreferences sharedPreferences = getSharedPreferences(Constantes.SHARED_PREFERENCES, Context.MODE_PRIVATE);
        nomeLogin.setText(sharedPreferences.getString(Constantes.NOME, ""));
        emailLogin.setText(sharedPreferences.getString(Constantes.EMAIL, ""));

        botaoPseudoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                conferirDados();
            }
        });

        botaoInutil01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "SEM EASTER EGGS POR ENQUANTO!", Toast.LENGTH_SHORT).show();
            }
        });

        botaoInutil02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "SEM EASTER EGGS POR ENQUANTO!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void logar() {

        Intent intent = new Intent(this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("NOME", nomeLogin.getText().toString());
        bundle.putString("EMAIL", emailLogin.getText().toString());
        intent.putExtras(bundle);

        // Usar shared prefs
        SharedPreferences sharedPreferences = getSharedPreferences(Constantes.SHARED_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(loginSalvarCheck.isChecked()){

            // Salvar dados atuais no shared prefs
            editor.putString(Constantes.NOME, nomeLogin.getText().toString());
            editor.putString(Constantes.EMAIL, emailLogin.getText().toString());

        }else{

            // Apagar dados do shared prefs
            editor.putString(Constantes.NOME, null);
            editor.putString(Constantes.EMAIL, null);

        }

            editor.commit();

        startActivity(intent);

    }

    private void conferirDados(){

        int gotRight = 0;
        nomeLogin.setError(null);
        emailLogin.setError(null);
        senhaLogin.setError(null);

        String nomeLoginTxt = nomeLogin.getText().toString();
        String emailLoginTxt = emailLogin.getText().toString();
        String senhaLoginTxt = senhaLogin.getText().toString();

        if (nomeLoginTxt.trim().length()>=3){
            gotRight = gotRight+1;
        }else{
            nomeLogin.setError("O seu nome deve ter no mínimo 3 caracteres");
        }

        if (emailValido(emailLoginTxt)){
            gotRight = gotRight+1;
        }else{
            emailLogin.setError("Digite um e-mail válido");
        }

        if(senhaLoginTxt.trim().length()>0){
            gotRight = gotRight+1;
        }else{
//            senhaLogin.setError("Digite qualquer coisa, só não deixe este espaço em branco :)");
            gotRight = gotRight+1;
        }

        if (gotRight==3){
            logar();
        }

    }

    // conferir se o email é valido
    public static boolean emailValido(String email) {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }

}
