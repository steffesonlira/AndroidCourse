package com.cursoandroid.mioper;

//region IMPORT

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
//endregion

//region CLASSE EsqueciSenha
public class EsqueciSenha extends AppCompatActivity {

    //region declaração de variáveis
    private EditText email;
    private FirebaseAuth firebaseAuth;
    private Button buttonEsqueciSenha;
    private EditText userEmail;
    //endregion

    //region ONCREATE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esqueci_senha);
        firebaseAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.edtEsqueciSenhaId);
        buttonEsqueciSenha = findViewById(R.id.btnRecuperarSenhaId);


        // region click botão esqueci senha
        buttonEsqueciSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().equals("")) {
                    Toast.makeText(EsqueciSenha.this, "Favor inserir o e-mail para redefinição de senha"
                            , Toast.LENGTH_SHORT).show();
                    return;
                }
                //Enviar ao e-mail cadastrado no Firebase Auth um link com o formulário de recuperação de senha
                firebaseAuth
                        .sendPasswordResetEmail(email.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    final ProgressDialog progressDialog = new ProgressDialog(EsqueciSenha.this, R.style.AppCompatAlertDialogStyle);
                                    progressDialog.setIndeterminate(true);
                                    progressDialog.setIcon(R.drawable.logo);
                                    progressDialog.setTitle("Mioper");
                                    progressDialog.setMessage("Enviando e-mail para recuperação de senha...");
                                    progressDialog.show();

                                    new android.os.Handler().postDelayed(
                                            new Runnable() {
                                                public void run() {
                                                    progressDialog.dismiss();
                                                    Toast.makeText(EsqueciSenha.this, "Solicitação enviada com sucesso para o seu e-mail"
                                                            , Toast.LENGTH_SHORT).show();
                                                    startActivity(new Intent(EsqueciSenha.this, Login.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                                                    finish();
                                                }
                                            }, 2500);


                                } else {
                                    String excecao = "";
                                    try {
                                        throw task.getException();
                                    } catch (FirebaseAuthInvalidUserException e) {
                                        excecao = "Usuário não está cadastrado.";
                                    } catch (Exception e) {
                                        excecao = "Verifique sua conexão com a internet";
                                    }
                                    Toast.makeText(EsqueciSenha.this,
                                            excecao,
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                //endregion
            }
        });
        //endregion
    }
    //endregion

    //region METODO Criar requisição de Senha esquecida
    @Override
    protected void onResume() {
        super.onResume();
    }
    //endregion


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }
}