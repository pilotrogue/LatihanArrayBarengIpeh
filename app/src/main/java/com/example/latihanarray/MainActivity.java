package com.example.latihanarray;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<UserModel> userModelArrayList = new ArrayList<>();
    private RecyclerView rvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        //Get data dummy
        userModelArrayList = generateUserDummy();

        //Membuat adapter untuk rvList
        RvAdapter rvAdapter = new RvAdapter(this, userModelArrayList);

        //Memasangkan adapter yang sudah dibuat untuk rvList
        rvList.setAdapter(rvAdapter);
        rvList.setLayoutManager(new GridLayoutManager(this, 3));
    }

    private void init(){
        rvList = findViewById(R.id.rvList);
    }

    private ArrayList<UserModel> generateUserDummy(){
        ArrayList<UserModel> userModels = new ArrayList<>();

        UserModel um1 = new UserModel("Rafi", "Laki-laki", "Galauin Mala");
        UserModel um2 = new UserModel("Reja", "Laki-laki", "Galauin Ipeh");
        UserModel um3 = new UserModel("Ipeh", "Perempuan", "Galauin Rafi");

        userModels.add(um1);
        userModels.add(um2);
        userModels.add(um3);

        return userModels;
    }
}
