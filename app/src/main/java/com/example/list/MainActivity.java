package com.example.list;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvThucAn;
    ArrayList<ThucAn> arrayThucAn;
    ThucAnAdapter adapter;
    ImageView imgList, imgProfile, imgHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();

        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent imgprofile = new Intent(MainActivity.this, Profile.class);
                startActivity(imgprofile);
            }
        });
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent imghome = new Intent(MainActivity.this, Home.class);
                startActivity(imghome);
            }
        });


        adapter = new ThucAnAdapter(this, R.layout.dong_thuc_an, arrayThucAn);
        lvThucAn.setAdapter(adapter);

        lvThucAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, Detail.class);
                ThucAn thucAn = arrayThucAn.get(i);
                intent.putExtra("ten",thucAn.getTen());
                intent.putExtra("moTa",thucAn.getMoTa());
                intent.putExtra("hinh",thucAn.getHinh());
                startActivity(intent);
            }
        });

        lvThucAn.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Bạn có muốn xóa không");
                builder.setMessage("Hãy lựa chọn bên dưới để xác nhận");
                int vitri = i;
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        arrayThucAn.remove(vitri);
                        adapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
                return false;
            }
        });


    }

    private void Anhxa() {
        lvThucAn = (ListView) findViewById(R.id.listviewThucAn);
        arrayThucAn = new ArrayList<>();

        arrayThucAn.add(new ThucAn("Bún đậu mắm tôm", "Bún đậu Đà Nẵng", R.drawable.bundaumamtom));
        arrayThucAn.add(new ThucAn("Chân gà sả ớt","Đà Nẵng", R.drawable.changasatac));
        arrayThucAn.add(new ThucAn("Bánh tráng trộn","Đà Nẵng", R.drawable.banhtrangtron));
        arrayThucAn.add(new ThucAn("Mỳ cay", "Đà Nẵng", R.drawable.mycay));
        arrayThucAn.add(new ThucAn("Bánh mỳ nướng muối ớt","Đà Nẵng", R.drawable.banhmynuongmuoiot));

        imgProfile = (ImageView) findViewById((R.id.imageProfile));
        imgHome = (ImageView) findViewById(R.id.imageHome);
    }
}