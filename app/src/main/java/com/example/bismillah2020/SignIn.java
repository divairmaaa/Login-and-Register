package com.example.bismillah2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import android.content.SharedPreferences;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignIn extends AppCompatActivity {
    private EditText name, password;
    private Button login;
    private TextView regist;
    private static String URL_LOGIN = Server.URL + "login.php";
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        sessionManager = new SessionManager(getApplicationContext());

        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        regist = findViewById(R.id.regist);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mName = name.getText().toString().trim();
                String mPassword = password.getText().toString().trim();

                if(mName.isEmpty()){
                    name.setError("Username is empty.");
                }else if(mPassword.isEmpty()) {
                    password.setError("Password is empty.");
                }else{
                    Login(mName, mPassword);
                }
            }
        });


        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignIn.this, SignUp.class));
            }
        });
    }

    private void Login(final String name, final String password) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    try{
                        JSONObject jsonObject = new JSONObject(response);
                        String success = jsonObject.getString("success");
                        JSONArray jsonArray = jsonObject.getJSONArray("login");

                        if(success.equals("1")){
                            for (int i = 0; i < jsonArray.length(); i++){

                                JSONObject object = jsonArray.getJSONObject(i);

                                String name = object.getString("name").trim();
                                String email = object.getString("email").trim();

                                //masuk session
                                //sessionManager.createSession();
                                Toast.makeText(SignIn.this, "Login Success!", Toast.LENGTH_SHORT).show();


                                //masuk ke home
                                Intent intent = new Intent(SignIn.this, Home.class);
                                finish();
                                startActivity(intent);
                            }
                        }
                    }catch (JSONException e){
                        e.printStackTrace();
                        Toast.makeText(SignIn.this, "Error " + e.toString(), Toast.LENGTH_SHORT).show();
                    }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SignIn.this, "Error " + error.toString(), Toast.LENGTH_SHORT).show();

                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name", name);
                params.put("password", password);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
