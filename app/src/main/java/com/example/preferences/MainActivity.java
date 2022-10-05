package com.example.preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSignin;
    EditText edtUsername, edtPass;
    CheckBox cbRemember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString().trim();
                String password = edtPass.getText().toString().trim();

                if(username.equals("khanhle")&& password.equals("1234")){
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Lỗi đăng nhập!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void Anhxa(){
        btnSignin = (Button) findViewById(R.id.buttonSignin);
        edtPass = (EditText) findViewById(R.id.edittextPassword);
        edtUsername = (EditText) findViewById(R.id.edittextUser);
        cbRemember = (CheckBox) findViewById(R.id.checkboxRemember);
    }
}