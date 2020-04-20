package com.example.latihanarray;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<UserModel> userModelAr = new ArrayList<>();

    //Constructor RvAdapter
    public RvAdapter(Context mContext, ArrayList<UserModel> userModelAr) {
        this.mContext = mContext;
        this.userModelAr = userModelAr;
    }

    //class untuk memperkenalkan elemen dalam item card kepada adapter
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView namaTv, jenisJelaminTv, pekerjaanTv;
        private LinearLayout llItemCard;

        public ViewHolder(@NonNull View iv) {
            super(iv);
            namaTv = iv.findViewById(R.id.tvName);
            jenisJelaminTv = iv.findViewById(R.id.tvJenisKelamin);
            pekerjaanTv = iv.findViewById(R.id.tvPekerjaan);

            llItemCard = iv.findViewById(R.id.llItemCard);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Menyambungkan item card dengan adapter
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_card, parent, false);
        return new RvAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Get masing-masing user model dari user model array
        final UserModel um = userModelAr.get(position);
//        Pemesanan pemesanan = pemesanans.get(position);

        //Menampilkan isi dari usermodel ke dalam item card
        holder.namaTv.setText(um.getNamaStr());
        holder.jenisJelaminTv.setText(um.getJenisKelaminStr());
        holder.pekerjaanTv.setText(um.getPekerjaanStr());

        //Jika ingin item card bisa ditekan
        holder.llItemCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, UserDetailActivity.class);
                i.putExtra("currUser", um);
//                i.putExtra("id_pemesanan", pemesanan.getIdPemesanan());
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        //Get jumlah baris dalam array user model
        return userModelAr.size();
    }
}
