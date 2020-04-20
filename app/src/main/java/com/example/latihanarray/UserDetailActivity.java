package com.example.latihanarray;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class UserDetailActivity extends AppCompatActivity {
    private TextView tvNama, tvJenisKelamin, tvPekerjaan;
    private UserModel userModel;
//    private int idPemesanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        init();

        tvNama.setText(userModel.getNamaStr());
        tvJenisKelamin.setText(userModel.getJenisKelaminStr());
        tvPekerjaan.setText(userModel.getPekerjaanStr());
    }

    private void init(){
        tvNama = findViewById(R.id.tvNama);
        tvJenisKelamin = findViewById(R.id.tvJenisKelamin);
        tvPekerjaan = findViewById(R.id.tvPekerjaan);

        userModel = getIntent().getParcelableExtra("currUser");
//        idPemesanan = getIntent().getIntExtra("id_pemesanan", 0);
    }
}
