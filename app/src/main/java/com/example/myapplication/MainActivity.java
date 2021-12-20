package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText txtUserName, txtPassword;
    Button btnDangNhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUserName = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPass);
        btnDangNhap = findViewById(R.id.btnLogin);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServiceAPI.serviceAPI.getListUsers().enqueue(new Callback<List<User>>() {

                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                        for (User user: response.body()) {
                            if(user.getUserName().equalsIgnoreCase(txtUserName.getText().toString())&&user.getPassWord().equalsIgnoreCase(txtPassword.getText().toString())){
                                Intent intent = new Intent(MainActivity.this, ScreenTransfer.class);
                                startActivity(intent);
                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {

                    }
                });
            }
        });
 //      btnList.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ApiService.apiService.getBills().enqueue(new Callback<List<Bill>>() {
//                    @Override
//                    public void onResponse(Call<List<Bill>> call, Response<List<Bill>> response) {
//                        if(response.body()!=null){
//                            bills = response.body();
//                            tv.setText(bills+"");
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<Bill>> call, Throwable t) {
//
//                    }
//                });
//            }
//        });
    }
}