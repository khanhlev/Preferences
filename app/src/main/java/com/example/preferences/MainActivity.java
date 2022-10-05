package com.example.preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
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

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();
        sharedPreferences = getSharedPreferences("dataLogin",MODE_PRIVATE);

        //Lấy giá trị
        edtUsername.setText((sharedPreferences.getString("taikhoan", "")));
        edtPass.setText(sharedPreferences.getString("matkhau",""));
        cbRemember.setChecked(sharedPreferences.getBoolean("checked", false));



        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString().trim();
                String password = edtPass.getText().toString().trim();

                if(username.equals("khanhle")&& password.equals("1234")){
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công.", Toast.LENGTH_SHORT).show();
                    //Nếu có check
                    if(cbRemember.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("taikhoan",username);
                        editor.putString("matkhau", password);
                        editor.putBoolean("chechked",true);
                        editor.commit();
                    }else{
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("taikhoan");
                        editor.remove("matkhau");
                        editor.remove("checked");
                        editor.commit();
                    }
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