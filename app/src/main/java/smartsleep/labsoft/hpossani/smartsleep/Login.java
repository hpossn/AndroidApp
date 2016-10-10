package smartsleep.labsoft.hpossani.smartsleep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import smartsleep.labsoft.hpossani.smartsleep.users.Authenticator;
import smartsleep.labsoft.hpossani.smartsleep.users.User;

public class Login extends AppCompatActivity {

    private EditText username, password;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.loginEditText);
        password = (EditText) findViewById(R.id.passwordEditText);

        loginButton = (Button) findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                User u = new User(username.getText().toString(), password.getText().toString());

                Authenticator auth = new Authenticator(u);

               /* if(auth.authenticate()) {

                } else {
                    Log.d("AuthenticationResult", "Not authenticated");
                }*/

                //Log.d("Botao clicado", "clicou");

                auth.authenticate(getApplicationContext());


            }
        });
    }

    public static void logado() {
        Log.d("result", "user logado");
    }

    public static void naoLogado() {
        Log.d("result", "user nao logado");
    }
}
