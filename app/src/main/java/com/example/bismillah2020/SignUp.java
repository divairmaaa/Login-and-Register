package com.example.bismillah2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {
    private EditText name, email, password;
    private Button regist;
    private TextView sign;
    private static String URL_REGIST = Server.URL + "register.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name = findViewById(R.id.nama);
        email = findViewById(R.id.emaill);
        password = findViewById(R.id.pass);
        regist = findViewById(R.id.buat);
        sign = findViewById(R.id.signin);

        regist.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                if(name.getText().toString().length()==0){
                    name.setError("Username is empty.");
                }else if(email.getText().toString().length()==0) {
                    email.setError("Email is empty.");
                }else if(password.getText().toString().length()==0) {
                    password.setError("Password is empty.");
                }else{
                    Regist();
                }
            }

        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this, SignIn.class));
            }
        });
    }

    private void Regist() {
        final String name = this.name.getText().toString().trim();
        final String email = this.email.getText().toString().trim();
        final String password = this.password.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGIST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    try{
                        JSONObject jsonObject= new JSONObject(response);
                        String success = jsonObject.getString("success");

                        if(success.equals("1")){
                            Toast.makeText(SignUp.this,"Register Success!", Toast.LENGTH_SHORT).show();

                            // Memanggil signin
                            Intent intent = new Intent(SignUp.this, SignIn.class);
                            finish();
                            startActivity(intent);
                            Toast.makeText(SignUp.this,"Login with your account!", Toast.LENGTH_SHORT).show();

                        }
                    } catch (JSONException e){
                        e.printStackTrace();
                        Toast.makeText(SignUp.this,"Register Error! " + e.toString(), Toast.LENGTH_SHORT).show();
                    }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SignUp.this,"Register Error! " + error.toString(), Toast.LENGTH_SHORT).show();

                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name", name);
                params.put("email", email);
                params.put("password", password);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
